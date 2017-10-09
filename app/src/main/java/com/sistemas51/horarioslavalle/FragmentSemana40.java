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
public class FragmentSemana40 extends Fragment {


    public FragmentSemana40() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        RecyclerView forecastsRecyclerView;
        forecastsRecyclerView = (RecyclerView) v.findViewById(R.id.recicler);
         int origennum= getActivity().getIntent().getExtras().getInt("origennum");
         int llegadanum= getActivity().getIntent().getExtras().getInt("llegadanum");
        String[] arraydestino = new String[0];
        String[] arrayllegada= new String[0];
        Resources res = getResources();
       if (origennum<llegadanum) {

           if (origennum == 0) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_km56);
           }
           if (origennum == 1) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_km47esc);
           }
           if (origennum == 2) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_jocolikm43);
           }
           if (origennum == 3) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_oscarmendoza);
           }
           if (origennum == 4) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_andacollo);
           }
           if (origennum == 5) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_croco);
           }
           if (origennum == 6) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_sguazini);
           }
           if (origennum == 7) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_3demayo);
           }
           if (origennum == 8) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_sanfrancisco);
           }
           if (origennum == 9) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_citalia);
           }
           if (origennum == 10) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_blacolm);
           }
           if (origennum == 11) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_salvatierra);
           }
           if (origennum == 12){
               arraydestino= res.getStringArray(R.array.ida_semana_40_paramillo);
           }
           if (origennum == 13) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_lavalle);
           }
           if (origennum == 14) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_verjel);
           }
           if (origennum == 15) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_cruce);
           }
           if (origennum == 16) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_pastal);
           }
           if (origennum == 17) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_borbollon);
           }
           if (origennum == 18) {
               arraydestino = res.getStringArray(R.array.ida_semana_40_mendoza);
           }






           if (llegadanum == 0) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_km56);
           }
           if (llegadanum == 1) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_km47esc);
           }
           if (llegadanum == 2) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_jocolikm43);
           }
           if (llegadanum == 3) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_oscarmendoza);
           }
           if (llegadanum == 4) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_andacollo);
           }
           if (llegadanum == 5) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_croco);
           }
           if (llegadanum == 6) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_sguazini);
           }
           if (llegadanum == 7) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_3demayo);
           }
           if (llegadanum == 8) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_sanfrancisco);
           }
           if (llegadanum == 9) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_citalia);
           }
           if (llegadanum == 10) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_blacolm);
           }
           if (llegadanum == 11) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_salvatierra);
           }
           if (llegadanum == 12){
               arrayllegada= res.getStringArray(R.array.ida_semana_40_paramillo);
           }
           if (llegadanum == 13) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_lavalle);
           }
           if (llegadanum == 14) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_verjel);
           }
           if (llegadanum == 15) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_cruce);
           }
           if (llegadanum == 16) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_pastal);
           }
           if (llegadanum == 17) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_borbollon);
           }
           if (llegadanum == 18) {
               arrayllegada = res.getStringArray(R.array.ida_semana_40_mendoza);
           }


       }
if(origennum>llegadanum){


    if (origennum == 0) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_km56);
    }
    if (origennum == 1) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_km47esc);
    }
    if (origennum == 2) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_jocolikm43);
    }
    if (origennum == 3) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_oscarmendoza);
    }
    if (origennum == 4) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_andacollo);
    }
    if (origennum == 5) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_croco);
    }
    if (origennum == 6) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_sguazini);
    }
    if (origennum == 7) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_3demayo);
    }
    if (origennum == 8) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_sanfrancisco);
    }
    if (origennum == 9) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_citalia);
    }
    if (origennum == 10) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_blacolm);
    }
    if (origennum == 11) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_salvatierra);
    }
    if (origennum == 12){
        arraydestino= res.getStringArray(R.array.vuelta_semana_40_paramillo);
    }
    if (origennum == 13) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_lavalle);
    }
    if (origennum == 14) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_verjel);
    }
    if (origennum == 15) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_cruce);
    }
    if (origennum == 16) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_pastal);
    }
    if (origennum == 17) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_borbollon);
    }
    if (origennum == 18) {
        arraydestino = res.getStringArray(R.array.vuelta_semana_40_mendoza);
    }






    if (llegadanum == 0) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_km56);
    }
    if (llegadanum == 1) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_km47esc);
    }
    if (llegadanum == 2) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_jocolikm43);
    }
    if (llegadanum == 3) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_oscarmendoza);
    }
    if (llegadanum == 4) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_andacollo);
    }
    if (llegadanum == 5) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_croco);
    }
    if (llegadanum == 6) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_sguazini);
    }
    if (llegadanum == 7) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_3demayo);
    }
    if (llegadanum == 8) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_sanfrancisco);
    }
    if (llegadanum == 9) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_citalia);
    }
    if (llegadanum == 10) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_blacolm);
    }
    if (llegadanum == 11) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_salvatierra);
    }
    if (llegadanum == 12){
        arrayllegada= res.getStringArray(R.array.vuelta_semana_40_paramillo);
    }
    if (llegadanum == 13) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_lavalle);
    }
    if (llegadanum == 14) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_verjel);
    }
    if (llegadanum == 15) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_cruce);
    }
    if (llegadanum == 16) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_pastal);
    }
    if (llegadanum == 17) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_borbollon);
    }
    if (llegadanum == 18) {
        arrayllegada = res.getStringArray(R.array.vuelta_semana_40_mendoza);
    }



}

        forecastsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ForecastAdapter forecastadaptersemana40;

            forecastadaptersemana40 = new ForecastAdapter(Forecast.get40(arraydestino,arrayllegada), getContext());

        forecastsRecyclerView.setAdapter(forecastadaptersemana40);


        return v;
    }

}
