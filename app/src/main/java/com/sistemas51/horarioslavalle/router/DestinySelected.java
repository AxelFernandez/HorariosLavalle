package com.sistemas51.horarioslavalle.router;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.HorarioModel;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.StepperRvAdapter;

import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestinySelected extends Fragment {
    RecyclerView rv;
    StepperRvAdapter stepperRvAdapter;
    Toolbar toolbar;
    public DestinySelected() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        rv = (RecyclerView) v.findViewById(R.id.recicler);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Seleccionar Destino");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("Horarios Lavalle");

        Map<String,String> args = OriginSelectedArgs.fromBundle(getArguments()).getArgs();
        String routeSelected = args.get(getString(R.string.route));
        List<String> places = HorarioModel.getPlacesFromRoute(routeSelected,getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        stepperRvAdapter = new StepperRvAdapter(getContext(),places,2, args);
        stepperRvAdapter.notifyDataSetChanged();
        rv.setAdapter(stepperRvAdapter);

        return v;
    }

}
