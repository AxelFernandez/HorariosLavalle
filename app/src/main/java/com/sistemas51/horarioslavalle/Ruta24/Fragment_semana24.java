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
        int idaovuelta = 0;//ida es 0, vuelta es 1
        if (origennum < llegadanum) {
            idaovuelta = 0;

            if (origennum == 0) {
                arraysemana = res.getStringArray(R.array.ida_Asuncion);

                horas = horario.getidahoras(origennum, llegadanum);
                minutos = horario.getidaminutos(origennum, llegadanum);
            }
            if (origennum == 1) {
                arraysemana = res.getStringArray(R.array.ida_el15);

                horas = horario.getidahoras(origennum, llegadanum);
                minutos = horario.getidaminutos(origennum, llegadanum);

            }
            if (origennum == 2) {
                arraysemana = res.getStringArray(R.array.ida_gustavoAndre);

                horas = horario.getidahoras(origennum, llegadanum);
                minutos = horario.getidaminutos(origennum, llegadanum);

            }
            if (origennum == 3) {
                arraysemana = res.getStringArray(R.array.ida_costa);

                horas = horario.getidahoras(origennum, llegadanum);
                minutos = horario.getidaminutos(origennum, llegadanum);

            }
            if (origennum == 4) {
                arraysemana = res.getStringArray(R.array.ida_lavalle);

                horas = horario.getidahoras(origennum, llegadanum);
                minutos = horario.getidaminutos(origennum, llegadanum);

            }
            if (origennum == 5) {
                arraysemana = res.getStringArray(R.array.ida_mendoza);

                horas = horario.getidahoras(origennum, llegadanum);
                minutos = horario.getidaminutos(origennum, llegadanum);

            }
        }

        if (origennum > llegadanum) {

            idaovuelta = 1;
            if (llegadanum == 0) {
                arraysemana = res.getStringArray(R.array.vuelta_asuncion);

                horas = horario.getvueltahoras(origennum, llegadanum);
                minutos = horario.getvueltaminutos(origennum, llegadanum);
            }
            if (llegadanum == 1) {
                arraysemana = res.getStringArray(R.array.vuelta_el15);

                horas = horario.getvueltahoras(origennum, llegadanum);
                minutos = horario.getvueltaminutos(origennum, llegadanum);
            }
            if (llegadanum == 2) {
                arraysemana = res.getStringArray(R.array.vuelta_gvoAndre);

                horas = horario.getvueltahoras(origennum, llegadanum);
                minutos = horario.getvueltaminutos(origennum, llegadanum);
            }
            if (llegadanum == 3) {
                arraysemana = res.getStringArray(R.array.vuelta_costa);

                horas = horario.getvueltahoras(origennum, llegadanum);
                minutos = horario.getvueltaminutos(origennum, llegadanum);
            }
            if (llegadanum == 4) {
                arraysemana = res.getStringArray(R.array.vuelta_lavalle);

                horas = horario.getvueltahoras(origennum, llegadanum);
                minutos = horario.getvueltaminutos(origennum, llegadanum);
            }
            if (llegadanum == 5) {
                arraysemana = res.getStringArray(R.array.vuelta_mendoza);

                horas = horario.getvueltahoras(origennum, llegadanum);
                minutos = horario.getvueltaminutos(origennum, llegadanum);

            }
        }

        if (llegadanum == origennum) {
            horas = 0;
            minutos = 0;
            idaovuelta = 3;
            if (llegadanum == 0) {
                arraysemana = res.getStringArray(R.array.vuelta_asuncion);


            }
            if (llegadanum == 1) {
                arraysemana = res.getStringArray(R.array.vuelta_el15);


            }
            if (llegadanum == 2) {
                arraysemana = res.getStringArray(R.array.vuelta_gvoAndre);

            }
            if (llegadanum == 3) {
                arraysemana = res.getStringArray(R.array.vuelta_costa);

            }
            if (llegadanum == 4) {
                arraysemana = res.getStringArray(R.array.vuelta_lavalle);

            }
            if (llegadanum == 5) {
                arraysemana = res.getStringArray(R.array.vuelta_mendoza);


            }
        }


        forecastsRecyclerView = (RecyclerView) v.findViewById(R.id.recicler);
        forecastsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        //Solo IDA
        ForecastAdapter forecastAdaptersemana = null;
        if (idaovuelta == 0) {
            forecastAdaptersemana = null;
            try {
                forecastAdaptersemana = new ForecastAdapter(Forecast.getidaList(horas, minutos, arraysemana, llegadanum), getContext());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            forecastsRecyclerView.setAdapter(forecastAdaptersemana);

        }

        if (idaovuelta==3) {
            forecastAdaptersemana = null;
            forecastAdaptersemana = new ForecastAdapter(Forecast.getigual(arraysemana), getContext());
            forecastsRecyclerView.setAdapter(forecastAdaptersemana);}


        if(idaovuelta==1){
            forecastAdaptersemana = null;
            try {
                forecastAdaptersemana = new ForecastAdapter(Forecast.getvueltalist(horas, minutos, arraysemana, origennum), getContext());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            forecastsRecyclerView.setAdapter(forecastAdaptersemana);}
        return v;
    }
}
