package com.sistemas51.horarioslavalle.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.fragments.DestinySelectedArgs;
import com.sistemas51.horarioslavalle.fragments.ResultFragment;
import com.sistemas51.horarioslavalle.models.SavedTrips;

import org.json.JSONException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {
    private Fragment active;
    private Toolbar toolbar;
    private String from;
    private String to;
    private String route;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        MaterialFavoriteButton favorite = findViewById(R.id.favorite);
        Map<String, String> hourSelected = DestinySelectedArgs.fromBundle(getIntent().getExtras()).getArgs();
        from = hourSelected.get(getResources().getString(R.string.from));
        to = hourSelected.get(getResources().getString(R.string.to));
        route = hourSelected.get(getResources().getString(R.string.route));
        toolbar = findViewById(R.id.toolbarResult);
        toolbar.setTitle(from);
        toolbar.setSubtitle(to);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10);
        }
        toolbar.bringToFront();
        Bundle bundleWeek = getIntent().getExtras();
        bundleWeek.putSerializable("arg", (Serializable) hourSelected);
        bundleWeek.putString(getResources().getString(R.string.type),getResources().getString(R.string.week));

        Bundle bundleSaturday = getIntent().getExtras();
        bundleSaturday.putSerializable("arg", (Serializable) hourSelected);
        bundleSaturday.putString(getResources().getString(R.string.type),getResources().getString(R.string.saturday));

        Bundle bundleSunday = getIntent().getExtras();
        bundleSunday.putSerializable("arg", (Serializable) hourSelected);
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
        fm.beginTransaction().add(R.id.container, week, "1").commit();

        active = week;
        try {
            favorite.setFavorite(SavedTrips.isFavorited(getSharedPreferences("preferences", Context.MODE_PRIVATE),from + " - " + to));
        } catch (JSONException e) {
            Log.e(getClass().getSimpleName(),e.getMessage());
        }

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

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


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> args = new HashMap<>();
                args.put(getResources().getString(R.string.from),to);
                args.put(getResources().getString(R.string.to),from);
                args.put(getResources().getString(R.string.route),route);
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("args", (Serializable) args);
                finish();
                startActivity(intent);
            }
        });


        favorite.setOnFavoriteChangeListener(new MaterialFavoriteButton.OnFavoriteChangeListener() {
            @Override
            public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                SharedPreferences sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
                String name = from + " - " + to;
                SavedTrips savedTrips = new SavedTrips(name,route,from,to);
                if(favorite){
                    try {
                        SavedTrips.saveTrip(sharedPreferences,savedTrips);

                    } catch (JSONException e) {
                        Log.e(getClass().getSimpleName(),e.getMessage());
                    }
                }else{
                    try {
                        SavedTrips.unsaveTrip(sharedPreferences,savedTrips);
                    } catch (JSONException e) {
                        Log.e(getClass().getSimpleName(),e.getMessage());
                    }

                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}