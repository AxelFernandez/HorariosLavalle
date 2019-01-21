package com.sistemas51.horarioslavalle.Ruta24;


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
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.Horario;
import com.sistemas51.horarioslavalle.R;

import java.text.ParseException;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_semana24 extends Fragment {


    public Fragment_semana24() {
        // Required empty public constructor
    }

    RecyclerView forecastsRecyclerView;
    String[] arraysemana;
    String[] arraysemanallegada;
    Horario horario = new Horario();
    int horas;
    int minutos; //Usados solamente para sumar mas adelante

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        //Recuperacion del activty anterior
        final String origen = getActivity().getIntent().getExtras().getString("origen");
        final String llegada = getActivity().getIntent().getExtras().getString("llegada");
        final int origennum = getActivity().getIntent().getExtras().getInt("origennum");
        final int llegadanum = getActivity().getIntent().getExtras().getInt("llegadanum");
        Resources res = getResources();

        //Condicion del array a cargaren pantalla, Si esta lleno de if, si se te ocurre algo diferente.
        //adelante.
        if (origennum < llegadanum) {

            if (origennum == 0) {
                arraysemana = res.getStringArray(R.array.ida_Asuncion);
            }
            if (origennum == 1) {
                arraysemana = res.getStringArray(R.array.ida_el15);
            }
            if (origennum == 2) {
                arraysemana = res.getStringArray(R.array.ida_gustavoAndre);
            }
            if (origennum == 3) {
                arraysemana = res.getStringArray(R.array.ida_costa);
            }
            if (origennum == 4) {
                arraysemana = res.getStringArray(R.array.ida_lavalle);
            }
            if (origennum == 5) {
                arraysemana = res.getStringArray(R.array.ida_mendoza);

            }
            
            if (llegadanum == 0) {
                arraysemanallegada = res.getStringArray(R.array.ida_Asuncion);
            }
            if (llegadanum == 1) {
                arraysemanallegada = res.getStringArray(R.array.ida_el15);
            }
            if (llegadanum == 2) {
                arraysemanallegada = res.getStringArray(R.array.ida_gustavoAndre);
            }
            if (llegadanum == 3) {
                arraysemanallegada = res.getStringArray(R.array.ida_costa);
            }
            if (llegadanum == 4) {
                arraysemanallegada = res.getStringArray(R.array.ida_lavalle);
            }
            if (llegadanum == 5) {
                arraysemanallegada = res.getStringArray(R.array.ida_mendoza);

            }
        
        }

        if (origennum > llegadanum) {

            if (llegadanum == 0) {
                arraysemanallegada = res.getStringArray(R.array.vuelta_asuncion);
            }
            if (llegadanum == 1) {
                arraysemanallegada = res.getStringArray(R.array.vuelta_el15);
            }
            if (llegadanum == 2) {
                arraysemanallegada = res.getStringArray(R.array.vuelta_gvoAndre);
                
            }
            if (llegadanum == 3) {
                arraysemanallegada = res.getStringArray(R.array.vuelta_costa);
                
            }
            if (llegadanum == 4) {
                arraysemanallegada = res.getStringArray(R.array.vuelta_lavalle);
                
            }
            if (llegadanum == 5) {
                arraysemanallegada = res.getStringArray(R.array.vuelta_mendoza);
                

            }

            if (origennum == 0) {
                arraysemana = res.getStringArray(R.array.vuelta_asuncion);
            }
            if (origennum == 1) {
                arraysemana = res.getStringArray(R.array.vuelta_el15);
            }
            if (origennum == 2) {
                arraysemana = res.getStringArray(R.array.vuelta_gvoAndre);
            }
            if (origennum == 3) {
                arraysemana = res.getStringArray(R.array.vuelta_costa);
            }
            if (origennum == 4) {
                arraysemana = res.getStringArray(R.array.vuelta_lavalle);
            }
            if (origennum == 5) {
                arraysemana = res.getStringArray(R.array.vuelta_mendoza);

            }
        }




        forecastsRecyclerView = (RecyclerView) v.findViewById(R.id.recicler);
        forecastsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ForecastAdapter forecastadaptersemana40;

        forecastadaptersemana40 = new ForecastAdapter(Forecast.get40(arraysemana,arraysemanallegada), getContext());

        forecastsRecyclerView.setAdapter(forecastadaptersemana40);

        return v;
    }
}
