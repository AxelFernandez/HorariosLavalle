package com.sistemas51.horarioslavalle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sistemas51.horarioslavalle.activity.Help;
import com.sistemas51.horarioslavalle.api.ApiRequest;
import com.sistemas51.horarioslavalle.api.PushNotification;


public class MainActivity extends AppCompatActivity {
    boolean special;
    Toolbar toolbar;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepper_main);

        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.init(sharedPreferences,getApplicationContext(),getWindow().getDecorView().findViewById(android.R.id.content));
        special = sharedPreferences.getBoolean("special",false);
        toolbar = findViewById(R.id.toolbarStep);

        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10);
        }
        toolbar.bringToFront();
        PushNotification.getToken(getApplicationContext());
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                Intent help = new Intent(getApplicationContext(), Help.class);
                startActivity(help);
                return true;
            case R.id.download:
                new ApiRequest().forceDownload(sharedPreferences,getApplicationContext(),getWindow().getDecorView().findViewById(android.R.id.content));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}



