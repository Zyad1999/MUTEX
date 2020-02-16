package org.ieeezsb;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hsalf.smilerating.SmileRating;

import life.sabujak.roundedbutton.RoundedButton;
import studio.carbonylgroup.textfieldboxes.ExtendedEditText;

public class FeedBackActivity extends AppCompatActivity {

    private SmileRating  overallRating;
    private RoundedButton feedbackSubmitBtn;
    private ExtendedEditText commentEditText;
    private FeedBackModel feedBackModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        overallRating = findViewById(R.id.ratingViewOverall);

        feedbackSubmitBtn = findViewById(R.id.btnFeedBackSubmit);
        commentEditText = findViewById(R.id.extended_edit_text);

        final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        feedbackSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedBackModel = new FeedBackModel(commentEditText.getText().toString(), overallRating.getRating());
                rootRef.child("ratings").child(generateRatingId()).setValue(feedBackModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(FeedBackActivity.this, "Thanks for rating", Toast.LENGTH_SHORT).show();

                            finish();
                        }
                    }
                });
            }
        });

    }

    private String generateRatingId(){

        long time= System.currentTimeMillis();
        return "Rate" + time;
    }


}
