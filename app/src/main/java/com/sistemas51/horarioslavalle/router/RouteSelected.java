package com.sistemas51.horarioslavalle.router;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperRvAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RouteSelected extends Fragment {

    RecyclerView rv;
    StepperRvAdapter stepperRvAdapter;
    public RouteSelected() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        rv = (RecyclerView) v.findViewById(R.id.recicler);
        List<String> routes = Arrays.asList(getResources().getStringArray(R.array.rutas));
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        Boolean special = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE).getBoolean(getString(R.string.special),false);
        stepperRvAdapter = new StepperRvAdapter(getContext(),routes,0,special, new ArrayList<>());
        rv.setAdapter(stepperRvAdapter);
        return v;
    }

}
