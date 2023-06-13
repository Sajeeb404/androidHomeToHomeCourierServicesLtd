package com.example.testinclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testinclass.Dao.Database;
import com.example.testinclass.Drawere.DrawerActivity;

public class LoginForm extends AppCompatActivity {



    EditText edUserName;
    EditText edPassword;
    Button btn;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        edUserName = findViewById(R.id.loginUserNamid);
        edPassword = findViewById(R.id.loginUserPasswordId);
        btn = findViewById(R.id.btnloginid);
        tv = findViewById(R.id.loginSiginUpTextviewId);



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginForm.this, SignupForm.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUserName.getText().toString();
                String password = edPassword.getText().toString();

                Database db = new Database(getApplicationContext(),"healthcare", null, 1);

                if (userName.length() == 0 || password.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please Fill The Filed", Toast.LENGTH_SHORT).show();
                }else {
                    if (db.loginUser(userName,password) ==1){
                        Toast.makeText(LoginForm.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        SharedPreferences preferences = getSharedPreferences("Share_Pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("username",userName);
                        editor.commit();
                        editor.apply();

                        startActivity(new Intent(LoginForm.this, Home.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "Your User Name And Password is Wrong", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });








    }
}