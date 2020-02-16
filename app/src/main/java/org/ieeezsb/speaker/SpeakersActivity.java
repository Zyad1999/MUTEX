package org.ieeezsb.speaker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.ieeezsb.R;

import java.util.ArrayList;

public class SpeakersActivity extends AppCompatActivity {


    private ArrayList<Speaker> speakerList = new ArrayList<>();
    private SpeakerAdapter speakerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);


        initRecyclerView();
        getAllSpeakers();

    }

    private void initRecyclerView() {
        RecyclerView speakerRecyclerView = findViewById(R.id.rv_speakers);
        speakerAdapter = new SpeakerAdapter(this, speakerList);
        speakerRecyclerView.setAdapter(speakerAdapter);
        speakerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getAllSpeakers() {

        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Ahmed Abd-Elfattah",
                "Knowledge Management Manager at Valeo",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Ahmed Said",
                "IBM",
                null,
                "www",
                "www",
                null));

        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Amr Abulnaga",
                "The Regional Technical Consultant at Oracle",
                "www",
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Amr Ali",
                "Big data and Analytics Technical Consultant at Oracle",
                null,
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Ayman Ragab",
                "Consultant in The R_D Department at NTRA",
                null,
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Mohamed Abd-Elmonem",
                "Radio Optimization Senior Engineer at Vodafone",
                "www",
                null,
                "www",
                "www"));


        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Mostafa Helmy",
                "Identity _ Access Management Advisor at RSA Security",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Omar Amer",
                "Machine Learning Engineer at IBM",
                null,
                null,
                null,
                null));

        speakerList.add(new Speaker(
                R.drawable.ahmed_samir,
                "Ghada Bahig",
                "Engineering Manager at Mentor Graphics",
                null,
                "www",
                "www",
                null));


    }


}
