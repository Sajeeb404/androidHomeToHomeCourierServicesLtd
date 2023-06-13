package com.example.testinclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;



import com.example.testinclass.Courier.UserCourierForm;
import com.example.testinclass.CourierListAPI.APITEST;
import com.example.testinclass.ListCourier.CourierLists;


public class Home extends AppCompatActivity {



    CardView cardView;

    CardView cardViewForList;
    CardView cardViewForHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardView = findViewById(R.id.courierFormid);
        cardViewForList = findViewById(R.id.courierListid);
        cardViewForHome = findViewById(R.id.homeid);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, UserCourierForm.class);
                startActivity(intent);
            }
        });


        cardViewForList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, CourierLists.class);
                startActivity(intent);
            }
        });

        cardViewForHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, APITEST.class);
                startActivity(intent);
            }
        });







    }


}