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
                R.drawable.ahmed_abdelfattah,
                "Ahmed Abd-Elfattah",
                "Knowledge Management Manager at Valeo",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ahmed_said,
                "Ahmed Said",
                "IBM",
                null,
                "www",
                "www",
                null));

        speakerList.add(new Speaker(
                R.drawable.amr_abulnaga,
                "Amr Abulnaga",
                "The Regional Technical Consultant at Oracle",
                "www",
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.amr_ali,
                "Amr Ali",
                "Big data and Analytics Technical Consultant at Oracle",
                null,
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ayman_ragab,
                "Ayman Ragab",
                "Consultant in The R_D Department at NTRA",
                null,
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.mohamed_abdelmonem,
                "Mohamed Abd-Elmonem",
                "Radio Optimization Senior Engineer at Vodafone",
                "www",
                null,
                "www",
                "www"));


        speakerList.add(new Speaker(
                R.drawable.mostafa_helmy,
                "Mostafa Helmy",
                "Identity _ Access Management Advisor at RSA Security",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.omar_amer,
                "Omar Amer",
                "Machine Learning Engineer at IBM",
                null,
                null,
                null,
                null));

        speakerList.add(new Speaker(
                R.drawable.ghada_bahig,
                "Ghada Bahig",
                "Engineering Manager at Mentor Graphics",
                null,
                "www",
                "www",
                null));

        speakerList.add(new Speaker(
                R.drawable.ahmed_abdelfattah,
                "Ahmed Abd-Elfattah",
                "Knowledge Management Manager at Valeo",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ahmed_said,
                "Ahmed Said",
                "IBM",
                null,
                "www",
                "www",
                null));

        speakerList.add(new Speaker(
                R.drawable.amr_abulnaga,
                "Amr Abulnaga",
                "The Regional Technical Consultant at Oracle",
                "www",
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.amr_ali,
                "Amr Ali",
                "Big data and Analytics Technical Consultant at Oracle",
                null,
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ayman_ragab,
                "Ayman Ragab",
                "Consultant in The R_D Department at NTRA",
                null,
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.mohamed_abdelmonem,
                "Mohamed Abd-Elmonem",
                "Radio Optimization Senior Engineer at Vodafone",
                "www",
                null,
                "www",
                "www"));


        speakerList.add(new Speaker(
                R.drawable.mostafa_helmy,
                "Mostafa Helmy",
                "Identity _ Access Management Advisor at RSA Security",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.omar_amer,
                "Omar Amer",
                "Machine Learning Engineer at IBM",
                null,
                null,
                null,
                null));

        speakerList.add(new Speaker(
                R.drawable.ghada_bahig,
                "Ghada Bahig",
                "Engineering Manager at Mentor Graphics",
                null,
                "www",
                "www",
                null));

        speakerList.add(new Speaker(
                R.drawable.ahmed_abdelfattah,
                "Ahmed Abd-Elfattah",
                "Knowledge Management Manager at Valeo",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ahmed_said,
                "Ahmed Said",
                "IBM",
                null,
                "www",
                "www",
                null));

        speakerList.add(new Speaker(
                R.drawable.amr_abulnaga,
                "Amr Abulnaga",
                "The Regional Technical Consultant at Oracle",
                "www",
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.amr_ali,
                "Amr Ali",
                "Big data and Analytics Technical Consultant at Oracle",
                null,
                null,
                null,
                "www"));

        speakerList.add(new Speaker(
                R.drawable.ayman_ragab,
                "Ayman Ragab",
                "Consultant in The R_D Department at NTRA",
                null,
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.mohamed_abdelmonem,
                "Mohamed Abd-Elmonem",
                "Radio Optimization Senior Engineer at Vodafone",
                "www",
                null,
                "www",
                "www"));


        speakerList.add(new Speaker(
                R.drawable.mostafa_helmy,
                "Mostafa Helmy",
                "Identity _ Access Management Advisor at RSA Security",
                "www",
                "www",
                "www",
                "www"));

        speakerList.add(new Speaker(
                R.drawable.omar_amer,
                "Omar Amer",
                "Machine Learning Engineer at IBM",
                null,
                null,
                null,
                null));

        speakerList.add(new Speaker(
                R.drawable.ghada_bahig,
                "Ghada Bahig",
                "Engineering Manager at Mentor Graphics",
                null,
                "www",
                "www",
                null));


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }


}
