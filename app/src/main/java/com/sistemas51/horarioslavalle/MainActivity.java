package com.sistemas51.horarioslavalle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.Help;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperAdapter;
import com.sistemas51.horarioslavalle.api.ApiRequest;
import com.sistemas51.horarioslavalle.callback.Callback;
import com.sistemas51.horarioslavalle.stepper.RouteStepper;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity implements Callback, StepperLayout.StepperListener {
    private StepperLayout mStepperLayout;
    private StepperAdapter mStepperAdapter;
    Map<Integer, String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepper_main);
        data = data == null ? data = new HashMap<>(): data;
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.init(getSharedPreferences("preferences", Context.MODE_PRIVATE),getApplicationContext(),getWindow().getDecorView().findViewById(android.R.id.content));
        //Test.Runtest(getApplicationContext());//prueba de que los horarios son todos del mismo largo

        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperAdapter = new StepperAdapter(getSupportFragmentManager(), this, this);
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
    public void callBack(String step, int stepNumber) {
        data.put(stepNumber,step);
        int arrayId= 0;
        if (stepNumber == 1){
            step =getData().get(0);
        }

        if (step.equals("Ruta 24")){
            arrayId = R.array.nombredelugares;
        }else if (step.equals("Ruta 40")){
            arrayId = R.array.nombredelugaresr40;
        }else if (step.equals("California")){
            arrayId = R.array.nombrelugarescalifornia;
        }
        RouteStepper stepper = (RouteStepper) mStepperAdapter.findStep(stepNumber + 1);
        stepper.setArrayId(arrayId);
    }

    @Override
    public Map<Integer, String> getData() {
        return data;
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
    finish();
    }
}



