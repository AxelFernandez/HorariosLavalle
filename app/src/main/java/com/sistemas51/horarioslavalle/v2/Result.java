package com.sistemas51.horarioslavalle.v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sistemas51.horarioslavalle.R;


import in.galaxyofandroid.awesometablayout.AwesomeTabBar;

public class Result extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        FloatingActionButton fb = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        final String ruta = getIntent().getExtras().getString(getString(R.string.Ruta));
        final String origen = getIntent().getExtras().getString("origen");
        final String llegada = getIntent().getExtras().getString("llegada");
        final int origennum = getIntent().getExtras().getInt("origennum");
        final int llegadanum = getIntent().getExtras().getInt("llegadanum");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(origen + "-" + llegada);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent fb = new Intent(getApplicationContext(), Result.class);
                fb.putExtra("origen", llegada);
                fb.putExtra("llegada", origen);
                fb.putExtra("origennum", llegadanum);
                fb.putExtra("llegadanum",origennum);
                fb.putExtra(getString(R.string.Ruta),ruta);

                startActivity(fb);

            }
        });
        AwesomeTabBar tabBar=(AwesomeTabBar)findViewById(R.id.tabBarbusqueda);
        ViewPager pager=(ViewPager)findViewById(R.id.viewPagers);
        pager.setAdapter(new ResultPagerAdapter(getSupportFragmentManager(),getApplicationContext(),ruta));
        tabBar.setupWithViewPager(pager);

    }

}