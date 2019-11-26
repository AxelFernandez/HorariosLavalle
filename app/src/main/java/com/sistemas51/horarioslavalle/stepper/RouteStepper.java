package com.sistemas51.horarioslavalle.stepper;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.HorarioAdapter;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.HorarioModel;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperAdapter;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperRvAdapter;
import com.sistemas51.horarioslavalle.callback.GoNextSetp;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RouteStepper extends Fragment implements BlockingStep {
    GoNextSetp goNextSetp;
    RecyclerView rv;
    public RouteStepper() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        rv = (RecyclerView) v.findViewById(R.id.recicler);
        List<String> routes = Arrays.asList(getParams(this.getArguments().getInt("currentPosition")));
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        StepperRvAdapter stepperRvAdapter = new StepperRvAdapter(getContext(),routes);
        rv.setAdapter(stepperRvAdapter);
        return v;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {

    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    /**
     * Return the correct spinner in one class
     * @param type Send 'Ruta24' 'Ruta40' or 'California'
     * @return Array whit data for spinners
     */
    private String[] getParams (int type){
        String[] result = null;
        if (type == 0){
            result = getResources().getStringArray(R.array.rutas);
        }else{
            if (type == 1 && getArguments().getString("routes").equals("Ruta 24")){
                result = getResources().getStringArray(R.array.nombredelugares);
            }else if (type == 1 && getArguments().getString("routes") == "Ruta 40"){
                result = getResources().getStringArray(R.array.nombredelugaresr40);
            }else if (type == 1 && getArguments().getString("routes") == "California"){
                result = getResources().getStringArray(R.array.nombrelugarescalifornia);
            }

        }
        return result;
    }


}
