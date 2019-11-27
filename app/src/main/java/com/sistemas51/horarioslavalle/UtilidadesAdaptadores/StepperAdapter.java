package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;

import com.sistemas51.horarioslavalle.callback.SaveData;
import com.sistemas51.horarioslavalle.stepper.RouteStepper;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

public class StepperAdapter extends AbstractFragmentStepAdapter {
    public static String CURRENT_STEP_POSITION_KEY = "currentPosition";
    Bundle b1;
    SaveData saveData;
    public StepperAdapter(FragmentManager fm, Context context, SaveData saveData){
        super(fm,context);
        this.saveData = saveData;
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


}
