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
                R.drawable.ibm,
                "IBM",
                "No thing",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                null,
                "www",
                "www",
                null));

        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                "www",
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                null,
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                null,
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                "www",
                null,
                "www",
                "www"));


        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                null,
                null,
                null,
                null));

        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                null,
                "www",
                "www",
                null));


        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                null,
                "www",
                null,
                null));


        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                "www",
                "www",
                null,
                null));

        speakerList.add(new Speaker(
                R.drawable.ibm,
                "IBM",
                "No thing",
                null,
                "www",
                "www",
                "www"));
    }


}
