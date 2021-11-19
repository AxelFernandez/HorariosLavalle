package com.sistemas51.horarioslavalle.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.adapters.StepperRvAdapter;
import com.sistemas51.horarioslavalle.databinding.FragmentListviewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
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

        FragmentListviewBinding binding = FragmentListviewBinding.inflate(inflater,container,false);
        View v = binding.getRoot();
        rv = binding.recicler;
        List<String> routes = Arrays.asList(getResources().getStringArray(R.array.rutas));
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        Boolean special = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE).getBoolean(getString(R.string.special),false);
        stepperRvAdapter = new StepperRvAdapter(getContext(),routes,0,special, new HashMap<>());
        rv.setAdapter(stepperRvAdapter);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Seleccionar Ruta");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("Horarios Lavalle");
    }


}
