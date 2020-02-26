package org.ieeezsb.Registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.ieeezsb.MainActivity;
import org.ieeezsb.R;

public class LoginActivity extends AppCompatActivity {
    private AutoCompleteTextView email, password;
    private TextView signUp;
    private Button btnSignIn;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeGUI();


        user = mAuth.getCurrentUser();
/*
        if(user != null) {
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }
*/
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inEmail = email.getText().toString();
                String inPassword = password.getText().toString();

                if(validateInput(inEmail, inPassword)){
                    progressDialog.setMessage("Verification...");
                    progressDialog.show();

                    mAuth.signInWithEmailAndPassword(inEmail, inPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                            else{
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this,"Invalid email or password",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });


    }



    private void initializeGUI(){

        email = findViewById(R.id.atvEmailLog);
        password = findViewById(R.id.atvPasswordLog);
        signUp = findViewById(R.id.tvSignUp);
        btnSignIn = findViewById(R.id.btnLogin);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);


    }


    public boolean validateInput(String inemail, String inpassword){
        if(inemail.isEmpty()){
            email.setError("Email field is empty.");
            return false;
        }
        if(inpassword.isEmpty()){
            password.setError("Password is empty.");
            return false;
        }

        return true;
    }
}
