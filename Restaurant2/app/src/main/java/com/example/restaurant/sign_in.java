package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_in extends AppCompatActivity {
    TextView Username,Password;
    Button Login;
    private FirebaseAuth Auth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.login);
        Auth = FirebaseAuth.getInstance();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(Username.getText().toString())||TextUtils.isEmpty(Password.getText().toString()))
                {
                    Toast.makeText(sign_in.this, "This Field is Required", Toast.LENGTH_SHORT).show();
                }
                else if(!Username.getText().toString().contains("@"))
                {
                    Toast.makeText(sign_in.this, "Email is not valid", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Auth.signInWithEmailAndPassword(Username.getText().toString(),Password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(sign_in.this, "You Login Successfully", Toast.LENGTH_SHORT).show();
                                Intent ii =new Intent(sign_in.this,Restaurants.class);
                                startActivity(ii);
                            }
                            else
                            {
                                Toast.makeText(sign_in.this, "Invalid Email or password ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

    }
}
