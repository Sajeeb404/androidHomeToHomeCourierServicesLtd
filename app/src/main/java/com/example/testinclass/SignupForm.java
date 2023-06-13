package com.example.testinclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testinclass.Dao.Database;

public class SignupForm extends AppCompatActivity {

    EditText edFullName;
    EditText edUserName;
    EditText edEamil;
    EditText edPassword;
    EditText edConfirmPassword;
    Button btnSign;

    TextView tv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        edFullName = findViewById(R.id.signUpFullNameId);
        edUserName = findViewById(R.id.signUpUserNameId);
        edEamil = findViewById(R.id.signUpEmailid);
        edPassword = findViewById(R.id.singUpPasswordId);
        edConfirmPassword = findViewById(R.id.singUpConfiPasswordId2);

        tv = findViewById(R.id.signUpid2);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupForm.this, LoginForm.class);
                startActivity(intent);

//                Toast.makeText(getApplicationContext(), "Full Name = ", Toast.LENGTH_SHORT).show();

            }

        });


        btnSign = findViewById(R.id.btnSignUp);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = edFullName.getText().toString();
                String UserName = edUserName.getText().toString();
                String email = edEamil.getText().toString();
                String password = edPassword.getText().toString();
                String conPasswor = edConfirmPassword.getText().toString();


                Database db = new Database(getApplicationContext(),"healthcare", null, 1);

                if (fullName.length() == 0 || UserName.length()==0 || email.length() == 0 || password.length()==0 || conPasswor.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please Fill All The Data Field.", Toast.LENGTH_SHORT).show();
                }else {

                    if (true){
                        db.addUser(fullName, UserName, email, password, conPasswor);
                        startActivity(new Intent(SignupForm.this, LoginForm.class));
                        Toast.makeText(getApplicationContext(), "Sign Up Successfull", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(getApplicationContext(), "Password is not matched..", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }


//    public static boolean is_Valid_Password(){
//
//
//
//    }







}