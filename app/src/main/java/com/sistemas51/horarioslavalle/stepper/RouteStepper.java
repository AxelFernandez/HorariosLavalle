package com.sistemas51.horarioslavalle.stepper;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperRvAdapter;
import com.sistemas51.horarioslavalle.callback.Callback;
import com.sistemas51.horarioslavalle.v2.ResultActivity;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class RouteStepper extends Fragment implements BlockingStep {
    public static String CURRENT_STEP_POSITION_KEY = "currentPosition";

    private String saveData;
    private RecyclerView rv;
    StepperRvAdapter stepperRvAdapter;
    private Callback callback;

    public RouteStepper() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        rv = (RecyclerView) v.findViewById(R.id.recicler);
        List<String> routes = Arrays.asList(getResources().getStringArray(R.array.rutas));
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        int currentStep = getArguments().getInt(CURRENT_STEP_POSITION_KEY);
        stepperRvAdapter = new StepperRvAdapter(getContext(),routes,callback,currentStep);
        rv.setAdapter(stepperRvAdapter);
        return v;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void setArrayId(int arrayId) {
        List<String> routes = Arrays.asList(getResources().getStringArray(arrayId));
        stepperRvAdapter = new StepperRvAdapter(getContext(),routes, callback,getArguments().getInt(CURRENT_STEP_POSITION_KEY));
        rv.setAdapter(stepperRvAdapter);
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        try {
            Map<Integer,String> data = this.callback.getData();
            String lastOne = stepperRvAdapter.getSelected();
            Intent intent = new Intent(getContext(), ResultActivity.class);
            if(data.get(0)!= null && data.get(1) != null && lastOne != null){
                intent.putExtra(getResources().getString(R.string.route),data.get(0));
                intent.putExtra(getResources().getString(R.string.from),data.get(1));
                intent.putExtra(getResources().getString(R.string.to),lastOne);
                startActivity(intent);
            }else{
                this.callback.moveToStep(0);
                Snackbar.make(getView(),"Hubo un problema, vuelve a consultar",Snackbar.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Log.e("Error in RouteStepper",e.getMessage());
            this.callback.moveToStep(0);
        }

        callback.complete();
    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
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


}
