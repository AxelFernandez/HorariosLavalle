package com.sistemas51.horarioslavalle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.Help;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperAdapter;
import com.sistemas51.horarioslavalle.api.ApiRequest;
import com.sistemas51.horarioslavalle.callback.SaveData;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.galaxyofandroid.awesometablayout.AwesomeTabBar;


public class MainActivity extends AppCompatActivity implements SaveData {
    private StepperLayout mStepperLayout;
    private StepperAdapter mStepperAdapter;

    private String value;
    private Integer key;
    private Map<Integer,String> dataOnline;
    SaveData saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepper_main);
        dataOnline = new HashMap<>();

        ApiRequest apiRequest = new ApiRequest();
        apiRequest.init(getSharedPreferences("preferences", Context.MODE_PRIVATE),getApplicationContext(),getWindow().getDecorView().findViewById(android.R.id.content));
        //Test.Runtest(getApplicationContext());//prueba de que los horarios son todos del mismo largo

        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperAdapter = new StepperAdapter(getSupportFragmentManager(), this,this);
        mStepperLayout.setAdapter(mStepperAdapter);
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void saveData(Integer key, String value) {
        this.dataOnline.put(key,value);
    }

    @Override
    public Map<Integer, String> getData() {
        return this.dataOnline;
    }


}



