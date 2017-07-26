package com.sistemas51.horarioslavalle;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.Forecast;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.ForecastAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_California_semana extends Fragment {


    public Fragment_California_semana() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        RecyclerView forecastsRecyclerView;
        forecastsRecyclerView = (RecyclerView) v.findViewById(R.id.recicler);
        final int origennum= getActivity().getIntent().getExtras().getInt("origennum");
        final int llegadanum= getActivity().getIntent().getExtras().getInt("llegadanum");
        String[] arraydestino = new String[0];
        String[] arrayllegada= new String[0];
        Resources res = getResources();
        if (origennum<llegadanum) {
            if(origennum==0){arraydestino = res.getStringArray(R.array.ida_semana_california_william);}
            if(origennum==1){arraydestino = res.getStringArray(R.array.ida_semana_california_3portena);}
            if(origennum==2){arraydestino = res.getStringArray(R.array.ida_semana_california_central);}
            if(origennum==3){arraydestino = res.getStringArray(R.array.ida_semana_california_california);}
            if(origennum==4){arraydestino = res.getStringArray(R.array.ida_semana_california_costa);}


            if(llegadanum==0){arrayllegada = res.getStringArray(R.array.ida_semana_california_william);}
            if(llegadanum==1){arrayllegada = res.getStringArray(R.array.ida_semana_california_3portena);}
            if(llegadanum==2){arrayllegada = res.getStringArray(R.array.ida_semana_california_central);}
            if(llegadanum==3){arrayllegada = res.getStringArray(R.array.ida_semana_california_california);}
            if(llegadanum==4){arrayllegada = res.getStringArray(R.array.ida_semana_california_costa);}

        }
        if(origennum>llegadanum){

            if(origennum==0){arraydestino = res.getStringArray(R.array.vuelta_semana_california_william);}
            if(origennum==1){arraydestino = res.getStringArray(R.array.vuelta_semana_california_3portena);}
            if(origennum==2){arraydestino = res.getStringArray(R.array.vuelta_semana_california_central);}
            if(origennum==3){arraydestino = res.getStringArray(R.array.vuelta_semana_california_california);}
            if(origennum==4){arraydestino = res.getStringArray(R.array.vuelta_semana_california_costa);}


            if(llegadanum==0){arrayllegada = res.getStringArray(R.array.vuelta_semana_california_william);}
            if(llegadanum==1){arrayllegada = res.getStringArray(R.array.vuelta_semana_california_3portena);}
            if(llegadanum==2){arrayllegada = res.getStringArray(R.array.vuelta_semana_california_central);}
            if(llegadanum==3){arrayllegada = res.getStringArray(R.array.vuelta_semana_california_california);}
            if(llegadanum==4){arrayllegada = res.getStringArray(R.array.vuelta_semana_california_costa);}

        }
        forecastsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ForecastAdapter forecastadaptersemanacali;

        forecastadaptersemanacali = new ForecastAdapter(Forecast.get40(arraydestino,arrayllegada), getContext());

        forecastsRecyclerView.setAdapter(forecastadaptersemanacali);

return v;

    }
}

