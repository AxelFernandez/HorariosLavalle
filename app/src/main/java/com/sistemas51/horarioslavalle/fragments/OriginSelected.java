package com.sistemas51.horarioslavalle.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.models.HorarioModel;
import com.sistemas51.horarioslavalle.adapters.StepperRvAdapter;

import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class OriginSelected extends Fragment {


    private RecyclerView rv;
    private StepperRvAdapter stepperRvAdapter;
    private int arrayId;
    public OriginSelected() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Seleccionar Origen");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("Horarios Lavalle");


        rv = (RecyclerView) v.findViewById(R.id.recicler);
        Map<String, String> args = OriginSelectedArgs.fromBundle(getArguments()).getArgs();
        String routeSelected = args.get(getString(R.string.route));
        List<String> places = HorarioModel.getPlacesFromRoute(routeSelected,getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        stepperRvAdapter = new StepperRvAdapter(getContext(),places,1, args);
        rv.setAdapter(stepperRvAdapter);
        return v;
    }
}
