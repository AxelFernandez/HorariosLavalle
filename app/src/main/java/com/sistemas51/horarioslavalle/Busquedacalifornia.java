package com.sistemas51.horarioslavalle;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sistemas51.horarioslavalle.Ruta24.Busqueda24;

import in.galaxyofandroid.awesometablayout.AwesomeTabBar;

public class Busquedacalifornia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busquedacalifornia);
        FloatingActionButton fb = (FloatingActionButton)findViewById(R.id.floatingActionButtonr24);

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
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent fb = new Intent(getApplicationContext(), Busqueda24.class);
                fb.putExtra("origen", llegada);
                fb.putExtra("llegada", origen);
                fb.putExtra("origennum", llegadanum);
                fb.putExtra("llegadanum",origennum);
                startActivity(fb);

            }
        });


        AwesomeTabBar tabBar=(AwesomeTabBar)findViewById(R.id.tabBarbusquedacali);
        ViewPager pager=(ViewPager)findViewById(R.id.viewPagerscali);
        pager.setAdapter(new PagerAdapterCalifornia(getSupportFragmentManager()));
        tabBar.setupWithViewPager(pager);
    }
}
