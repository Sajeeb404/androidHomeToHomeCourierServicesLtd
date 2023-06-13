package com.example.testinclass.CourierListAPI;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.testinclass.Entity.Student;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCourier {

    public List<Student> getList(Context con){

        List<Student> employeeList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(con);
        String url ="http://192.168.20.39:3000/users";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

//                        System.out.println("Response: --"+response);
////                                Toast.makeText(ApiMainActivity.this, "Massage: "+ response, Toast.LENGTH_LONG).show();
//                        try {
//                            JSONArray ja= new JSONArray(response);
//                            for (int i = 0; i < ja.length() ; i++) {
//                                JSONObject jb = ja.getJSONObject(i);
//                                String name = jb.getString("name");
//                                String username = jb.getString("username");
//                                String password = jb.getString("password");
//                                Integer id = jb.getInt("id");
//                                Student emp =  new Student(jb.getInt("id"), jb.getString("name"), jb.getString("username"), jb.getString("password"));
//                                employeeList.add(emp);
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println("error--"+ error.getLocalizedMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> paramV = new HashMap<>();
                return paramV;
            }
        };
        queue.add(stringRequest);
        return employeeList;
    }





}
