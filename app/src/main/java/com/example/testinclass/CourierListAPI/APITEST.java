package com.example.testinclass.CourierListAPI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testinclass.Entity.Student;
import com.example.testinclass.R;

import java.util.List;

public class APITEST extends AppCompatActivity {


    Button buttonapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apitest);

        buttonapi = findViewById(R.id.buttonAPIid);


        buttonapi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetCourier getCourier = new GetCourier();
                try {
                    List<Student> stlis = getCourier.getList(getApplicationContext());

                    Toast.makeText(getApplicationContext(), "Student List" + stlis, Toast.LENGTH_SHORT).show();

                }catch (Exception e){

                }






//                Toast.makeText(getApplicationContext(), "Hellow", Toast.LENGTH_SHORT).show();





            }
        });


    }
}