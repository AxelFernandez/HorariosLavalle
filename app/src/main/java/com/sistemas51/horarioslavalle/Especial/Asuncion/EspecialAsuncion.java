package com.sistemas51.horarioslavalle.Especial.Asuncion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import com.sistemas51.horarioslavalle.R;

public class EspecialAsuncion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especial_asuncion);
        final RadioGroup radiog = (RadioGroup)findViewById(R.id.radiogroup);
        final ToggleButton tg = (ToggleButton)findViewById(R.id.toglebuton);
        Button seachesp = (Button)findViewById(R.id.espasuncseach);
        tg.setTextOn("Ida");
        tg.setTextOff("Vuelta");
        tg.setChecked(true);
        final Intent intent = new Intent(getApplicationContext(),EspecialBusqueda.class);
        RadioButton rb1 = (RadioButton) findViewById(R.id.rb1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.rb2);

        rb1.setText("Sabado");
        rb2.setText("Domingo");

        rb1.setChecked(true);
        intent.putExtra("dia","1");
        radiog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.rb1){
                 intent.putExtra("dia","1");
                }else if (checkedId == R.id.rb2){
                    intent.putExtra("dia","2");
                }


            }
        });



        seachesp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                intent.putExtra("idaovuelta",tg.getText());
                startActivity(intent);

            }
        });


    }
}
