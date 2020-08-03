package com.aarti.prtnr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;



public class Profile extends AppCompatActivity {

    Button changePassword;
    Dialog epicDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView bg = findViewById(R.id.bg);

        Glide.with(this)
                .load(R.drawable.asset)
                .into(bg);
        epicDialogue=new Dialog(this);
        changePassword=findViewById(R.id.changePass);

    }
    public void dialoguePopup(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(Profile.this);
        View mView = getLayoutInflater().inflate(R.layout.chage_password,null);
        final CardView crd=(CardView)mView.findViewById(R.id.alertCard);
        Button savePass=(Button)mView.findViewById(R.id.savePassword);

        alert.setView(mView);

        final AlertDialog alertDialog=alert.create();
        alertDialog.setCanceledOnTouchOutside(false);

        savePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }
}




