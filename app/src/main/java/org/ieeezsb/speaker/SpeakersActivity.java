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
                R.drawable.speaker1,
                "Ahmed Abd-Elfattah",
                "Knowledge Management Manager at Valeo",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.speaker2,
                "Ahmed Said",
                "IBM",
                null,
                "www",
                "www",
                null));

        speakerList.add(new Speaker(
                R.drawable.speaker3,
                "Amr Abulnaga",
                "The Regional Technical Consultant at Oracle",
                "www",
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.speaker4,
                "Amr Ali",
                "Big data and Analytics Technical Consultant at Oracle",
                null,
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.speaker5,
                "Ayman Ragab",
                "Consultant in The R_D Department at NTRA",
                null,
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.speaker6,
                "Mohamed Abd-Elmonem",
                "Radio Optimization Senior Engineer at Vodafone",
                "www",
                null,
                "www",
                "www"));


        speakerList.add(new Speaker(
                R.drawable.speaker7,
                "Mostafa Helmy",
                "Identity _ Access Management Advisor at RSA Security",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.speaker8,
                "Omar Amer",
                "Machine Learning Engineer at IBM",
                null,
                null,
                null,
                null));

        speakerList.add(new Speaker(
                R.drawable.speaker9,
                "Ghada Bahig",
                "Engineering Manager at Mentor Graphics",
                null,
                "www",
                "www",
                null));


    }


}
