package org.ieeezsb.Registration;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.ieeezsb.Common;
import org.ieeezsb.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsFragment extends Fragment implements InterestsAdapter.ChangeStatusListener{

    private RecyclerView rvSkills;
    private InterestsAdapter skillsAdapter;
    private ArrayList<InterestsModel> skillsList = new ArrayList<>();
    private Button finishBtn;
    private DatabaseReference mDatabase;

    public SkillsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_skills, container, false);
        rvSkills = rootView.findViewById(R.id.rvSkills);
        skillsAdapter = new InterestsAdapter(getContext(), skillsList, this);
        rvSkills.setAdapter(skillsAdapter);
        rvSkills.setHasFixedSize(true);
        rvSkills.setLayoutManager(new LinearLayoutManager(getContext()));
        setAllSkills();

        finishBtn = rootView.findViewById(R.id.btnFinish);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    for (int i = 0 ; i < skillsList.size() ; i++){
                        if (skillsList.get(i).isSelect()){
                            Common.newUser.addSkill(skillsList.get(i).getText());
                        }

                    }

                    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                    String uID = currentUser.getUid();
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(uID);

                    mDatabase.child("faculty").setValue(Common.newUser.getFaculty());
                    mDatabase.child("whatsapp").setValue(Common.newUser.getWhatsapp());
                    mDatabase.child("facebookLink").setValue(Common.newUser.getFacebookLink());
                    mDatabase.child("bio").setValue(Common.newUser.getBio());
                    mDatabase.child("profilePicLink").setValue(Common.newUser.getProfilePicLink());

                    mDatabase.child("interests").setValue(Common.newUser.getInterests());
                    mDatabase.child("skills").setValue(Common.newUser.getSkills());

                    Toast.makeText(getContext(), "Thanks for registration", Toast.LENGTH_SHORT).show();
                    getActivity().finish();





            }
        });



        return rootView;
    }
    public void setAllSkills(){
        skillsList.add(new InterestsModel("Blogging", false));
        skillsList.add(new InterestsModel("Building", false));
        skillsList.add(new InterestsModel("Book discussion clubs", false));
        skillsList.add(new InterestsModel("Book restoration", false));
        skillsList.add(new InterestsModel("Bowling", false));
        skillsList.add(new InterestsModel("Breadmaking", false));
        skillsList.add(new InterestsModel("Cabaret", false));
        skillsList.add(new InterestsModel("Calligraphy", false));
        skillsList.add(new InterestsModel("Candle making", false));
        skillsList.add(new InterestsModel("Car fixing & building", false));
        skillsList.add(new InterestsModel("Card games", false));
        skillsList.add(new InterestsModel("Cheesemaking", false));
        skillsList.add(new InterestsModel("Clothesmaking", false));
        skillsList.add(new InterestsModel("Coffee roasting", false));
        skillsList.add(new InterestsModel("Collecting", false));
        skillsList.add(new InterestsModel("Coloring", false));
        skillsList.add(new InterestsModel("Computer programming", false));
        skillsList.add(new InterestsModel("Confectionery", false));
        skillsList.add(new InterestsModel("Cooking", false));
        skillsList.add(new InterestsModel("Cosplaying", false));
        skillsList.add(new InterestsModel("Couponing", false));
        skillsList.add(new InterestsModel("Craft", false));
        skillsList.add(new InterestsModel("Creative writing", false));
        skillsList.add(new InterestsModel("Crocheting", false));
        skillsList.add(new InterestsModel("Cross-stitch", false));
        skillsList.add(new InterestsModel("Crossword puzzles", false));
        skillsList.add(new InterestsModel("Cryptography", false));
        skillsList.add(new InterestsModel("Cue sports", false));
        skillsList.add(new InterestsModel("Dance", false));
        skillsList.add(new InterestsModel("Digital arts", false));
        skillsList.add(new InterestsModel("Distro Hopping", false));
        skillsList.add(new InterestsModel("Djing", false));
        skillsList.add(new InterestsModel("Do it yourself", false));
        skillsList.add(new InterestsModel("Drama", false));
        skillsList.add(new InterestsModel("Drawing", false));
        skillsList.add(new InterestsModel("Drink mixing", false));
        skillsList.add(new InterestsModel("Electronics", false));
        skillsList.add(new InterestsModel("Embroidery", false));
        skillsList.add(new InterestsModel("Experimenting", false));
        skillsList.add(new InterestsModel("Fantasy sports", false));
        skillsList.add(new InterestsModel("Fashion", false));
        skillsList.add(new InterestsModel("Fashion design", false));
        skillsList.add(new InterestsModel("Fishkeeping", false));
        skillsList.add(new InterestsModel("Flower arranging", false));
        skillsList.add(new InterestsModel("Foreign language learning", false));
        skillsList.add(new InterestsModel("Furniture building", false));
        skillsList.add(new InterestsModel("Gaming", false));
        skillsList.add(new InterestsModel("Genealogy", false));
        skillsList.add(new InterestsModel("Gingerbread house making", false));
        skillsList.add(new InterestsModel("Glassblowing", false));
        skillsList.add(new InterestsModel("Graphic design", false));
        skillsList.add(new InterestsModel("Gunsmithing", false));
        skillsList.add(new InterestsModel("Herp keeping", false));
        skillsList.add(new InterestsModel("Home improvement", false));
        skillsList.add(new InterestsModel("Homebrewing", false));
        skillsList.add(new InterestsModel("Hula hooping", false));
        skillsList.add(new InterestsModel("Hydroponics", false));
        skillsList.add(new InterestsModel("Ice skating", false));
        skillsList.add(new InterestsModel("Jewelry making", false));
        skillsList.add(new InterestsModel("Jigsaw puzzles", false));
        skillsList.add(new InterestsModel("Journaling", false));
        skillsList.add(new InterestsModel("Juggling", false));

    }


    @Override
    public void onItemChangeListener(int position, InterestsModel model) {
        try {
            skillsList.set(position,model);
        } catch (Exception e){

        }
    }
}
