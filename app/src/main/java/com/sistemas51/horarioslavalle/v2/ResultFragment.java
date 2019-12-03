package com.sistemas51.horarioslavalle.v2;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class ResultFragment extends Fragment {
    private JSONObject database;
    private JSONObject placeFound;
    private List originArray;
    private List destinyArray;
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
        String fromSearch = HorarioModel.getTableName(from,route, getContext());
        String toSearch = HorarioModel.getTableName(to,route, getContext());
        int numberDay = -1;
        if (day == getResources().getString(R.string.saturday)){
            numberDay = 7;
        }else if (day == getResources().getString(R.string.sunday)){
            numberDay = 1;
        }


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        sharedPreferences.getAll();

        try {

            database = new JSONObject(sharedPreferences.getString("database",null));
            placeFound = database.getJSONObject(arrayToSearch);
            originArray = HorarioModel.getFromJsonArray(placeFound.getJSONArray(fromSearch));
            destinyArray = HorarioModel.getFromJsonArray(placeFound.getJSONArray(toSearch));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        HorarioAdapter adapter;
        try {
            adapter = new HorarioAdapter(HorarioModel.get40(originArray,destinyArray,numberDay), getContext());
            rv.setAdapter(adapter);
        } catch (ParseException e) {
            Log.e("ParseException",e.getMessage());
        }
        return v;
    }

}