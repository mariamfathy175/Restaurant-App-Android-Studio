package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends AppCompatActivity {

    TextView FirstName, LastName, Email, Birthdate, Phonenumber, Password, ConfirmPassword;
    Button Submit;
    RadioGroup gender;
    RadioButton male,female;
    private FirebaseAuth Auth;
    private ProgressDialog Loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        FirstName = findViewById(R.id.firstname);
        LastName = findViewById(R.id.lastname);
        Email = findViewById(R.id.email);
        Birthdate = findViewById(R.id.birthdate);
        Phonenumber = findViewById(R.id.phonenumber);
        Password = findViewById(R.id.password);
        ConfirmPassword = findViewById(R.id.confirmpassword);
        gender=findViewById(R.id.gender);
        male=findViewById(R.id.radioButton1);
        female=findViewById(R.id.radioButton2);
        Auth = FirebaseAuth.getInstance();
        Loadingbar=new ProgressDialog(sign_up.this);


        Submit = findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = FirstName.getText().toString();
                String lastname =LastName.getText().toString();
                String phonenumber =Phonenumber.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmpassword = ConfirmPassword.getText().toString();

                if(firstname.isEmpty()||lastname.isEmpty()||phonenumber.isEmpty()||email.isEmpty()
                        ||password.isEmpty()||confirmpassword.isEmpty())
                {
                    Toast.makeText(sign_up.this, "This Field is Required", Toast.LENGTH_SHORT).show();
                }
                else if(phonenumber.length()<11 )
                {
                    Toast.makeText(sign_up.this, "Phone number must be 12 digits", Toast.LENGTH_SHORT).show();
                }
                else if(!email.contains("@"))
                {
                    Toast.makeText(sign_up.this, "Email is not valid", Toast.LENGTH_SHORT).show();
                }
                else if(password.length()<6)
                {
                    Toast.makeText(sign_up.this, "password must be 5 charachters", Toast.LENGTH_SHORT).show();
                }
                else if(!confirmpassword.equals(password))
                {
                    Toast.makeText(sign_up.this, "password doesn't match", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(sign_up.this, "You Signup Successfully", Toast.LENGTH_SHORT).show();
                                Intent i =new Intent(sign_up.this,Restaurants.class);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(sign_up.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
}