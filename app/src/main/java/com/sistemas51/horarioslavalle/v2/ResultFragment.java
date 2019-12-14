package com.sistemas51.horarioslavalle.v2;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.HorarioAdapter;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.HorarioModel;

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
    private RecyclerView rv;
    private BottomSheetBehavior bottomSheetBehavior;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.bottomSheet);

        bottomSheetBehavior = BottomSheetBehavior.from(linearLayout);

        rv = (RecyclerView) v.findViewById(R.id.recicler);
        FloatingActionButton fab = v.findViewById(R.id.floating_action_button);
        int resIdAnim = R.anim.layout_anim_fall_down;
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

            database = new JSONObject(sharedPreferences.getString("database","{}"));
            placeFound = database.getJSONObject(arrayToSearch);
            originArray = HorarioModel.getFromJsonArray(placeFound.getJSONArray(fromSearch));
            destinyArray = HorarioModel.getFromJsonArray(placeFound.getJSONArray(toSearch));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(),resIdAnim);
        rv.setLayoutAnimation(animation);
        HorarioAdapter adapter;
        try {
            adapter = new HorarioAdapter(HorarioModel.getHour(originArray,destinyArray,numberDay), getContext());
            rv.setAdapter(adapter);
        } catch (ParseException e) {
            Log.e("ParseException",e.getMessage());
        }
        fab.show();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> arguments = new ArrayList<>();
                arguments.add(getArguments().getString("from"));
                arguments.add(getArguments().getString("to"));
                WeaterView bsdFragment = new WeaterView();
                bsdFragment.setArguments(getArguments());
                bsdFragment.show(getFragmentManager(), "BSDialog");

            }
        });

        return v;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
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