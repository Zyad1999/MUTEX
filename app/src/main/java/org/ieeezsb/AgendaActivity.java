package org.ieeezsb;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
        AgendaAdapter adapter1 = new AgendaAdapter(this, Day1);
        
        final ArrayList<Data> Day2=new ArrayList<>();
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new Data("11:11", "Big Data","Boyka","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        AgendaAdapter adapter2 = new AgendaAdapter(this, Day2);

        ListView listView = (ListView) findViewById(R.id.agenda_list);
        listView.setAdapter(adapter1);

        //open description screen when item clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data word = Day1.get(position);

                

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


