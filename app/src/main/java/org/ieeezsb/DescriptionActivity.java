package org.ieeezsb;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DescriptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.agenda_description);
        TextView timeTextView1 = findViewById(R.id.speaker_name);
        TextView timeTextView2 = findViewById(R.id.speaker_des);
        ImageView imageView=findViewById(R.id.des_img);
        timeTextView1.setText(getIntent().getStringExtra("sp"));
        timeTextView2.setText(getIntent().getStringExtra("des"));
        imageView.setImageResource(getIntent().getIntExtra("img",0));


    }}