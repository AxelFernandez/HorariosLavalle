package com.sistemas51.horarioslavalle.v2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sistemas51.horarioslavalle.R;

public class ResultActivity extends AppCompatActivity {
    Fragment active;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        Bundle bundleWeek = getIntent().getExtras();
        bundleWeek.putString(getResources().getString(R.string.type),getResources().getString(R.string.week));
        Bundle bundleSaturday = getIntent().getExtras();
        bundleSaturday.putString(getResources().getString(R.string.type),getResources().getString(R.string.saturday));
        Bundle bundleSunday = getIntent().getExtras();
        bundleSunday.putString(getResources().getString(R.string.type),getResources().getString(R.string.sunday));


        final Fragment week = new ResultFragment();
        week.setArguments(bundleWeek);
        final Fragment saturday = new ResultFragment();
        saturday.setArguments(bundleSaturday);
        final Fragment sunday = new ResultFragment();
        sunday.setArguments(bundleSunday);
        final FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.container, sunday, "3").hide(sunday).commit();
        fm.beginTransaction().add(R.id.container, saturday, "2").hide(saturday).commit();
        fm.beginTransaction().add(R.id.container,week, "1").commit();

        active = week;

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.navigation_week:
                        fm.beginTransaction().hide(active).show(week).commit();
                        active = week;
                        return true;

                    case R.id.navigation_saturday:
                        fm.beginTransaction().hide(active).show(saturday).commit();
                        active = saturday;
                        return true;

                    case R.id.navigation_sunday:
                        fm.beginTransaction().hide(active).show(sunday).commit();
                        active = sunday;
                        return true;
                }
                return false;


                }

        });


    }



}
