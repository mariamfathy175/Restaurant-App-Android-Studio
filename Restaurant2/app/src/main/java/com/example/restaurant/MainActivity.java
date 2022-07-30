package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button Register,Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Register=findViewById(R.id.register);
        Login = findViewById(R.id.login);
        Register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,sign_up.class);
                startActivity(i);
            }
        });
        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent ii =new Intent(MainActivity.this, sign_in.class);
                startActivity(ii);
            }
        });

    }
}