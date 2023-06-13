package com.example.testinclass.Courier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.testinclass.Dao.Database;
import com.example.testinclass.Entity.CourierModel;
import com.example.testinclass.Enums.CourierStatus;
import com.example.testinclass.Enums.PaymentStatus;
import com.example.testinclass.Home;
import com.example.testinclass.LoginForm;
import com.example.testinclass.R;
import com.example.testinclass.SignupForm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCourierForm extends AppCompatActivity{

//      start   RegistrationButton global variable
//      sender variable
        EditText senderfname;
        EditText editTextsenderphn;
        EditText editTextsenderAddres;
        Spinner senderBranSpiner;
//      resiver variable
        EditText resiverfname;
        EditText editTextresiverph;
        EditText editTextresiverAddres;
        Spinner sresiverBranSpiner;
//      shipment variable
        Spinner contentTypeSpin;
        EditText contentName;
        EditText contentWeight;
        EditText priceAmount;
//      payment method
        RadioGroup radioGroup;
        Button buttonCurierReg;
//      end   RegistrationButton global variable

    Button buttonBackHOme;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_courier_form);

        buttonBackHOme = findViewById(R.id.Backhome);

//...................................start   RegistrationButton.....................................................
//      Sender binding
        buttonCurierReg = findViewById(R.id.courierRegistrationid);
        senderfname = findViewById(R.id.fullnameId);
        editTextsenderphn = findViewById(R.id.phnId);
        editTextsenderAddres = findViewById(R.id.addressdid);
        senderBranSpiner = findViewById(R.id.senderbranID);
//      Resiver Binding
        resiverfname = findViewById(R.id.fullnameIdresiver);
        editTextresiverph = findViewById(R.id.phnIdresiver);
        editTextresiverAddres = findViewById(R.id.addressdidresiver);
        sresiverBranSpiner = findViewById(R.id.resiverbranID);
//      shipment binding
        contentTypeSpin = findViewById(R.id.contentTypeid);
        contentName = findViewById(R.id.contentnameID);
        contentWeight = findViewById(R.id.contetnWeightId);
        priceAmount = findViewById(R.id.chargAmountID);
//      paymentmathod
        radioGroup = (RadioGroup)findViewById(R.id.radiogrouid);
        radioGroup.clearCheck();

        Database db = new Database(getApplicationContext(),"healthcare", null, 1);

        buttonCurierReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//              Sender getValue
                String  sfname = senderfname.getText().toString();
                String sph = editTextsenderphn.getText().toString();
                String saddress = editTextsenderAddres.getText().toString();
                String sBranch = senderBranSpiner.getSelectedItem().toString();
//              resiver getValue
                String  refname = resiverfname.getText().toString();
                String reph  = editTextresiverph.getText().toString();
                String resiveraddress = editTextresiverAddres.getText().toString();
                String resiverBranch = sresiverBranSpiner.getSelectedItem().toString();
//              shipment getvalue
                String contentValeu = contentTypeSpin.getSelectedItem().toString();
                String contentNames = contentName.getText().toString();
                String contenWeights = contentWeight.getText().toString();
                String totalPrice = priceAmount.getText().toString();

//              Payment method
                String paymentMaythods = "";
                int selectID = radioGroup.getCheckedRadioButtonId();
                if (selectID == -1){
                    Toast.makeText(UserCourierForm.this, "Please select Payment Method", Toast.LENGTH_SHORT).show();
                }else {
                    RadioButton radioButton = findViewById(selectID);
                    paymentMaythods = radioButton.getText().toString();
                }


                CourierModel courier = new CourierModel();
                courier.setSenderFulname(sfname);
                courier.setSenderPhn(sph);
                courier.setSenderAddress(saddress);
                courier.setSenderBranch(sBranch);

                courier.setResiverFulname(refname);
                courier.setResiverPhn(reph);
                courier.setSresiverAddress(resiveraddress);
                courier.setResiverBranch(resiverBranch);

                courier.setContentType(contentValeu);
                courier.setContentName(contentNames);
                courier.setContentWeight(contenWeights);
                courier.setTotalPrice(totalPrice);
                courier.setPaymentMethos(paymentMaythods);


                long millis=System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                courier.setCreateDate(date);

                long milliss=System.currentTimeMillis();
                java.sql.Date dats = new java.sql.Date(milliss+172800000);
                courier.setAvaileAbleDate(dats);


                courier.setCourierStatus(CourierStatus.Pending);

                if (courier.getPaymentMethos().equals("Online Payment")){
                    courier.setPaymentStatus(PaymentStatus.Paid);
                }else {
                    courier.setPaymentStatus(PaymentStatus.Due);
                }





                db.addCourier(courier);








//                Toast.makeText(getApplicationContext(),
//           "Sender Name =  "+ sfname +"\n"+
//                   "Sender Phone = "+ sph +"\n"+
//                   "Sender Address = "+ saddress +"\n"+
//                   "Sender Dropdeown = "+ sBranch+"\n"+"\n"+
//
//                   "Resiver Name =  "+ refname +"\n"+
//                   "Resiver Phone = "+ reph +"\n"+
//                   "Resiver Address = "+ resiveraddress +"\n"+
//                   "Resiver Dropdeown = "+ resiverBranch+"\n"+"\n"+
//
//                   "Content type = "+ contentValeu+"\n"+
//                   "Content Name = "+ contentNames+"\n"+
//                   "Content Weight = "+ contenWeights+"\n"+
//                   "Total Price = "+ totalPrice+"\n"+"\n"+
//                   "Payment Method = "+ paymentMaythods+"\n"
//                   ,Toast.LENGTH_SHORT).show();


            }
        });
//  ...................................end RegistrationButton.......................................


        buttonBackHOme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserCourierForm.this, Home.class);
                startActivity(intent);
            }
        });





    }





//    public void onRadioButtonClicked(View view){
//        int radioid = radioGroup.getCheckedRadioButtonId();
//        radioButton = findViewById(radioid);
////        Toast.makeText(this, "Selected value = " + radioButton.getText(), Toast.LENGTH_SHORT).show();
//    }



}