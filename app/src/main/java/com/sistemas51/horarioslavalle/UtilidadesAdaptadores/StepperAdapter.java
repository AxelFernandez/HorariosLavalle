package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.sistemas51.horarioslavalle.callback.Callback;
import com.sistemas51.horarioslavalle.stepper.RouteStepper;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class StepperAdapter extends AbstractFragmentStepAdapter {

    private final Callback callback;

    public StepperAdapter(FragmentManager fm, Context context, Callback callback){
        super(fm,context);
        this.callback = callback;
    }


    @Override
    public Step createStep(int position) {
        Bundle b1 = new Bundle();
        switch (position){
            case 0:
                final RouteStepper step1 = new RouteStepper();
                step1.setCallback(callback);
                b1.putInt(RouteStepper.CURRENT_STEP_POSITION_KEY, position);
                step1.setArguments(b1);
                return step1;
            case 1:
                final RouteStepper step2 = new RouteStepper();
                step2.setCallback(callback);
                b1.putInt(RouteStepper.CURRENT_STEP_POSITION_KEY, position);
                step2.setArguments(b1);
                return step2;
            case 2:
                final RouteStepper step3 = new RouteStepper();
                step3.setCallback(callback);
                b1.putInt(RouteStepper.CURRENT_STEP_POSITION_KEY, position);
                step3.setArguments(b1);
                return step3;
        }
        return null;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        switch (position){
            case 0:
                return new StepViewModel.Builder(context)
                        .setTitle("Seleccionar Ruta")
                        .create();
            case 1:
                return new StepViewModel.Builder(context)
                        .setTitle("Seleccionar Origen")
                        .create();
            case 2:
                return new StepViewModel.Builder(context)
                        .setTitle("Selecionar Destino")
                        .create();
        }

        return null;
    }
    @Override
    public int getCount() {
        return 3;
    }


}
