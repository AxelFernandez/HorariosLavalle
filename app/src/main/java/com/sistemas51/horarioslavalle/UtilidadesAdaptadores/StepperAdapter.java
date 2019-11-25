package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.sistemas51.horarioslavalle.stepper.SelectStepper;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

public class StepperAdapter extends AbstractFragmentStepAdapter {
    public static String CURRENT_STEP_POSITION_KEY = "currentPosition";
    public StepperAdapter(FragmentManager fm, Context context){
        super(fm,context);
    }


    @Override
    public Step createStep(int position) {
        switch (position){
            case 0:
                final SelectStepper step1 = new SelectStepper();
                Bundle b1 = new Bundle();
                b1.putInt(CURRENT_STEP_POSITION_KEY, position);
                step1.setArguments(b1);
                return step1;
            case 1:
                final SelectStepper step2 = new SelectStepper();
                Bundle b2 = new Bundle();
                b2.putInt(CURRENT_STEP_POSITION_KEY, position);
                step2.setArguments(b2);
                return step2;
        }
        return null;
    }


    @Override
    public int getCount() {
        return 0;
    }
}
