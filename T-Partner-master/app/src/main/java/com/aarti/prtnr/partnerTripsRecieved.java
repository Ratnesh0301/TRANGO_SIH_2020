package com.aarti.prtnr;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class partnerTripsRecieved extends AppCompatActivity {


    ViewGroup tContainer;
    CardView crd;
    Button magicBtn;

    CardView crd1;
    Button magicBtn1;

    CardView crd2;
    Button magicBtn2;

    AppCompatRadioButton rbLeft,rbRight,rbCenter;
   /* String[] km={"10 KM","10 KM","10 KM"};
    String[] RfNo={"Reference No","Reference No","Reference No"};
    String[] time={"04:44 PM","04:44 PM","04:44 PM"};
    String[] PhNo={"+9999144103","+9999144103","+9999144103"};*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_trips_recieved);
        rbLeft=findViewById(R.id.rbLeft);
        rbRight=findViewById(R.id.rbRight);
        rbCenter=findViewById(R.id.rbCenter);

        tContainer=findViewById(R.id.transitionContainer);
        crd=findViewById(R.id.cardViewAnimated);
        magicBtn=findViewById(R.id.buttonAnimated);
        crd1=findViewById(R.id.cardViewAnimated1);
        magicBtn1=findViewById(R.id.buttonAnimated1);
        crd2=findViewById(R.id.cardViewAnimated2);
        magicBtn2=findViewById(R.id.buttonAnimated2);
        magicBtn.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(tContainer);
                visible= !visible;
                crd.setVisibility(visible ? View.VISIBLE: View.GONE);
            }
        });

        magicBtn1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(tContainer);
                visible= !visible;
                crd1.setVisibility(visible ? View.VISIBLE: View.GONE);
            }
        });

        magicBtn2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(tContainer);
                visible= !visible;
                crd2.setVisibility(visible ? View.VISIBLE: View.GONE);
            }
        });


       /* Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),km,RfNo,time,PhNo);
        spin.setAdapter(customAdapter);*/
    }

    //Performing action onItemSelected and onNothing selected

  /*  public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
    }


    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }*/



    public void onRadioButtonClicked(View view) {
        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbLeft:
                if (isSelected) {
                    rbLeft.setTextColor(Color.WHITE);
                    rbRight.setTextColor(getResources().getColor(R.color.colorPrimary));
                    rbCenter.setTextColor(getResources().getColor(R.color.colorPrimary));

                }
                break;

            case R.id.rbCenter:
                if (isSelected) {
                    rbCenter.setTextColor(Color.WHITE);
                    rbLeft.setTextColor(getResources().getColor(R.color.colorPrimary));
                    rbRight.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
                break;

            case R.id.rbRight:

                if (isSelected) {
                    rbRight.setTextColor(Color.WHITE);
                    rbLeft.setTextColor(getResources().getColor(R.color.colorPrimary));
                    rbCenter.setTextColor(getResources().getColor(R.color.colorPrimary));

                }
                break;
        }

    }

}