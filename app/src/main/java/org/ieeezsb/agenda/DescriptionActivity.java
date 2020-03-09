package org.ieeezsb.agenda;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.ieeezsb.R;

import java.util.Objects;

public class DescriptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.agenda_description);
        TextView textview1 = findViewById(R.id.user_name);
        TextView textview2 = findViewById(R.id.speaker_des);
        ImageView imageView=findViewById(R.id.des_img);
        if (Objects.equals(getIntent().getStringExtra("sp"), "None"))
            textview1.setVisibility(View.GONE);
        else {
            textview1.setVisibility(View.VISIBLE);
            textview1.setText(getIntent().getStringExtra("sp"));
        }

        textview2.setText(getIntent().getStringExtra("des"));
        imageView.setImageResource(getIntent().getIntExtra("img",0));


    }}