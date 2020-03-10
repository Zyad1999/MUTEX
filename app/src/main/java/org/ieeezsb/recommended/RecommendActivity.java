package org.ieeezsb.recommended;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.ieeezsb.R;
import org.ieeezsb.Registration.UserModel;

import java.util.ArrayList;
import java.util.List;

public class RecommendActivity extends AppCompatActivity {
    private ArrayList<UserModel> modelList = new ArrayList<>();
    private ArrayList<UserModel> recommendationList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView recommendationRecyclerView;
    private Adapter adapter;
    private RecommendationAdapter recommendationAdapter;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference ref;
    private Toolbar toolbar;
    private UserModel currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        toolbar = (Toolbar) findViewById(R.id.toolbarRec);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        FirebaseUser profile = FirebaseAuth.getInstance().getCurrentUser();
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference("users");

        getCurrentUser();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                modelList.clear();
                recommendationList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserModel m = snapshot.getValue(UserModel.class);
                    modelList.add(m);

                    if (!m.getId().equals(currentUser.getId())){
                        if (isRecommended(m)) {
                            recommendationList.add(m);
                        }
                    }

                }
                adapter.notifyDataSetChanged();
                recommendationAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        initRecommendationRecyclerView();

        initAttendanceRecyclerView();


    }

    private boolean isRecommended(UserModel user) {
        if (currentUser.getSkills() != null && user.getSkills() != null){
            int commonality = 0;
            for (String currentUserSkills : currentUser.getSkills()) {
                for (String recommendedUserSkills : user.getSkills()) {
                    if (currentUserSkills.equals(recommendedUserSkills)) {
                        commonality++;
                        if (commonality >= 3){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    private void getCurrentUser() {
        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ref.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentUser = dataSnapshot.getValue(UserModel.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initAttendanceRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new Adapter(modelList , RecommendActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void initRecommendationRecyclerView() {
        recommendationRecyclerView = findViewById(R.id.recommendation_rv);
        recommendationAdapter = new RecommendationAdapter(this, recommendationList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recommendationRecyclerView.setLayoutManager(layoutManager);
        recommendationRecyclerView.setItemAnimator(new DefaultItemAnimator());
        recommendationRecyclerView.setAdapter(recommendationAdapter);
    }


}
