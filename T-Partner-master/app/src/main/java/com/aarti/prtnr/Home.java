package com.aarti.prtnr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    AppCompatRadioButton rbLeft,rbRight;
    private DrawerLayout drawerLayout;


    private FeaturesAdapter featuresAdapter;


    private int mCurrentPage;
    private ActionBarDrawerToggle mToggle;
    ImageView navigation;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.side_nav_view);
        rbLeft=findViewById(R.id.rbLeft);
        rbRight=findViewById(R.id.rbRight);
        drawerLayout=findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigation=findViewById(R.id.navigation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:

                        return true;
                    case R.id.nav_routes:
                        startActivity(new Intent(getApplicationContext(), partnerTripsRecieved.class));
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
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) Home.this);







        featuresAdapter=new FeaturesAdapter(this);





        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //to prevent current item select over and over
        if (item.isChecked()){
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        }

        if (id == R.id.side_home)
        {

            startActivity(new Intent(getApplicationContext(), Home.class));
        } else if (id == R.id.side_notification) {
            startActivity(new Intent(getApplicationContext(), Home.class));
        } else if (id == R.id.side_wallet) {
            startActivity(new Intent(getApplicationContext(),Statements.class));
        } else if (id == R.id.side_logout) {
            startActivity(new Intent(getApplicationContext(), Login.class));
        } else if (id == R.id.side_sos) {
            startActivity(new Intent(getApplicationContext(), SOS.class));
        } else if (id == R.id.side_profile) {
            startActivity(new Intent(getApplicationContext(), Profile.class));
        }else if (id == R.id.side_routes) {
            startActivity(new Intent(getApplicationContext(), partnerTripsRecieved.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
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
