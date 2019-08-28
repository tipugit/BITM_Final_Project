package com.example.tourmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;
    private EditText emailEt,passwordEt;
    private Button loginBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        
        init();

        if (firebaseAuth.getCurrentUser()!=null){

            startActivity(new Intent(LoginActivity.this,DashboardMainActivity.class));

            finish();
        }
        
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (emailEt.getText().toString().length()<=6){
                    emailEt.setError("Enter Valid Email Address");
                }

                else if (passwordEt.getText().toString().length()==0){

                    passwordEt.setError("Enter Your Password");

                }
                else if (passwordEt.getText().toString().length()<6){

                    passwordEt.setError("Enter Minimum 6 digit Password ");

                }
                else {

                    String email = emailEt.getText().toString();
                    String password= passwordEt.getText().toString();

                    login(email,password);


                }

            }
        });

    }

    private void login(String email, String password) {
        
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(LoginActivity.this,DashboardMainActivity.class));
                    finish();

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        
    }


    private void init() {
        
        firebaseAuth=FirebaseAuth.getInstance();
        emailEt =findViewById(R.id.emailLoginEtId);
        passwordEt=findViewById(R.id.passwordLoginEtId);
        loginBtn= findViewById(R.id.loginBtnId);
        
    }


    public void signUpPage(View view) {

        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
        startActivity(intent);
    }
}
