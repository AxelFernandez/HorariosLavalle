package com.sistemas51.horarioslavalle.Especial.Asuncion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.sistemas51.horarioslavalle.R;

public class EspecialBusqueda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especial_busqueda);
        ImageView im = (ImageView)findViewById(R.id.imageesp);
        String dia = getIntent().getExtras().getString("dia");
        String idaovuelta=getIntent().getExtras().getString("idaovuelta");
        im.setOnTouchListener(new ImageMatrixTouchHandler(getApplicationContext()));


        if (dia.equals("1")&& idaovuelta.equals("Ida")){
            im.setImageResource(R.drawable.idalagsab);
           }

        if (dia.equals("2")&& idaovuelta.equals("Ida")){
            im.setImageResource(R.drawable.lagidadom);}



        if (dia.equals("1")&& idaovuelta.equals("Vuelta")){
            im.setImageResource(R.drawable.vueltalagsab);}

        if (dia.equals("2")&& idaovuelta.equals("Vuelta")){
            im.setImageResource(R.drawable.vueltlagdom);}



    }
}
