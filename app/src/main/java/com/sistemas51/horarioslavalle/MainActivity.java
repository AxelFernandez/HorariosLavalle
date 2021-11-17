package com.sistemas51.horarioslavalle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SafeBrowsingResponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.sistemas51.horarioslavalle.adapters.DashboardAdapter;
import com.sistemas51.horarioslavalle.api.ApiRequest;
import com.sistemas51.horarioslavalle.api.PushNotification;
import com.sistemas51.horarioslavalle.models.SavedTrips;

import org.json.JSONException;

import java.util.List;
import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {
    boolean special;
    Toolbar toolbar;
    private SharedPreferences sharedPreferences;
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private DashboardAdapter dashboardAdapter;
    List<SavedTrips> savedTrips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepper_main);

        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        ApiRequest apiRequest = new ApiRequest();
        View view = getWindow().getDecorView().findViewById(android.R.id.content);
        apiRequest.init(sharedPreferences, getApplicationContext(), view);
        special = sharedPreferences.getBoolean("special", false);
        toolbar = findViewById(R.id.toolbarStep);
        recyclerView = findViewById(R.id.dashboard_rv);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10);
        }
        toolbar.bringToFront();

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.navigation_view);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);

        NavigationUI.setupWithNavController(navigationView, navController);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        dashboardAdapter = null;

        try {
            savedTrips = SavedTrips.getSavedTrips(sharedPreferences);
            dashboardAdapter = new DashboardAdapter(savedTrips, getApplicationContext(), sharedPreferences, view, getParent());
        } catch (JSONException e) {
            Log.e(getClass().getSimpleName(),e.getMessage());
        }
        dashboardAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(dashboardAdapter);


        //PushNotification.getToken(getApplicationContext());
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            savedTrips = SavedTrips.getSavedTrips(sharedPreferences);
            dashboardAdapter.setModels(savedTrips);
            dashboardAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            Log.e(getClass().getSimpleName(),e.getMessage());
        }
    }
}



