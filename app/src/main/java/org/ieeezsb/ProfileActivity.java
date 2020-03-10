package org.ieeezsb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.ieeezsb.Registration.UserModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    private DatabaseReference mDatabase;
    private FirebaseStorage storage;
    private StorageReference imageStorageRef;
    private CircleImageView profileImage,  changeProfileImg;
    private Uri imageUri;
    private boolean changeImage;
    private TextView fName, lName, username,   faculty, whatsApp, fBUserName, bio, shortName;
    private UserModel user;
    private Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initializeGUI();
        changeImage = true;
        getUser();

        changeProfileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfileImage();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageUri != null) {

                    changeImage = true;

                    storage = FirebaseStorage.getInstance();
                    imageStorageRef = storage.getReference()
                            .child("ProfileImages/" + imageUri.getLastPathSegment());

                    imageStorageRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            imageStorageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    mDatabase.child("profilePicLink").setValue(uri.toString());
                                }
                            });


                        }
                    });
                }
                mDatabase.child("fName").setValue(fName.getText().toString().trim());
                mDatabase.child("lName").setValue(lName.getText().toString().trim());
                mDatabase.child("bio").setValue(bio.getText().toString().trim());
                mDatabase.child("username").setValue(username.getText().toString().trim());
                mDatabase.child("whatsapp").setValue(whatsApp.getText().toString().trim());
                mDatabase.child("faculty").setValue(faculty.getText().toString().trim());
                mDatabase.child("facebookLink").setValue(fBUserName.getText().toString().trim());

                Toast.makeText(ProfileActivity.this, "Changes Saved", Toast.LENGTH_SHORT).show();

            }
        });





    }


    private void initializeGUI(){
        fName = findViewById(R.id.tvFName);
        lName = findViewById(R.id.tvLName);
        username = findViewById(R.id.tvUsername);
        faculty = findViewById(R.id.tvFaculty);
        whatsApp = findViewById(R.id.tvWhatsapp);
        fBUserName = findViewById(R.id.tvFacebook);
        bio = findViewById(R.id.tvBio);
        changeProfileImg = findViewById(R.id.change_imageView);
        profileImage = findViewById(R.id.profile_img);
        shortName = findViewById(R.id.shortenName);
        saveBtn = findViewById(R.id.btnSave);
    }
    private void getUser(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null){
            String uID = currentUser.getUid();
            mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uID);
            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    user = dataSnapshot.getValue(UserModel.class);

                    fName.setText(user.getfName());
                    lName.setText(user.getlName());
                    username.setText(user.getUsername());
                    faculty.setText(user.getFaculty());
                    whatsApp.setText(user.getWhatsapp());
                    bio.setText(user.getBio());
                    fBUserName.setText(user.getFacebookLink());

                    if (changeImage) {
                        if (!user.getProfilePicLink().equals("null")) {
                            shortName.setVisibility(View.GONE);

                            Picasso.get().load(user.getProfilePicLink()).into(profileImage);

                        } else {
                            shortName.setVisibility(View.VISIBLE);
                            profileImage.setImageResource(R.color.colorPrimary);
                            shortName.setText(getShortName(user.getfName() + " " + user.getlName()));
                        }
                    }



                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }
    }

    private String getShortName(String fullName) {
        String shortName = "";
        String[] name = fullName.split(" ");

        shortName = shortName + name[0].substring(0, 1);
        shortName = shortName + name[name.length - 1].substring(0, 1);

        return shortName;
    }

    private void updateProfileImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && data != null) {

            imageUri = data.getData();
            profileImage.setImageURI(imageUri);
            changeImage = false;

        }


    }



}
