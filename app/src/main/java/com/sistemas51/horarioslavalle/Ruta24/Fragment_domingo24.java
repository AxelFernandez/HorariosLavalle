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
public class Fragment_domingo24 extends Fragment {


    public Fragment_domingo24() {
        // Required empty public constructor
    }
    RecyclerView forecastsRecyclerView;
    String[] arraydomingo;
    String[] arraydomingollegada;
    Horario horario = new Horario();
    int horas; int minutos; //Usados solamente para sumar mas adelante

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_listview, container, false);

        final String origen = getActivity().getIntent().getExtras().getString("origen");
        final String llegada = getActivity().getIntent().getExtras().getString("llegada");
        final int origennum= getActivity().getIntent().getExtras().getInt("origennum");
        final int llegadanum= getActivity().getIntent().getExtras().getInt("llegadanum");
        Resources res = getResources();


        if (origennum < llegadanum) {

            if (origennum == 0) {
                arraydomingo = res.getStringArray(R.array.domingo_ida_asuncion);
            }
            if (origennum == 1) {
                arraydomingo = res.getStringArray(R.array.domingo_ida_el15);
            }
            if (origennum == 2) {
                arraydomingo = res.getStringArray(R.array.domingo_ida_gustavoAndre);
            }
            if (origennum == 3) {
                arraydomingo = res.getStringArray(R.array.domingo_ida_costa);
            }
            if (origennum == 4) {
                arraydomingo = res.getStringArray(R.array.domingo_ida_lavalle);
            }
            if (origennum == 5) {
                arraydomingo = res.getStringArray(R.array.domingo_ida_mendoza);

            }

            if (llegadanum == 0) {
                arraydomingollegada = res.getStringArray(R.array.domingo_ida_asuncion);
            }
            if (llegadanum == 1) {
                arraydomingollegada = res.getStringArray(R.array.domingo_ida_el15);
            }
            if (llegadanum == 2) {
                arraydomingollegada = res.getStringArray(R.array.domingo_ida_gustavoAndre);
            }
            if (llegadanum == 3) {
                arraydomingollegada = res.getStringArray(R.array.domingo_ida_costa);
            }
            if (llegadanum == 4) {
                arraydomingollegada = res.getStringArray(R.array.domingo_ida_lavalle);
            }
            if (llegadanum == 5) {
                arraydomingollegada = res.getStringArray(R.array.domingo_ida_mendoza);

            }

        }

        if (origennum > llegadanum) {

            if (llegadanum == 0) {
                arraydomingollegada = res.getStringArray(R.array.domingo_vuelta_asuncion);
            }
            if (llegadanum == 1) {
                arraydomingollegada = res.getStringArray(R.array.domingo_vuelta_el15);
            }
            if (llegadanum == 2) {
                arraydomingollegada = res.getStringArray(R.array.domingo_vuelta_gustavoAndre);

            }
            if (llegadanum == 3) {
                arraydomingollegada = res.getStringArray(R.array.domingo_vuelta_costa);

            }
            if (llegadanum == 4) {
                arraydomingollegada = res.getStringArray(R.array.domingo_vuelta_lavalle);

            }
            if (llegadanum == 5) {
                arraydomingollegada = res.getStringArray(R.array.domingo_vuelta_mendoza);


            }

            if (origennum == 0) {
                arraydomingo = res.getStringArray(R.array.domingo_vuelta_asuncion);
            }
            if (origennum == 1) {
                arraydomingo = res.getStringArray(R.array.domingo_vuelta_el15);
            }
            if (origennum == 2) {
                arraydomingo = res.getStringArray(R.array.domingo_vuelta_gustavoAndre);
            }
            if (origennum == 3) {
                arraydomingo = res.getStringArray(R.array.domingo_vuelta_costa);
            }
            if (origennum == 4) {
                arraydomingo = res.getStringArray(R.array.domingo_vuelta_lavalle);
            }
            if (origennum == 5) {
                arraydomingo = res.getStringArray(R.array.domingo_vuelta_mendoza);

            }
        }




        forecastsRecyclerView = (RecyclerView) v.findViewById(R.id.recicler);
        forecastsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ForecastAdapter forecastadaptersemana40;

        forecastadaptersemana40 = new ForecastAdapter(Forecast.get40(arraydomingo,arraydomingollegada), getContext());

        forecastsRecyclerView.setAdapter(forecastadaptersemana40);
            return v;
    }

}
