package org.ieeezsb.recommended;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.ieeezsb.HelpersMethods;
import org.ieeezsb.MainActivity;
import org.ieeezsb.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AtendeesDetailsActivity extends AppCompatActivity {
    private String pic,name,bio,faceLink,num;
    private ArrayList<String> interests, skills;
    private TextView txt_name ,txt_bio;
    private ImageView facebook , whats;
    private ImageView myPic;
    private ListView lst_skills , lst_interests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendees_details);
        name = getIntent().getStringExtra("name");
        pic = getIntent().getStringExtra("picture");
        bio = getIntent().getStringExtra("bio");
        faceLink = getIntent().getStringExtra("facebookLink");
        num = getIntent().getStringExtra("mobileNum");
        skills = getIntent().getStringArrayListExtra("skills");
        interests = getIntent().getStringArrayListExtra("interests");

        txt_name = (TextView) findViewById(R.id.txt_name);
        txt_bio = (TextView) findViewById(R.id.txt_bio);
        myPic = findViewById(R.id.user_image2);
        facebook = findViewById(R.id.img_face);
        whats = findViewById(R.id.img_whats);
        lst_skills = findViewById(R.id.lst_skills);
        lst_interests = findViewById(R.id.lst_interests);

        ArrayAdapter adapter_skills = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, skills);
        lst_skills.setAdapter(adapter_skills);
        ArrayAdapter adapter_interests = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, interests);
        lst_interests.setAdapter(adapter_interests);

        txt_name.setText(name);
        txt_bio.setText(bio);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(AtendeesDetailsActivity.this);
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            }
        });

        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+num));
                startActivity(intent);
            }
        });

        Picasso.get().load(pic).into(myPic);

    }

    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + faceLink;
            } else { //older versions of fb app
                return "fb://page/" + "NO";
            }
        } catch (PackageManager.NameNotFoundException e) {
            return faceLink; //normal web url
        }
    }

}
