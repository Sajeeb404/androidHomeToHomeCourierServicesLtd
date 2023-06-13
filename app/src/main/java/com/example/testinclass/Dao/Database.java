package com.example.testinclass.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testinclass.Entity.CourierModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE USER (ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "FULLNAME TEXT, USERNAME TEXT, EMAIL TEXT, PASSWORD TEXT, CONFIRMPASSWORD TEXT)";



        String courierSet = "CREATE TABLE USERCOURIER (" +
                " ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "SENDERFULLNAME TEXT, SENDERPHONE TEXT, SENDERADDRESS TEXT, SENDERBRANCH TEXT, " +
                "RESIVERFULLNAME TEXT, RESIVERPHONE TEXT, RESIVERADDRESS TEXT, RESIVERBRANCH TEXT, " +
                "CONTENTTYPE TEXT, CONTENTNAME TEXT, CONTENTWEIGHT TEX, TOTALPRICE TEXT, PAYMENTMETHOD TEXT," +
                "CREATEDATE DATE, AVAILABLEDATE DATE, COURIERSTATUS ENUM, PAYMENTSTATUS ENUM)";

        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(courierSet);



    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }








//    .........................Start SignUp Method..................................................
    public void addUser(String fullName, String userName, String email, String password, String confiPassword){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("FULLNAME", fullName);
        values.put("USERNAME", userName);
        values.put("PASSWORD", password);
        values.put("CONFIRMPASSWORD", confiPassword);

        db.insert("USER", null, values);
        db.close();


    }
//    .........................Start SignUp Method..................................................











//    .........................Start Login Method..................................................
    public int loginUser (String userName, String password){
        String[] arr = new String[2];
        arr[0] = userName;
        arr[1] = password;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from user where userName =? and password=?", arr);

        if (c.moveToFirst()){
            return 1;
        }
    return 0;
    }
//    .........................End Login Method..................................................












//    .........................Start Courier post Method..................................................

    public void addCourier(CourierModel courierModel){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("SENDERFULLNAME", courierModel.getSenderFulname());
        values.put("SENDERPHONE", courierModel.getSenderPhn());
        values.put("SENDERADDRESS", courierModel.getSenderAddress());
        values.put("SENDERBRANCH", courierModel.getSenderBranch());

        values.put("RESIVERFULLNAME", courierModel.getResiverFulname());
        values.put("RESIVERPHONE", courierModel.getResiverPhn());
        values.put("RESIVERADDRESS", courierModel.getSresiverAddress());
        values.put("RESIVERBRANCH", courierModel.getResiverBranch());

        values.put("CONTENTTYPE", courierModel.getContentType());
        values.put("CONTENTNAME", courierModel.getContentName());
        values.put("CONTENTWEIGHT", courierModel.getContentWeight());
        values.put("TOTALPRICE", courierModel.getTotalPrice());

        values.put("PAYMENTMETHOD", courierModel.getPaymentMethos());
        values.put("CREATEDATE", courierModel.getCreateDate().toString());
        values.put("AVAILABLEDATE", courierModel.getAvaileAbleDate().toString());
        values.put("COURIERSTATUS", courierModel.getCourierStatus().toString());
        values.put("PAYMENTSTATUS", courierModel.getPaymentStatus().toString());

        db.insert("USERCOURIER", null, values);
        db.close();
    }

//    .........................End Courier post Method..................................................











//    .........................Start Courier get Method..................................................
    public ArrayList<HashMap<String, String>> getAllGetCourierUser() {

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from USERCOURIER ", null);

        ArrayList<HashMap<String, String>> courierList = new ArrayList<>(c.getCount());
        HashMap<String, String> courier;
        if (c.moveToFirst()) {

            do {
                courier = new HashMap<>();
                courier.put("ID", c.getString(0));

                courier.put("SENDERFULLNAME", c.getString(1));
                courier.put("SENDERPHONE", c.getString(2));
                courier.put("SENDERADDRESS", c.getString(3));
                courier.put("SENDERBRANCH", c.getString(4));

                courier.put("RESIVERFULLNAME", c.getString(5));
                courier.put("RESIVERPHONE", c.getString(6));
                courier.put("RESIVERADDRESS", c.getString(7));
                courier.put("RESIVERBRANCH", c.getString(8));

                courier.put("CONTENTTYPE", c.getString(9));
                courier.put("CONTENTNAME", c.getString(10));
                courier.put("CONTENTWEIGHT", c.getString(11));
                courier.put("TOTALPRICE", c.getString(12));

                courier.put("PAYMENTMETHOD", c.getString(13));
                courier.put("CREATEDATE", c.getString(14));
                courier.put("AVAILABLEDATE", c.getString(15));
                courier.put("COURIERSTATUS", c.getString(16));
                courier.put("PAYMENTSTATUS", c.getString(17));

                courierList.add(courier);

            } while (c.moveToNext());

        }
        db.close();
        return courierList;
    }
//    ......................... End Courier get Method..................................................












//    ......................... Start Courier delete Method..................................................

    public boolean deleteCourier(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowCount = db.delete("USERCOURIER", "id = ?", new String[]{id + ""});
        db.close();
        return rowCount > 0;
    }

//    ......................... End Courier delete Method..................................................










//    ......................... Start Courier update Method..................................................
    public boolean updateCourier(CourierModel courierModel) {
        System.out.println("----------------------courierModel--------------"+ courierModel.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", courierModel.getId());

        values.put("SENDERFULLNAME", courierModel.getSenderFulname());
        values.put("SENDERPHONE", courierModel.getSenderPhn());
        values.put("SENDERADDRESS", courierModel.getSenderAddress());
        values.put("SENDERBRANCH", courierModel.getSenderBranch());

        values.put("RESIVERFULLNAME", courierModel.getResiverFulname());
        values.put("RESIVERPHONE", courierModel.getResiverPhn());
        values.put("RESIVERADDRESS", courierModel.getSresiverAddress());
        values.put("RESIVERBRANCH", courierModel.getResiverBranch());

        values.put("CONTENTTYPE", courierModel.getContentType());
        values.put("CONTENTNAME", courierModel.getContentName());
        values.put("CONTENTWEIGHT", courierModel.getContentWeight());
        values.put("TOTALPRICE", courierModel.getTotalPrice());

        int result = db.update("USERCOURIER", values, "ID = ?", new String[]{courierModel.getId() + ""});
        db.close();

        return result > 0;
    };

//    ......................... End Courier update Method..................................................






}
