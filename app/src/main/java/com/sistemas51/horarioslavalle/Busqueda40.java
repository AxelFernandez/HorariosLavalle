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

public class Busqueda40 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busquedanew40);
        FloatingActionButton fb = (FloatingActionButton)findViewById(R.id.floatingActionButtonr40);


        final String origen = getIntent().getExtras().getString("origen");
        final String llegada = getIntent().getExtras().getString("llegada");
        final int origennum = getIntent().getExtras().getInt("origennum");
        final int llegadanum = getIntent().getExtras().getInt("llegadanum");
        Resources res = getResources();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar40);
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
      //  fb.setVisibility(View.GONE);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent fb = new Intent(getApplicationContext(), Busqueda40.class);
                fb.putExtra("origen", llegada);
                fb.putExtra("llegada", origen);
                fb.putExtra("origennum", llegadanum);
                fb.putExtra("llegadanum",origennum);
                startActivity(fb);

            }
        });
        AwesomeTabBar tabBar=(AwesomeTabBar)findViewById(R.id.tabBarbusqueda40);
        ViewPager pager=(ViewPager)findViewById(R.id.viewPagers40);
        pager.setAdapter(new PagerAdapter40(getSupportFragmentManager()));
        tabBar.setupWithViewPager(pager);

    }

}

