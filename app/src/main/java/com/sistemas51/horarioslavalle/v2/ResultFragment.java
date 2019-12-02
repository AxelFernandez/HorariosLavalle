package com.sistemas51.horarioslavalle.v2;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.HorarioAdapter;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.HorarioModel;

import org.json.JSONException;
import org.json.JSONObject;


public class ResultFragment extends Fragment {
    private JSONObject database;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        RecyclerView rv;
        rv = (RecyclerView) v.findViewById(R.id.recicler);
        final String from = getArguments().getString(getResources().getString(R.string.from));
        final String to = getArguments().getString(getResources().getString(R.string.to));
        final String day = getArguments().getString(getResources().getString(R.string.type));
        final String route = getArguments().getString(getResources().getString(R.string.route));
        String arrayToSearch = HorarioModel.getNamesKey(from,to,route,day,getContext());
        String toSearch = HorarioModel.getTableName(to,route, getContext());
        String fromSearch = HorarioModel.getTableName(from,route, getContext());
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        sharedPreferences.getAll();

        try {

            database = new JSONObject();
            database.get(arrayToSearch);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        String[] arrayPartida = utils.getArrayPartida(ruta,origennum,day,isIda);
//        String[] arrayDestino = utils.getArrayPartida(ruta,llegadanum,day,isIda);

        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        HorarioAdapter forecastadaptersemana40;

        //forecastadaptersemana40 = new HorarioAdapter(HorarioModel.get40(arrayPartida,arrayDestino), getContext());

      //  rv.setAdapter(forecastadaptersemana40);

        return v;
    }
}