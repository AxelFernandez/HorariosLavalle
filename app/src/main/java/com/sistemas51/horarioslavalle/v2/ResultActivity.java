package com.sistemas51.horarioslavalle.v2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.Help;

public class ResultActivity extends AppCompatActivity {
    Fragment active;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        String from = getIntent().getExtras().getString(getResources().getString(R.string.from));
        String to = getIntent().getExtras().getString(getResources().getString(R.string.to));
        toolbar = findViewById(R.id.toolbarResult);
        toolbar.setTitle(from);
        toolbar.setSubtitle(to);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10);
        }
        toolbar.bringToFront();
        Bundle bundleWeek = getIntent().getExtras();
        bundleWeek.putString(getResources().getString(R.string.type),getResources().getString(R.string.week));
        Bundle bundleSaturday = getIntent().getExtras();
        bundleSaturday.putString(getResources().getString(R.string.type),getResources().getString(R.string.saturday));
        Bundle bundleSunday = getIntent().getExtras();
        bundleSunday.putString(getResources().getString(R.string.type),getResources().getString(R.string.sunday));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
            case R.id.help:
                Intent help = new Intent(getApplicationContext(), Help.class);
                startActivity(help);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
