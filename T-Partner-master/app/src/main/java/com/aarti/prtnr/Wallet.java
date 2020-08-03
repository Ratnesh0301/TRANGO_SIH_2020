package com.aarti.prtnr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Wallet extends AppCompatActivity {
    TextView statements;
    LinearLayout expire,limit,transfer,supercash,new_mek,work;
    TextView expire_ans,limit_ans,transfer_ans,supercash_ans,new_ans,work_ans;
    ViewGroup t_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        statements=findViewById(R.id.statements);
        statements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Wallet.this,Statements.class);
                startActivity(i);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_routes:
                        startActivity(new Intent(getApplicationContext(), Routes.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_wallet:

                        return true;
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });

        expire_ans=findViewById(R.id.expire_ans);
        t_container=findViewById(R.id.transition_container);
        expire=findViewById(R.id.expire);
        expire.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(t_container);
                visible=!visible;
                expire_ans.setVisibility(visible?View.VISIBLE:View.GONE);
            }
        });

        limit_ans=findViewById(R.id.limit_ans);

        limit=findViewById(R.id.limit);
        limit.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(t_container);
                visible=!visible;
                limit_ans.setVisibility(visible?View.VISIBLE:View.GONE);
            }
        });
        transfer_ans=findViewById(R.id.transfer_ans);

        transfer=findViewById(R.id.transfer);
        transfer.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(t_container);
                visible=!visible;
                transfer_ans.setVisibility(visible?View.VISIBLE:View.GONE);
            }
        });

        supercash_ans=findViewById(R.id.supercash_ans);
        supercash=findViewById(R.id.supercash);
        supercash.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(t_container);
                visible=!visible;
                supercash_ans.setVisibility(visible?View.VISIBLE:View.GONE);
            }
        });
        new_ans=findViewById(R.id.new_ans);
        new_mek=findViewById(R.id.new_mek);
        new_mek.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(t_container);
                visible=!visible;
                new_ans.setVisibility(visible?View.VISIBLE:View.GONE);
            }
        });
        work_ans=findViewById(R.id.work_ans);
        work=findViewById(R.id.work);
        work.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(t_container);
                visible=!visible;
                work_ans.setVisibility(visible?View.VISIBLE:View.GONE);
            }
        });






    }
}
