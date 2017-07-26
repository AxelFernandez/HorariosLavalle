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


        int idaovuelta = 0;//ida es 0, vuelta es 1
        if (origennum<llegadanum) {
            idaovuelta=0;

            if (origennum == 0) {

                arraydomingo = res.getStringArray(R.array.domingo_ida_asuncion);

                horas= horario.getidahoras(origennum,llegadanum);
                minutos= horario.getidaminutos(origennum,llegadanum);
            }
            if (origennum == 1) {

                arraydomingo = res.getStringArray(R.array.domingo_ida_el15);
                horas= horario.getidahoras(origennum,llegadanum);
                minutos= horario.getidaminutos(origennum,llegadanum);

            }
            if (origennum == 2) {

                arraydomingo = res.getStringArray(R.array.domingo_ida_gustavoAndre);
                horas= horario.getidahoras(origennum,llegadanum);
                minutos= horario.getidaminutos(origennum,llegadanum);

            }
            if (origennum == 3) {

                arraydomingo = res.getStringArray(R.array.domingo_ida_costa);
                horas= horario.getidahoras(origennum,llegadanum);
                minutos= horario.getidaminutos(origennum,llegadanum);

            }
            if (origennum == 4) {

                arraydomingo = res.getStringArray(R.array.domingo_ida_lavalle);
                horas= horario.getidahoras(origennum,llegadanum);
                minutos= horario.getidaminutos(origennum,llegadanum);

            }
            if (origennum == 5) {

                arraydomingo = res.getStringArray(R.array.domingo_ida_mendoza);
                horas= horario.getidahoras(origennum,llegadanum);
                minutos= horario.getidaminutos(origennum,llegadanum);

            }
        }

        if (origennum>llegadanum) {

            idaovuelta=1;
            if (llegadanum == 0) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_asuncion);
                horas= horario.getvueltahoras(origennum,llegadanum);
                minutos= horario.getvueltaminutos(origennum,llegadanum);
            }
            if (llegadanum == 1) {

                arraydomingo = res.getStringArray(R.array.sabado_vuelta_el15);
                horas= horario.getvueltahoras(origennum,llegadanum);
                minutos= horario.getvueltaminutos(origennum,llegadanum);
            }
            if (llegadanum == 2) {
                arraydomingo = res.getStringArray(R.array.domingo_vuelta_gustavoAndre);
                horas= horario.getvueltahoras(origennum,llegadanum);
                minutos= horario.getvueltaminutos(origennum,llegadanum);
            }
            if (llegadanum == 3) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_costa);
                horas= horario.getvueltahoras(origennum,llegadanum);
                minutos= horario.getvueltaminutos(origennum,llegadanum);
            }
            if (llegadanum == 4) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_lavalle);
                horas= horario.getvueltahoras(origennum,llegadanum);
                minutos= horario.getvueltaminutos(origennum,llegadanum);
            }
            if (llegadanum == 5) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_mendoza);
                horas= horario.getvueltahoras(origennum,llegadanum);
                minutos= horario.getvueltaminutos(origennum,llegadanum);

            }
        }

        if(llegadanum==origennum){
            horas=0;minutos=0;
            idaovuelta=3;
            if (llegadanum == 0) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_asuncion);

            }
            if (llegadanum == 1) {

                arraydomingo = res.getStringArray(R.array.sabado_vuelta_el15);

            }
            if (llegadanum == 2) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_gustavoAndre);

            }
            if (llegadanum == 3) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_costa);

            }
            if (llegadanum == 4) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_lavalle);

            }
            if (llegadanum == 5) {

                arraydomingo = res.getStringArray(R.array.domingo_vuelta_mendoza);


            }
        }
        forecastsRecyclerView = (RecyclerView) v.findViewById(R.id.recicler);
        forecastsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        //Solo IDA
        if (idaovuelta==0) {

            ForecastAdapter forecastAdapterdomingo = null;
            try {
                forecastAdapterdomingo = new ForecastAdapter(Forecast.getidaList(horas, minutos, arraydomingo, llegadanum), getContext());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            forecastsRecyclerView.setAdapter(forecastAdapterdomingo);
        }
        if (idaovuelta==3) {

            ForecastAdapter forecastAdapterdomingo = null;
            forecastAdapterdomingo = new ForecastAdapter(Forecast.getigual(arraydomingo), getContext());
            forecastsRecyclerView.setAdapter(forecastAdapterdomingo);
        }
        //SOLO VUELTA
        if(idaovuelta==1) {


            ForecastAdapter forecastAdapterdomingo = null;
            try {
                forecastAdapterdomingo = new ForecastAdapter(Forecast.getvueltalist(horas, minutos, arraydomingo, origennum), getContext());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            forecastsRecyclerView.setAdapter(forecastAdapterdomingo);
        }
            return v;
    }

}
