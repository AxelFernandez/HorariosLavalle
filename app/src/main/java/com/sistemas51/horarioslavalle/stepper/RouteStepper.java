package com.sistemas51.horarioslavalle.stepper;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperRvAdapter;
import com.sistemas51.horarioslavalle.callback.Callback;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Arrays;
import java.util.HashMap;
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
        stepperRvAdapter = new StepperRvAdapter(getContext(),routes);
        rv.setAdapter(stepperRvAdapter);
        return v;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void setArrayId(int arrayId) {
        List<String> routes = Arrays.asList(getResources().getStringArray(arrayId));
        stepperRvAdapter = new StepperRvAdapter(getContext(),routes);
        rv.setAdapter(stepperRvAdapter);
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        if (this.callback != null) {
            this.callback.callBack(stepperRvAdapter.getSelected(), getArguments().getInt(CURRENT_STEP_POSITION_KEY));
        }
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
      //  Intent intent =  new Intent(getContext(), Result.class);
        //intent.putExtra("or")
        //startActivity(intent);

        Map<Integer,String> data = new HashMap<>();
        data = this.callback.getData();
        String lastOne = stepperRvAdapter.getSelected();
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

    /**
     * Return the correct spinner in one class
     * @param type Send 'Ruta24' 'Ruta40' or 'California'
     * @return Array whit data for spinners
     */
    private String[] getParams (int type){
        String[] result = null;
        String route =  "Ruta 24";

        if (type == 0){
            result = getResources().getStringArray(R.array.rutas);
        }else{
            if (saveData != null ){
                route = saveData;
            }
            if (type == 1 && route.equals("Ruta 24")){
                result = getResources().getStringArray(R.array.nombredelugares);
            }else if (type == 1 && route == "Ruta 40"){
                result = getResources().getStringArray(R.array.nombredelugaresr40);
            }else if (type == 1 && route == "California"){
                result = getResources().getStringArray(R.array.nombrelugarescalifornia);
            }

        }
        return result;
    }


}
