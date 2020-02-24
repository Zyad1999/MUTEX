package org.ieeezsb.agenda;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.ieeezsb.R;

import java.util.ArrayList;

public class AgendaActivity extends AppCompatActivity {
    private ArrayList<TalkData> Day1=new ArrayList<>();
    private ArrayList<TalkData> Day2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.agenda_activity);
        gettalks();
        final AgendaAdapter adapter1 = new AgendaAdapter(this, Day1);
        final AgendaAdapter adapter2 = new AgendaAdapter(this, Day2);







        final ListView listView = (ListView) findViewById(R.id.agenda_list);

        listView.setAdapter(adapter1);

// show day1 agenda when 1st day clicked
        final Button day1_button = findViewById(R.id.day1);
        final Button day2_button = findViewById(R.id.day2);
        day1_button.setTextColor(getColor(R.color.backGround));
        day1_button.setBackgroundResource(R.drawable.solid_bottons);

        day1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day1_button.setTextColor(getColor(R.color.backGround));
                day2_button.setTextColor(getColor(R.color.colorPrimary));
                day1_button.setBackgroundResource(R.drawable.solid_bottons);
                day2_button.setBackgroundResource(R.drawable.borderd_button);

                listView.setAdapter(adapter1);
                LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(AgendaActivity.this,R.anim.layout_slide_from_bottom);
                listView.setLayoutAnimation(layoutAnimationController);

            }
        });

// show day2 agenda when 2st day clicked

        day2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day1_button.setTextColor(getColor(R.color.colorPrimary));
                day2_button.setTextColor(getColor(R.color.backGround));
                day1_button.setBackgroundResource(R.drawable.borderd_button);
                day2_button.setBackgroundResource(R.drawable.solid_bottons);

               listView.setAdapter(adapter2);
                LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(AgendaActivity.this,R.anim.layout_slide_from_bottom);
                listView.setLayoutAnimation(layoutAnimationController);
            }
        });


       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent agendaIntent = new Intent(AgendaActivity.this, DescriptionActivity.class);

                if (listView.getAdapter()==adapter1)
                {
                   agendaIntent.putExtra("des", Day1.get(position).getDescription());
                    agendaIntent.putExtra("sp", Day1.get(position).getSpeaker());
                    agendaIntent.putExtra("img",Day1.get(position).getImage());
                }
                else
                    {
                    agendaIntent.putExtra("des", Day2.get(position).getDescription());
                    agendaIntent.putExtra("sp", Day2.get(position).getSpeaker());
                    agendaIntent.putExtra("img", Day2.get(position).getImage());
                }




                ImageView image = findViewById(R.id.speaker_img);

                ActivityOptionsCompat activityOp=ActivityOptionsCompat.makeSceneTransitionAnimation(AgendaActivity.this,image,"speaker photo");


                startActivity(agendaIntent,activityOp.toBundle());



            }
        });


    }

    private void gettalks(){
        Day1.add(new TalkData("09:00-10:00", "Registration","None","Confirm your attending and get your gifts",R.drawable.reg_));
        Day1.add(new TalkData("10:00-10:30", "Welcome Speech","IEEE Zagazig","welcome to MUTEX",R.drawable.welcome));
        Day1.add(new TalkData("10:30-11:15", "Machine Learning","Hesham Eraqi","Hesham is currently a Senior Principal Engineer and Deep Learning Senior Expert At Valeo. He is also an Adjunct Faculty/Lecturer at the Computer Science and Engineering Department at the American University in Cairo (AUC).\n" +
                "\n" +
                "He received the Bachelor degree in Electronics Engineering in 2010, and the Master of\n" +
                "Science degree in Computer Engineering in 2014 from Cairo University. He has been a PhD fellow candidate with Highest Honors and highest GPA in class, Teaching and Research Assistant at the AUC.\n" +
                "\n" +
                "Hesham develops various Automotive projects that enable Autonomous Driving and Active Safety using Artificial Intelligence and Deep Learning technologies, and he is conducting industrial research focused in these areas.\n" +
                "\n" +
                "In addition to his filled patents from Germany, Hesham’s peer-reviewed publications, including book chapters and international conference papers, are mainly in Artificial Intelligence and Deep Machine Learning. He has a variety of own-developed projects, including the awards-winning \"Arabot\" robot and he is an active technical web blogger.",R.drawable.hesham_eraqi));
        Day1.add(new TalkData("11:15-12:00", "5G Technology","Mohamed El-gharably","Mohamed has 14 years of professional experience in the Mobile Telecom industry, specialized in Radio Access Networks, Transport, Mobile Broad Band, and Network Design and Optimization domains.\n" +
                "\n" +
                "In 2008, Mohamed joined Ericsson as Network and Technology Consultant focusing on evolution of mobile networks, then he got promoted to various roles till he seized his current role as Networks’\n" +
                "Chief Technology Officer (CTO) in the beginning of 2016.\n" +
                "\n" +
                "Mohamed started his career in 2004 as Access Project Coordinator at Equant, then later in 2005 he moved to Alcatel.Lucent as Radio Network Engineer.\n" +
                "\n" +
                "Along his career path, Mohamed has had the opportunity to work in various technologies, such as GSM, WCDMA, WIMAX and LTE and to support 12 Mobile Network Operators, operating in 10 different countries, in improving their network performance and seamlessly launching new\n" +
                "technologies.\n" +
                "\n" +
                "On the educational level, Mohamed got his Bachelor of Science degree in Electrical Engineering, telecommunications’ section, from Alexandria University in July 2003 with a final grade of distinction with honor degree.",R.drawable.mohamed_elgharably));
        Day1.add(new TalkData("12:00-12:45", "Software defined networks","Ahmed Samir","Ahmed is working for Dell EMC as Advisor, supporting VMware NSX-V customers globally.\n" +
                "\n" +
                "He is a communication engineer, working in IT field for 7 years,\n" +
                "Worked in several rules as Network and Systems Engineer for Sumerge and Senior Linux Support Engineer for Alshaya.\n" +
                "He is currently working on his masters in cloud computing at Cairo University.\n",R.drawable.ahmed_samir));
        Day1.add(new TalkData("12:45-01:00", "NTRA","Amir El-senousy","NTRA competition",R.drawable.amir_elsenousy));
        Day1.add(new TalkData("01:00-01:30", "Break","None","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.break_));
        Day1.add(new TalkData("01:30-01:50", "TIEC Programs","Abdalla Amr","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.abdalla_amr));
        Day1.add(new TalkData("01:50-02:20", "Panal discussion","None","Technology innovation and entrepreneurship Center Startups",R.drawable.panal));
        Day1.add(new TalkData("02:20-03:05", "Artificial intelligence","Ebeid Atef","Ebeid For years, the META vendor role has worked with EPG and top SMS&P academic institutions to drive evaluations of Office 365; support deployments; and assist with identity, single sign-on, data migration, and other services.\n" +
                "\n" +
                "He has played a vital role with key customers when Office 365 license growth and demand for deployment assistance outstripped the capacity of Microsoft solution sales.\n" +
                "\n" +
                "He is an experienced Educator with a demonstrated history of working in the computer software industry. Skilled in Analytical Skills, Requirements Analysis, C#, Agile Methodologies, and Databases.\n" +
                "\n" +
                "Strong education professional with a Bachelor's Engineering focused in Mechanical Engineering from Alexandria University.",R.drawable.ebeid_atef));
        Day1.add(new TalkData("03:05-03:30", "Closing","None","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.closing));


        Day2.add(new TalkData("10:00-01:00", "5G","Bassem Ibrahim","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new TalkData("10:00-01:00", "Software Defined Networks","Nada Nasr","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new TalkData("10:00-01:00", "CyberTalents & Trend Micro","Hesham El-zoghby","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new TalkData("01:00-04:00", "BlochChain","Amr Abd El-hafiz","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));
        Day2.add(new TalkData("01:00-04:00", "entrepreneurship","Nadeem Barakat","jfioeh sdfbvuewbrugvu jebfvueb ejub ",R.drawable.ibm));


    }
    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

}




