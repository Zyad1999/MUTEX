package org.ieeezsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import life.sabujak.roundedbutton.RoundedButton;

public class MainActivity extends AppCompatActivity {

    private RoundedButton feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedback = findViewById(R.id.btnFeedBack);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent feedBackIntent = new Intent(MainActivity.this, FeedBackActivity.class);
                startActivity(feedBackIntent);
            }
        });
    }
}
