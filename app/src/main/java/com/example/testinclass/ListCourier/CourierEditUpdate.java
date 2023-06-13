package com.example.testinclass.ListCourier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.testinclass.Courier.UserCourierForm;
import com.example.testinclass.Dao.Database;
import com.example.testinclass.Entity.CourierModel;
import com.example.testinclass.Enums.CourierStatus;
import com.example.testinclass.Enums.PaymentStatus;
import com.example.testinclass.R;

public class CourierEditUpdate extends AppCompatActivity {


    EditText senderfname, senphn, senderaddrs;
    Spinner senderBranchsr;
    EditText resiverfname, renphn, riseadds;
    Spinner resiverBranchsdf;
    EditText contentnames, contweights, contentprice;
    Spinner contenttypess;

    Button btnupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courier_edit_update);

        btnupdate = findViewById(R.id.updateid);


        senderfname = findViewById(R.id.updaeidname);
        senphn = findViewById(R.id.updaeidphn);
        senderaddrs = findViewById(R.id.updaeidaddress);
        senderBranchsr = findViewById(R.id.senderupdaeidbranchd);

        resiverfname = findViewById(R.id.resiverupdaeidname);
        renphn = findViewById(R.id.resiverupdaeidphn);
        riseadds = findViewById(R.id.resiverupdaeidaddress);
        resiverBranchsdf = findViewById(R.id.resiverupdaeidbranch);

        contenttypess = findViewById(R.id.shipmentcontenttypeupdaeid);
        contentnames = findViewById(R.id.shipmentupdaeidname);
        contweights = findViewById(R.id.shipmentweightida);
        contentprice = findViewById(R.id.totalpriceeditupdate);




        Intent intent = getIntent();


        Integer id = Integer.parseInt(intent.getStringExtra("ID"));
        String sfname = intent.getStringExtra("SENDERFULLNAME");
        String snphno = intent.getStringExtra("SENDERPHONE");
        String snaddres = intent.getStringExtra("SENDERADDRESS");
        String snbrnchs = intent.getStringExtra("SENDERBRANCH");

        String rfname = intent.getStringExtra("RESIVERFULLNAME");
        String rnphno = intent.getStringExtra("RESIVERPHONE");
        String rnaddres = intent.getStringExtra("RESIVERADDRESS");
        String rnbrnch = intent.getStringExtra("RESIVERBRANCH");

        String contenttype = intent.getStringExtra("CONTENTTYPE");
        String contenttypes = intent.getStringExtra("CONTENTNAME");
        String contentweight = intent.getStringExtra("CONTENTWEIGHT");
        String price = intent.getStringExtra("TOTALPRICE");


        senderfname.setText(sfname);
        senphn.setText(snphno);
        senderaddrs.setText(snaddres);

        ArrayAdapter<CharSequence> senderadapter = ArrayAdapter.createFromResource(this, R.array.branchName, android.R.layout.simple_spinner_item);
        senderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        senderBranchsr.setAdapter(senderadapter);
        Integer senderbranchpos;


        if(snbrnchs.contains("Dhaka")) {
            senderbranchpos = senderadapter.getPosition("Dhaka");
            senderBranchsr.setSelection(senderbranchpos);
        } else if (snbrnchs.contains("Chandpur")) {
            senderbranchpos = senderadapter.getPosition("Chandpur");
            senderBranchsr.setSelection(senderbranchpos);
        } else if (snbrnchs.contains("Cumilla")) {
            senderbranchpos = senderadapter.getPosition("Cumilla");
            senderBranchsr.setSelection(senderbranchpos);
        } else if (snbrnchs.contains("Chottogram")) {
            senderbranchpos = senderadapter.getPosition("Chottogram");
            senderBranchsr.setSelection(senderbranchpos);
        } else{
            senderBranchsr.setSelection(0);
        }



        resiverfname.setText(rfname);
        renphn.setText(rnphno);
        riseadds.setText(rnaddres);
        ArrayAdapter<CharSequence> resiveradapter = ArrayAdapter.createFromResource(this, R.array.branchName, android.R.layout.simple_spinner_item);
        resiveradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resiverBranchsdf.setAdapter(resiveradapter);
        Integer resiverpos;
        if(rnbrnch.contains("Dhaka")) {
            resiverpos = resiveradapter.getPosition("Dhaka");
            resiverBranchsdf.setSelection(resiverpos);
        } else if (rnbrnch.contains("Chandpur")) {
            resiverpos = resiveradapter.getPosition("Chandpur");
            resiverBranchsdf.setSelection(resiverpos);
        } else if (rnbrnch.contains("Cumilla")) {
            resiverpos = resiveradapter.getPosition("Cumilla");
            resiverBranchsdf.setSelection(resiverpos);
        } else if (rnbrnch.contains("Chottogram")) {
            resiverpos = resiveradapter.getPosition("Chottogram");
            resiverBranchsdf.setSelection(resiverpos);
        } else{
            resiverBranchsdf.setSelection(0);
        }


        ArrayAdapter<CharSequence> adp = ArrayAdapter.createFromResource(this, R.array.contentItem, android.R.layout.simple_spinner_item);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contenttypess.setAdapter(adp);


        Integer posss;
        if (contenttype.contains("Fruts")){
            posss = adp.getPosition("Fruts");
            contenttypess.setSelection(posss);
        }else if (contenttype.contains("Pepars")){
            posss = adp.getPosition("Pepars");
            contenttypess.setSelection(posss);
        }else  if (contenttype.contains("Fish")){
            posss = adp.getPosition("Fish");
            contenttypess.setSelection(posss);
        }else if (contenttype.contains("Meat")){
            posss = adp.getPosition("Meat");
            contenttypess.setSelection(posss);
        }else{
            contenttypess.setSelection(0);
        }
        contentnames.setText(contenttypes);
        contweights.setText(contentweight);
        contentprice.setText(price);





//        --------------------------------------------------------Start UpdateMethod-----------------------------------------------------------


        Database db = new Database(getApplicationContext(), "healthcare", null, 1);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



//              Sender getValue
                String  sfname = senderfname.getText().toString();
                String sph = senphn.getText().toString();
                String saddress = senderaddrs.getText().toString();
                String sBranch = senderBranchsr.getSelectedItem().toString();

//              resiver getValue
                String  refname = resiverfname.getText().toString();
                String reph  = renphn.getText().toString();
                String resiveraddress = riseadds.getText().toString();
                String resiverBranch = resiverBranchsdf.getSelectedItem().toString();

//              shipment getvalue
                String contentValeu = contenttypess.getSelectedItem().toString();
                String contentNames = contentnames.getText().toString();
                String contenWeights = contweights.getText().toString();
                String totalPrice = contentprice.getText().toString();


                CourierModel courier = new CourierModel();

                courier.setId(id);
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


                Boolean result = db.updateCourier(courier);

                String message = result ? "Successfully Updated!" : "Failed to Update.";

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();//





            }
        });
//        --------------------------------------------------------End UpdateMethod-----------------------------------------------------------




    }




}