package org.ieeezsb.Registration;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.ieeezsb.Common;
import org.ieeezsb.MainActivity;
import org.ieeezsb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    private TextView firstName, lastName, username, email, password;
    private Button create;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    public RegisterFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);

        firstName = rootView.findViewById(R.id.tvFName);
        lastName = rootView.findViewById(R.id.tvLName);
        username = rootView.findViewById(R.id.tvUsername);
        email = rootView.findViewById(R.id.atvEmailLog);
        password = rootView.findViewById(R.id.atvPasswordLog);
        create = rootView.findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(getContext());
        firebaseAuth = FirebaseAuth.getInstance();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String inputUsername = username.getText().toString().trim();
                final String inputPw = password.getText().toString().trim();
                final String inputEmail = email.getText().toString().trim();
                final String inputFirstname = firstName.getText().toString().trim();
                final String inputLastname = lastName.getText().toString().trim();

                if (validateInput(inputUsername, inputPw, inputEmail, inputFirstname, inputLastname)){
                    registerUser(inputUsername, inputPw, inputEmail, inputFirstname, inputLastname);
                }


            }
        });




        return rootView;
    }

    private void registerUser(final String inputUsername, final String inputPw, final String inputEmail, final String inputFirstname, final String inputLastname) {
       progressDialog.setMessage("Verification...");
       progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(inputEmail,inputPw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Common.newUser = new UserModel(inputFirstname,inputLastname, "Test", "Test", "Test", "Test", "Test",  FirebaseAuth.getInstance().getCurrentUser().getUid(),inputEmail,  inputUsername);
                    FirebaseDatabase.getInstance().getReference("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(Common.newUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                               replaceFragments(ProfileFragment1.class);
                            } else {
                                Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(getContext(),"Email already exists.",Toast.LENGTH_SHORT).show();
                }
            }
        });



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
    private boolean validateInput(String inUserName, String inPw, String inEmail, String fName, String lName){

        if(inUserName.isEmpty()){
            username.setError("Username is empty.");
            return false;
        }
        if(inPw.isEmpty()){
            password.setError("Password is empty.");
            return false;
        }
        if(inEmail.isEmpty()){
            email.setError("Email is empty.");
            return false;
        }

        if(fName.isEmpty()){
            email.setError("First Name is empty.");
            return false;
        }
        if(lName.isEmpty()){
            email.setError("Last Name is empty.");
            return false;
        }
        return true;
    }



}
