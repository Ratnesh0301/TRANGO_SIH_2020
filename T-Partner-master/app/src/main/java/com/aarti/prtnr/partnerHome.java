package com.aarti.prtnr;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class partnerHome extends AppCompatActivity {
    AppCompatRadioButton rbLeft,rbRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_home);

        rbLeft=findViewById(R.id.rbLeft);
        rbRight=findViewById(R.id.rbRight);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:

                        return true;
                    case R.id.nav_routes:
                        startActivity(new Intent(getApplicationContext(), Routes.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_wallet:
                        startActivity(new Intent(getApplicationContext(), Wallet.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbLeft:
                if (isSelected) {
                    rbLeft.setTextColor(Color.WHITE);
                    rbRight.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
                break;

            case R.id.rbRight:

                if (isSelected) {
                    rbRight.setTextColor(Color.WHITE);
                    rbLeft.setTextColor(getResources().getColor(R.color.colorPrimary));

                }
                break;
        }

    }

}