package com.sistemas51.horarioslavalle;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperAdapter;
import com.sistemas51.horarioslavalle.api.ApiRequest;
import com.sistemas51.horarioslavalle.callback.Callback;
import com.sistemas51.horarioslavalle.stepper.RouteStepper;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.HashMap;
import java.util.Map;

//TODO: Moto e5 instant crash (API?)
//TODO: Make a error if the user select next step without select an option
//TODO: Hide the SnackBar if user click in a no hour holder in RecyclerView
//TODO: Make more beauty Help Activity
//TODO: Change the icon, it will be deprecated, it will be a square.

public class MainActivity extends AppCompatActivity implements Callback, StepperLayout.StepperListener {
    private StepperLayout mStepperLayout;
    private StepperAdapter mStepperAdapter;
    Map<Integer, String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stepper_main);
        getSupportActionBar().setTitle("Selecciona Ruta");
        getSupportActionBar().setSubtitle("Horarios Lavalle");
        data = data == null ? data = new HashMap<>(): data;
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.init(getSharedPreferences("preferences", Context.MODE_PRIVATE),getApplicationContext(),getWindow().getDecorView().findViewById(android.R.id.content));

        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperAdapter = new StepperAdapter(getSupportFragmentManager(), this, this);
        mStepperLayout.setAdapter(mStepperAdapter);

    }


    @Override
    public void callBack(String step, int stepNumber) {
        data.put(stepNumber,step);
        int arrayId= 0;

        if (stepNumber ==0){
            getSupportActionBar().setTitle("Selecciona Punto de Partida");
            getSupportActionBar().setSubtitle("Horarios Lavalle");
        } else if (stepNumber == 1){
            step =getData().get(0);
            getSupportActionBar().setTitle("Selecciona Destino");
            getSupportActionBar().setSubtitle("Horarios Lavalle");
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
}



