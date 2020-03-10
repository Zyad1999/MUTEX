package org.ieeezsb;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;

import org.ieeezsb.Registration.LoginActivity;
import org.ieeezsb.agenda.AgendaActivity;
import org.ieeezsb.recommended.RecommendActivity;
import org.ieeezsb.speaker.SpeakersActivity;
import org.jetbrains.annotations.NotNull;

import static com.google.android.gms.common.util.CollectionUtils.listOf;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,  RatingDialogListener {
    private CardView btnFeedBack;
    private TextView hashtag;
    private ImageView mFaceBook;
    private ImageView mTwitter;
    private ImageView mLinkdin;
    private ImageView mInsta;
    private Toolbar myToolbar;
    private CardView sponsors, speakers, location, agenda;
    private ConstraintLayout infocons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeGUI();
        setSupportActionBar(myToolbar);
        infocons.setOnClickListener(this);
        mFaceBook.setOnClickListener(this);
        btnFeedBack.setOnClickListener(this);
        sponsors.setOnClickListener(this);
        speakers.setOnClickListener(this);
        location.setOnClickListener(this);
        agenda.setOnClickListener(this);
        hashtag.setOnClickListener(this);
        mTwitter.setOnClickListener(this);
        mLinkdin.setOnClickListener(this);
        mInsta.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.feedbackBtn:
                if (!haveConnectionToInternet()) {
                    noInternetToast();
                } else {
                    showRatingDialog();
                }
                break;
            case R.id.ivFacebook:
                if (!haveConnectionToInternet()) {
                    noInternetToast();
                } else {
                    startActivity(HelpersMethods.getOpenFacebookIntent(MainActivity.this));

                }
                break;
            case R.id.informationLayout:
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // User is signed in
                    intetentController(MainActivity.this, RecommendActivity.class);
                } else {
                    // No user is signed in
                    intetentController(MainActivity.this, LoginActivity.class);
                }
                break;
            case R.id.sponsorsButton:
                intetentController(MainActivity.this, ProfileActivity.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.speakers_button:
                intetentController(MainActivity.this, SpeakersActivity.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.location:
                intetentController(MainActivity.this, MapsActivity.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.agenda_button:
                intetentController(MainActivity.this, AgendaActivity.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.tvHashtag:
                Toast.makeText(MainActivity.this, "HashTag not implemented yet", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivTwitter:
                if (!haveConnectionToInternet()) {
                    noInternetToast();
                } else {
                    startActivity(HelpersMethods.openTwitterHandle(MainActivity.this));
                }
                break;
            case R.id.ivInstagram:
                Uri uri = Uri.parse(SocialMediaLinks.InstagramLink);
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(SocialMediaLinks.InstagramLink)));
                }
                if (!haveConnectionToInternet()) {
                    noInternetToast();
                    startActivity(likeIng);
                }
                break;
            case R.id.ivLinkedIn:
                if (!haveConnectionToInternet()) {
                    noInternetToast();
                } else {
                    startActivity(HelpersMethods.openLinked(MainActivity.this));
                }
                break;
        }
    }
    private void noInternetToast() {Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();}
    @Override
    public void onNegativeButtonClicked() {}
    @Override
    public void onNeutralButtonClicked() {}
    @Override
    public void onPositiveButtonClicked(int i, @NotNull String s) {
        FeedBackModel feedBackModel;
        final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        feedBackModel = new FeedBackModel(s,i);
        rootRef.child("ratings").child(generateRatingId()).setValue(feedBackModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Thanks for rating", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showRatingDialog(){
        new AppRatingDialog.Builder()
                .setPositiveButtonText("Submit")
                .setNegativeButtonText("Cancel")
                .setNeutralButtonText("Later")
                .setNoteDescriptions(listOf("Very Bad", "Not good", "Quite ok", "Very Good", "Excellent !!!"))
                .setDefaultRating(2)
                .setTitle("Rate MUTEX")
                .setDescription("Please select some stars and give your feedback")
                .setStarColor(R.color.starColor)
                .setNoteDescriptionTextColor(R.color.noteDescriptionTextColor)
                .setTitleTextColor(R.color.titleTextColor)
                .setDescriptionTextColor(R.color.descriptionTextColor)
                .setCommentTextColor(R.color.commentTextColor)
                .setCommentBackgroundColor(R.color.CommentBackground)
                .setWindowAnimation(R.style.MyDialogSlideHorizontalAnimation)
                .setHint("Please write your comment here")
                .setHintTextColor(R.color.hintTextColor)
                .setCancelable(false)
                .setCanceledOnTouchOutside(false)
                .create(this)
                .show();
    }

    private String generateRatingId(){long time= System.currentTimeMillis(); return "Rate" + time;}
    private void initializeGUI(){
        myToolbar = findViewById(R.id.my_toolbar);
        infocons = findViewById(R.id.informationLayout);
        mFaceBook = findViewById(R.id.ivFacebook);
        mTwitter = findViewById(R.id.ivTwitter);
        mLinkdin = findViewById(R.id.ivLinkedIn);
        mInsta = findViewById(R.id.ivInstagram);
        hashtag = findViewById(R.id.tvHashtag);
        btnFeedBack = findViewById(R.id.feedbackBtn);
        sponsors = findViewById(R.id.sponsorsButton);
        speakers = findViewById(R.id.speakers_button);
        location = findViewById(R.id.location);
        agenda = findViewById(R.id.agenda_button);
    }
    public  boolean haveConnectionToInternet() {
        boolean haveWifi = false;
        boolean haveMobileData = false;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();
        for (NetworkInfo info : networkInfos) {
            if (info.getTypeName().equalsIgnoreCase("wifi")) {
                if (info.isConnected()) {
                    haveWifi = true;
                }
            }

            if (info.getTypeName().equalsIgnoreCase("mobile")) {
                if (info.isConnected()) {
                    haveMobileData = true;
                }
            }
        }

        return haveMobileData || haveWifi;

    }
    private void intetentController(Context context, Class destination){
        startActivity(new Intent(context, destination));
    }

}

