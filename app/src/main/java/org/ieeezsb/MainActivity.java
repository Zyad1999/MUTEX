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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnFeedBack;
    private TextView TvFeedback;
    private ImageButton mFaceBook;
    private ImageButton mTwitter;
    private ImageButton mLinkdin;
    private ImageButton mInsta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFaceBook =findViewById(R.id.iv_facebook);
        mFaceBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url","https://www.facebook.com/MUTEX.Summit/?ref=gs&__tn__=%2CdK-R-R&eid=ARB9kh2MDdy_d3BcBdys0bTW9UWQaE9J0_8ouhQgpIB8yy37ppKWYq6-6auxFS8_UJTgMzk5Trr-4SFa&fref=gs&dti=181743375206602&hc_location=group");
                startActivity(intent);
            }
        });
        mTwitter =findViewById(R.id.twitter);
        mTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url","https://twitter.com/MutexSummit?fbclid=IwAR3P32TEqe5el4jKbs2GDffXC0W9QRXL_mL8vZWsrN0Pyi-3GeazAy76xic");
            }
        });
        mLinkdin =findViewById(R.id.linkd);
        mLinkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url","https://www.linkedin.com/company/mutexsummit/?fbclid=IwAR0YW9zONy1-hUW2hyHNF2cTDQXbK5C2tvqB5XgjQp6KaZ7HHVKts4Rd5EQ");
                startActivity(intent);
            }
        });
        mInsta =findViewById(R.id.iv_instagram);
        mInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url","https://www.instagram.com/mutex.summit/?fbclid=IwAR1GA6wU9s4uS_vIFrVSs2wqFKBcRIDOwnBMNwfKIvJCnQsxBdGwoSrSunc");
                startActivity(intent);
            }
        });
        btnFeedBack = findViewById(R.id.feedbackBtn);
        TvFeedback = findViewById(R.id.feedbackTv);

        btnFeedBack.setOnClickListener(this);
        TvFeedback.setOnClickListener(this);
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
        ImageButton sponsors = findViewById(R.id.sponsorsButton);
        sponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent partnersIntent = new Intent(MainActivity.this, Partners.class);
                startActivity(partnersIntent);
            }
        });



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


        private void checkInternet(){

            if (!haveConnectionToInternet()){
                Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
            } else {
                Intent feedBackIntent = new Intent(MainActivity.this, FeedBackActivity.class);
                startActivity(feedBackIntent);
            }
        }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.feedbackBtn:
            case R.id.feedbackTv:
                checkInternet();

        }
    }
}
