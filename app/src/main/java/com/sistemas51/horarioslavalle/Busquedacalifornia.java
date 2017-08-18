package com.sistemas51.horarioslavalle;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import in.galaxyofandroid.awesometablayout.AwesomeTabBar;

public class Busquedacalifornia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busquedacalifornia);

        final String origen = getIntent().getExtras().getString("origen");
        final String llegada = getIntent().getExtras().getString("llegada");
        final int origennum = getIntent().getExtras().getInt("origennum");
        final int llegadanum = getIntent().getExtras().getInt("llegadanum");
        Resources res = getResources();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarcali);
        toolbar.setTitle(origen + "-" + llegada);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                finish();
            }
        });



        AwesomeTabBar tabBar=(AwesomeTabBar)findViewById(R.id.tabBarbusquedacali);
        ViewPager pager=(ViewPager)findViewById(R.id.viewPagerscali);
        pager.setAdapter(new PagerAdapterCalifornia(getSupportFragmentManager()));
        tabBar.setupWithViewPager(pager);
    }
}