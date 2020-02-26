package org.ieeezsb.Registration;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.ieeezsb.Common;
import org.ieeezsb.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment1 extends Fragment {

    private TextView faculty, facebook, bio, whatsapp;
    private Button next;
    private CircleImageView profileImage;
    public static Uri imageUri;
    private DatabaseReference mDatabase;
    private FirebaseStorage storage;
    private StorageReference imageStorageRef;
    private static final int PICK_IMAGE = 1;
    public ProfileFragment1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_profile_fragment1, container, false);
        faculty = rootView.findViewById(R.id.tvFaculty);
        facebook = rootView.findViewById(R.id.tvFacebook);
        bio = rootView.findViewById(R.id.tvBio);
        next = rootView.findViewById(R.id.btnNext);
        whatsapp = rootView.findViewById(R.id.tvWhatsapp);
        profileImage = rootView.findViewById(R.id.ivProfilePc);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String inputFaculty = faculty.getText().toString().trim();
                final String inputFacebook = facebook.getText().toString().trim();
                final String inputBio = bio.getText().toString().trim();
                final String inputWhatsApp = whatsapp.getText().toString().trim();

                if (validateInput(inputFaculty, inputBio, inputFacebook, inputWhatsApp)){
                    Common.newUser.setFaculty(inputFaculty);
                    Common.newUser.setFacebookLink(inputFacebook);
                    Common.newUser.setBio(inputBio);
                    Common.newUser.setWhatsapp(inputWhatsApp);

                    if (imageUri != null){
                        storage = FirebaseStorage.getInstance();
                        imageStorageRef = storage.getReference().child("ProfileImages/" + imageUri.getLastPathSegment());

                        imageStorageRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                imageStorageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        //mDatabase.child("profileImage").setValue(uri.toString());
                                        Common.newUser.setProfilePicLink(uri.toString());
                                    }
                                });


                            }
                        });

                    }

                    replaceFragments(InterestsFragment.class);
                }





            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfileImage();
            }
        });

        return rootView;
    }

    private void updateProfileImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE && data != null) {
            imageUri = data.getData();
            profileImage.setImageURI(imageUri);


        }
    }

    private boolean validateInput(String inFaculty, String inBio, String inFacebookLink, String inWhatsapp){

        if(inFaculty.isEmpty()){
            faculty.setError("Faculty is empty.");
            return false;
        }
        if(inBio.isEmpty()){
            bio.setError("Bio is empty.");
            return false;
        }
        if(inFacebookLink.isEmpty()){
            facebook.setError("Facebook is empty.");
            return false;
        }

        if(inWhatsapp.isEmpty()){
            whatsapp .setError("Whatsapp is empty.");
            return false;
        }
        return true;
    }

    private void replaceFragments(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentFrame, fragment).commit();
    }

}
