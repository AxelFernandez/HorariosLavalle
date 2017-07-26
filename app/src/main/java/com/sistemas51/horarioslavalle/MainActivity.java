package com.sistemas51.horarioslavalle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.Ayuda;

import in.galaxyofandroid.awesometablayout.AwesomeTabBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        AwesomeTabBar tabBar = (AwesomeTabBar) findViewById(R.id.tabBar);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabBar.setupWithViewPager(pager);

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
                Intent AddPhrase = new Intent(getApplicationContext(), Ayuda.class); //layout que quieras abrir
                startActivity(AddPhrase);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



