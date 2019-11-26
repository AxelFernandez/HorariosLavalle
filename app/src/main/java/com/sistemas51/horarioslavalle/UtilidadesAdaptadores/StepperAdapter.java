package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.callback.GoNextSetp;
import com.sistemas51.horarioslavalle.stepper.RouteStepper;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

public class StepperAdapter extends AbstractFragmentStepAdapter implements GoNextSetp {
    public static String CURRENT_STEP_POSITION_KEY = "currentPosition";
    Bundle b1;

    public StepperAdapter(FragmentManager fm, Context context){
        super(fm,context);
    }


    @Override
    public Step createStep(int position) {
        b1 = new Bundle();
        switch (position){
            case 0:
                final RouteStepper step1 = new RouteStepper();
                b1.putInt(CURRENT_STEP_POSITION_KEY, position);
                step1.setArguments(b1);
                return step1;
            case 1:
                final RouteStepper step2 = new RouteStepper();
                b1.putInt(CURRENT_STEP_POSITION_KEY, position);
                step2.setArguments(b1);
                return step2;
        }
        return null;
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public void saveData(String key, String value) {
        b1.putString(key, value);
    }



}
