package org.ieeezsb;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AgendaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_activity);


        final ArrayList<Data> Day1=new ArrayList<Data>();
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day1.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        final AgendaAdapter adapter1 = new AgendaAdapter(this, Day1);
        
        final ArrayList<Data> Day2=new ArrayList<>();
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));

        final AgendaAdapter adapter2 = new AgendaAdapter(this, Day2);

        final ListView listView = (ListView) findViewById(R.id.agenda_list);
        listView.setAdapter(adapter1);

// show day1 agenda when 1st day clicked
        Button day1_button = findViewById(R.id.day1);
        day1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(adapter1);
            }
        });

// show day2 agenda when 2st day clicked
        Button day2_button = findViewById(R.id.day2);
        day2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(adapter2);
            }
        });

//open description screen when item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data word = Day1.get(position);
                setContentView(R.layout.agenda_description);

                TextView speakerTextView =  findViewById(R.id.speaker_des);
                speakerTextView.setText(word.getDescription());

                TextView timeTextView =  findViewById(R.id.track_des);
                timeTextView.setText(word.getDescription());

                ImageView image= findViewById(R.id.speaker_img);
                image.setImageResource(word.getImage());


                

            }
        });


    }
}

class Data {
    private String time;
    private String talk;
    private String speaker;
    private String description;
    private int image;

    public Data(String time, String talk, String speaker, String description, int image) {
        this.time = time;
        this.talk = talk;
        this.speaker = speaker;
        this.description = description;
        this.image = image;

    }

    public String getTime() {
        return time;
    }

    public String getTalk() {
        return talk;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

}


