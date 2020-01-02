package com.sistemas51.horarioslavalle.router;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.HorarioModel;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperRvAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestinySelected extends Fragment {
    RecyclerView rv;
    StepperRvAdapter stepperRvAdapter;
    public DestinySelected() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        rv = (RecyclerView) v.findViewById(R.id.recicler);
        List<String> args = OriginSelectedArgs.fromBundle(getArguments()).getArgs();
        String routeSelected = args.get(0);
        List<String> places = HorarioModel.getPlacesFromRoute(routeSelected,getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        stepperRvAdapter = new StepperRvAdapter(getContext(),places,2, args);
        rv.setAdapter(stepperRvAdapter);

        return v;
    }

}
