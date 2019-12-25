package com.sistemas51.horarioslavalle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.Help;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperAdapter;
import com.sistemas51.horarioslavalle.api.ApiRequest;
import com.sistemas51.horarioslavalle.callback.Callback;
import com.sistemas51.horarioslavalle.stepper.RouteStepper;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.HashMap;
import java.util.Map;

//TODO: Moto e5 instant crash (API?)
//TODO: Change the icon, it will be deprecated, it will be a square.

public class MainActivity extends AppCompatActivity implements Callback, StepperLayout.StepperListener {
    private StepperLayout mStepperLayout;
    private StepperAdapter mStepperAdapter;
    boolean special;
    Map<Integer, String> data;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepper_main);
        SharedPreferences sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.init(sharedPreferences,getApplicationContext(),getWindow().getDecorView().findViewById(android.R.id.content));
        special = sharedPreferences.getBoolean("special",false);
        toolbar = findViewById(R.id.toolbarStep);
        toolbar.setTitle("Selecciona Ruta");
        toolbar.setSubtitle("Horarios Lavalle");
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setElevation(10);
        }
        toolbar.bringToFront();
        data = data == null ? data = new HashMap<>(): data;

        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperAdapter = new StepperAdapter(getSupportFragmentManager(), this, this);
        mStepperLayout.setNextButtonEnabled(false);
        mStepperLayout.setCompleteButtonEnabled(false);
        mStepperLayout.setAdapter(mStepperAdapter);

    }


    @Override
    public void callBack(String step, int stepNumber) {
        data.put(stepNumber,step);
        int arrayId= 0;

        if (stepNumber ==0){
            toolbar.setTitle("Selecciona Punto de Partida");
            toolbar.setSubtitle("Horarios Lavalle");
        } else if (stepNumber == 1){
            step =getData().get(0);
            toolbar.setTitle("Selecciona Destino");
            toolbar.setSubtitle("Horarios Lavalle");
        }
        if (step.equals("Ruta 24")){
            arrayId = R.array.nombredelugares;
        }else if (step.equals("Ruta 40")){
            arrayId = R.array.nombredelugaresr40;
        }else if (step.equals("California")){
            arrayId = R.array.nombrelugarescalifornia;
        }
        RouteStepper stepper = (RouteStepper) mStepperAdapter.findStep(stepNumber + 1);
        if (stepNumber != 2){
            stepper.setArrayId(arrayId);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mStepperLayout.proceed();
            }
        }, 200);
    }

    @Override
    public Map<Integer, String> getData() {
        return data;
    }

    @Override
    public boolean getSpecial() {
       return getSharedPreferences("preferences", Context.MODE_PRIVATE).getBoolean("special",false);
    }

    @Override
    public void moveToStep(int step) {
        mStepperLayout.setCurrentStepPosition(step);
    }

    @Override
    public void onCompleted(View completeButton) {

    }

    @Override
    public void onError(VerificationError verificationError) {

    }

    @Override
    public void onStepSelected(int newStepPosition) {

    }

    @Override
    public void onReturn() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mStepperLayout.getCurrentStepPosition() != 0){
            mStepperLayout.setCurrentStepPosition(0);

        }

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
        }
        return super.onOptionsItemSelected(item);
    }
}



