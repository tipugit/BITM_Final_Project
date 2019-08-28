package com.example.tourmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private TextView login;
    private Button signUpBtn;
    private EditText nameEt,numberEt,emailEt,passwordEt;
    String id1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       init();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nameEt.getText().toString().length()==0){
                    nameEt.setError("Enter Your Full Name");
                }
                else if (emailEt.getText().toString().length()<6){
                    emailEt.setError("Enter Valid Email Address");
                }
                else if (numberEt.getText().toString().length()==0){
                    numberEt.setError("Enter Valid Phone Number");
                }
                else if (passwordEt.getText().toString().length()==0){
                    passwordEt.setError("Enter 6-20 digit Password");
                }
                else if (passwordEt.getText().toString().length()<6){
                    passwordEt.setError("Enter minimum 6 digit Password");
                }
                else {

                    String name= nameEt.getText().toString();
                    String email= emailEt.getText().toString();
                    String number= numberEt.getText().toString();
                    String password= passwordEt.getText().toString();

                    Register(email,password);
                    saveData();

                }


            }
        });





    }

    private void saveData() {

        String name = nameEt.getText().toString();
        String email = emailEt.getText().toString();
        String number = numberEt.getText().toString();
        String password = passwordEt.getText().toString();

       String id = databaseReference.push().getKey();
        Singup singup= new Singup(name,email,number,password);

        databaseReference.child(id).setValue(singup);


        id1 = id;





    }

    private void Register(String email, String password) {

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void init() {

        login=findViewById(R.id.loginTv);
        nameEt=findViewById(R.id.nameSignupEtId);
        emailEt=findViewById(R.id.emailSignupEtId);
        numberEt=findViewById(R.id.numberSignupEtId);
        passwordEt=findViewById(R.id.passwordSignupEtId);
        signUpBtn=findViewById(R.id.signUpBtnId);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

    }


}
