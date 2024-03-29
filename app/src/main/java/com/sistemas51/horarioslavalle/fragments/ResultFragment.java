package com.sistemas51.horarioslavalle.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.adapters.HorarioAdapter;
import com.sistemas51.horarioslavalle.models.HorarioModel;
import com.sistemas51.horarioslavalle.repository.CommonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


public class ResultFragment extends Fragment {
    private List originArray;
    private List destinyArray;
    private List additional;
    private RecyclerView rv;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_listview, container, false);

        JSONObject database;
        JSONObject placeFound;

        rv = (RecyclerView) v.findViewById(R.id.recicler);
        int resIdAnim = R.anim.layout_anim_fall_down;
        Map<String, String> hourSelected = (Map<String, String>) getArguments().getSerializable("arg");
        final String from = hourSelected.get(getResources().getString(R.string.from));
        final String to = hourSelected.get(getResources().getString(R.string.to));
        final String day = getArguments().getString(getResources().getString(R.string.type));
        final String route = hourSelected.get(getResources().getString(R.string.route));
        String arrayToSearch = HorarioModel.getNamesKey(from, to, route, day, getContext());
        String fromSearch = HorarioModel.getTableName(from, route, getContext());
        String toSearch = HorarioModel.getTableName(to, route, getContext());
        int numberDay = -1;
        if (day == getResources().getString(R.string.saturday)) {
            numberDay = 7;
        } else if (day == getResources().getString(R.string.sunday)) {
            numberDay = 1;
        }


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        sharedPreferences.getAll();

        try {

            database = CommonObject.INSTANCE.getDatabase() == null ? new JSONObject(sharedPreferences.getString("database", "{}")) : new JSONObject(CommonObject.INSTANCE.getDatabase());
            placeFound = database.getJSONObject(arrayToSearch);
            originArray = HorarioModel.getFromJsonArray(placeFound.getJSONArray(fromSearch));
            destinyArray = HorarioModel.getFromJsonArray(placeFound.getJSONArray(toSearch));
            additional = HorarioModel.getFromJsonArray(placeFound.getJSONArray("additional"));
        } catch (JSONException e) {
            Log.e(getClass().getSimpleName(), e.getMessage());
        }
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), resIdAnim);
        rv.setLayoutAnimation(animation);
        HorarioAdapter adapter;
        try {
            adapter = new HorarioAdapter(HorarioModel.getHour(originArray, destinyArray, numberDay, additional), getContext());
            rv.setAdapter(adapter);
        } catch (ParseException e) {
            Log.e("ParseException", e.getMessage());
        }

        return v;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            runLayoutAnimation();
        }
    }

    public void runLayoutAnimation() {
        final Context context = rv.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_anim_fall_down);

        rv.setLayoutAnimation(controller);
        rv.getAdapter().notifyDataSetChanged();
        rv.scheduleLayoutAnimation();
    }


}