package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Restaurants extends AppCompatActivity {
    ImageButton Burger,Healthy,Sushi,Pizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        Burger=findViewById(R.id.burgerres);
        Healthy=findViewById(R.id.healthyres);
        Sushi=findViewById(R.id.sushires);
        Pizza=findViewById(R.id.pizzares);
        Burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent i = new Intent(Restaurants.this, BurgerRestaurant.class);
                startActivity(i);
            }
        });
        Healthy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent ii = new Intent(Restaurants.this, HealthyRestaurant.class);
                startActivity(ii);
            }

        });
        Sushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent iii = new Intent(Restaurants.this, SushiRestaurant.class);
                startActivity(iii);
            }
        });
        Pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent iiii = new Intent(Restaurants.this, PizzaRestaurant.class);
                startActivity(iiii);
            }
        });

    }
}