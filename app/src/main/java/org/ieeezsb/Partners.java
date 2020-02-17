package org.ieeezsb;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Partners extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners);
        ImageView offical = findViewById(R.id.offical);
        offical.setImageResource(R.drawable.officialpartner);

        ImageView content = findViewById(R.id.content);
        content.setImageResource(R.drawable.contentpartner);

        ImageView catring = findViewById(R.id.catring);
        catring.setImageResource(R.drawable.cateringsponsor);

        ImageView content2 = findViewById(R.id.content2);
        content2.setImageResource(R.drawable.contentpartner1);

        ImageView content3 = findViewById(R.id.content3);
        content3.setImageResource(R.drawable.contentpartner2);

        ImageView content4 = findViewById(R.id.content4);
        content4.setImageResource(R.drawable.contentpartner3);

        ImageView hosting = findViewById(R.id.hosting);
        hosting.setImageResource(R.drawable.hostingpartner);

        ImageView startup = findViewById(R.id.startup);
        startup.setImageResource(R.drawable.startuppartner);

        ImageView transporting = findViewById(R.id.transporting);
        transporting.setImageResource(R.drawable.transportationpartner);

        ImageView stratigic = findViewById(R.id.stratigic);
        stratigic.setImageResource(R.drawable.strategicpartner);

        ImageView startup2 = findViewById(R.id.startup2);
        startup2.setImageResource(R.drawable.startuppartner1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}
