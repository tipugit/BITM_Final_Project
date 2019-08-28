package com.example.tourmate;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardMainActivity extends AppCompatActivity {

    BottomNavigationView navView;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_Trip:

                    loadFragment(new TripsFragment());

                    return true;

                case R.id.navigation_Memory:
                    loadFragment(new MemoryFragment());

                    return true;

                case R.id.navigation_Wallet:
                    loadFragment(new WalletFragment());

                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayoutId,fragment);
        ft.commit();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);

        init();

        loadFragment(new TripsFragment());

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

    private void init() {

        navView = findViewById(R.id.nav_view);


    }

}
