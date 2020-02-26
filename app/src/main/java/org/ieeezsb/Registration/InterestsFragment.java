package org.ieeezsb.Registration;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.ieeezsb.Common;
import org.ieeezsb.R;
import org.ieeezsb.speaker.Speaker;
import org.ieeezsb.speaker.SpeakerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InterestsFragment extends Fragment implements InterestsAdapter.ChangeStatusListener{

    private RecyclerView rvInterests;
    private InterestsAdapter interestsAdapter = null;
    private ArrayList<InterestsModel> interestsList = new ArrayList<>();

    private Button continueBtn;
    public InterestsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_interests, container, false);

        rvInterests = rootView.findViewById(R.id.rvInterests);
        continueBtn = rootView.findViewById(R.id.btnContinue);
        interestsAdapter = new InterestsAdapter(getContext(), interestsList, this);
        rvInterests.setAdapter(interestsAdapter);
        rvInterests.setHasFixedSize(true);
        rvInterests.setLayoutManager(new LinearLayoutManager(getContext()));
        setAllInterests();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0 ; i < interestsList.size() ; i++){
                    if (interestsList.get(i).isSelect()){
                        Common.newUser.addInterest(interestsList.get(i).getText());
                    }

                }
                    replaceFragments(SkillsFragment.class);

            }
        });

        return rootView;
    }

    public void setAllInterests(){
        interestsList.add(new InterestsModel("Blogging", false));
        interestsList.add(new InterestsModel("Building", false));
        interestsList.add(new InterestsModel("Book discussion clubs", false));
        interestsList.add(new InterestsModel("Book restoration", false));
        interestsList.add(new InterestsModel("Bowling", false));
        interestsList.add(new InterestsModel("Breadmaking", false));
        interestsList.add(new InterestsModel("Cabaret", false));
        interestsList.add(new InterestsModel("Calligraphy", false));
        interestsList.add(new InterestsModel("Candle making", false));
        interestsList.add(new InterestsModel("Car fixing & building", false));
        interestsList.add(new InterestsModel("Card games", false));
        interestsList.add(new InterestsModel("Cheesemaking", false));
        interestsList.add(new InterestsModel("Clothesmaking", false));
        interestsList.add(new InterestsModel("Coffee roasting", false));
        interestsList.add(new InterestsModel("Collecting", false));
        interestsList.add(new InterestsModel("Coloring", false));
        interestsList.add(new InterestsModel("Computer programming", false));
        interestsList.add(new InterestsModel("Confectionery", false));
        interestsList.add(new InterestsModel("Cooking", false));
        interestsList.add(new InterestsModel("Cosplaying", false));
        interestsList.add(new InterestsModel("Couponing", false));
        interestsList.add(new InterestsModel("Craft", false));
        interestsList.add(new InterestsModel("Creative writing", false));
        interestsList.add(new InterestsModel("Crocheting", false));
        interestsList.add(new InterestsModel("Cross-stitch", false));
        interestsList.add(new InterestsModel("Crossword puzzles", false));
        interestsList.add(new InterestsModel("Cryptography", false));
        interestsList.add(new InterestsModel("Cue sports", false));
        interestsList.add(new InterestsModel("Dance", false));
        interestsList.add(new InterestsModel("Digital arts", false));
        interestsList.add(new InterestsModel("Distro Hopping", false));
        interestsList.add(new InterestsModel("Djing", false));
        interestsList.add(new InterestsModel("Do it yourself", false));
        interestsList.add(new InterestsModel("Drama", false));
        interestsList.add(new InterestsModel("Drawing", false));
        interestsList.add(new InterestsModel("Drink mixing", false));
        interestsList.add(new InterestsModel("Electronics", false));
        interestsList.add(new InterestsModel("Embroidery", false));
        interestsList.add(new InterestsModel("Experimenting", false));
        interestsList.add(new InterestsModel("Fantasy sports", false));
        interestsList.add(new InterestsModel("Fashion", false));
        interestsList.add(new InterestsModel("Fashion design", false));
        interestsList.add(new InterestsModel("Fishkeeping", false));
        interestsList.add(new InterestsModel("Flower arranging", false));
        interestsList.add(new InterestsModel("Foreign language learning", false));
        interestsList.add(new InterestsModel("Furniture building", false));
        interestsList.add(new InterestsModel("Gaming", false));
        interestsList.add(new InterestsModel("Genealogy", false));
        interestsList.add(new InterestsModel("Gingerbread house making", false));
        interestsList.add(new InterestsModel("Glassblowing", false));
        interestsList.add(new InterestsModel("Graphic design", false));
        interestsList.add(new InterestsModel("Gunsmithing", false));
        interestsList.add(new InterestsModel("Herp keeping", false));
        interestsList.add(new InterestsModel("Home improvement", false));
        interestsList.add(new InterestsModel("Homebrewing", false));
        interestsList.add(new InterestsModel("Hula hooping", false));
        interestsList.add(new InterestsModel("Hydroponics", false));
        interestsList.add(new InterestsModel("Ice skating", false));
        interestsList.add(new InterestsModel("Jewelry making", false));
        interestsList.add(new InterestsModel("Jigsaw puzzles", false));
        interestsList.add(new InterestsModel("Journaling", false));
        interestsList.add(new InterestsModel("Juggling", false));

    }

    private void replaceFragments(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentFrame, fragment).commit();
    }

    @Override
    public void onItemChangeListener(int position, InterestsModel model) {

        try {
            interestsList.set(position,model);
        } catch (Exception e){

        }

    }
}
