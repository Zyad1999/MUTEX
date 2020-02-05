package org.ieeezsb;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import life.sabujak.roundedbutton.RoundedButton;

public class MainActivity extends AppCompatActivity {

    private RoundedButton feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// this part added by boyka for test 
        ImageButton agenda = findViewById(R.id.agenda_button);
       	agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agendaIntent = new Intent(MainActivity.this, AgendaActivity.class);
                startActivity(agendaIntent);
            }
        });
/////////////////////////////////////



        }

        // Method to Check Internet Connection.
    private boolean haveConnectionToInternet (){

        boolean haveWifi = false ;
        boolean haveMobileData = false;
        ConnectivityManager cm =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();
        for (NetworkInfo info: networkInfos){
            if (info.getTypeName().equalsIgnoreCase("wifi")){
                if (info.isConnected()){
                    haveWifi = true;
                }
            }

            if (info.getTypeName().equalsIgnoreCase("mobile")){
                if (info.isConnected()){
                    haveMobileData = true;
                }
            }
        }

        return haveMobileData || haveWifi;

        }


}
