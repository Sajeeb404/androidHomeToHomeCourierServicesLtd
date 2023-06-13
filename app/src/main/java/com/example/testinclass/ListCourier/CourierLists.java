package com.example.testinclass.ListCourier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.testinclass.Dao.Database;
import com.example.testinclass.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class CourierLists extends AppCompatActivity {

    ArrayList courierLists;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courier_lists);


        Database db = new Database(getApplicationContext(), "healthcare", null, 1);

        courierLists = new ArrayList<>();
        courierLists = db.getAllGetCourierUser();


        sa = new SimpleAdapter(this,courierLists,
                R.layout.courierdatalist,
                new String[]{"SENDERFULLNAME", "SENDERADDRESS", "RESIVERFULLNAME", "RESIVERADDRESS"},
                new int[]{R.id.senderNamesID1, R.id.senderAddressID1, R.id.resiverNamesId1, R.id.resiverAddressID1}){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ImageView editBtn = v.findViewById(R.id.emp_edit_btn1);
                ImageView delBtn = v.findViewById(R.id.emp_del_btn1);
                ImageView viewBtn = v.findViewById(R.id.emp_veiw_btn1);


//....................................Start viewCourierClickMethod..........................
                viewBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), CourierViewList.class);
                        startActivity(intent);
                    }
                });
//....................................End viewCourierClickMethod..........................




//....................................Start editUpdateClickMethod..........................
                editBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HashMap<String, String> user = new HashMap<>();
                        try {
                            user = (HashMap<String, String>) courierLists.get(position);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("--------------------SENDERBRANCH------------------"+ user);
                        Intent intent = new Intent(getApplicationContext(), CourierEditUpdate.class);
                        intent.putExtra("ID", user.get("ID"));
                        intent.putExtra("SENDERFULLNAME", user.get("SENDERFULLNAME"));
                        intent.putExtra("SENDERPHONE", user.get("SENDERPHONE"));
                        intent.putExtra("SENDERADDRESS", user.get("SENDERADDRESS"));
                        intent.putExtra("SENDERBRANCH", user.get("SENDERBRANCH"));

                        intent.putExtra("RESIVERFULLNAME", user.get("RESIVERFULLNAME"));
                        intent.putExtra("RESIVERPHONE", user.get("RESIVERPHONE"));
                        intent.putExtra("RESIVERADDRESS", user.get("RESIVERADDRESS"));
                        intent.putExtra("RESIVERBRANCH", user.get("RESIVERBRANCH"));

                        intent.putExtra("CONTENTTYPE", user.get("CONTENTTYPE"));
                        intent.putExtra("CONTENTNAME", user.get("CONTENTNAME"));
                        intent.putExtra("CONTENTWEIGHT", user.get("CONTENTWEIGHT"));
                        intent.putExtra("TOTALPRICE", user.get("TOTALPRICE"));

                        startActivity(intent);
                    }
                });
//....................................End editUpdateClickMethod..........................




//....................................Start deleteClickMethod..........................
                delBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HashMap<String, String> user = new HashMap<>();
                        user = (HashMap<String, String>) courierLists.get(position);
                        boolean deleted = db.deleteCourier(Integer.parseInt(Objects.requireNonNull(user.get("ID"))));
                        if (deleted) {
                            courierLists.remove(position);
                            notifyDataSetChanged();
                        }
                        String message = deleted ? "Successfully deleted" : "Failed to delete";
                    }
                });
//....................................End deleteClickMethod..........................



                return v;
            }
        };


        ListView lv = findViewById(R.id.listViewUD);
        lv.setAdapter(sa);




    }










}


//main