package com.sistemas51.horarioslavalle.v2;


import android.content.res.Resources;
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

public class ResultFragment extends Fragment {


    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        RecyclerView rv;
        rv = (RecyclerView) v.findViewById(R.id.recicler);
        final int origennum = getActivity().getIntent().getExtras().getInt("origennum");
        final int llegadanum = getActivity().getIntent().getExtras().getInt("llegadanum");
        String day = getArguments().getString("type");
        boolean isIda = true;
        final String ruta = getActivity().getIntent().getExtras().getString(getString(R.string.Ruta));
        Resources res = getResources();
        if (origennum<llegadanum) {
            isIda=true;
        }else if (origennum>llegadanum){
            isIda=false;
        }

        Utils utils = new Utils(res);
        String[] arrayPartida = utils.getArrayPartida(ruta,origennum,day,isIda);
        String[] arrayDestino = utils.getArrayPartida(ruta,llegadanum,day,isIda);

        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        HorarioAdapter forecastadaptersemana40;

        forecastadaptersemana40 = new HorarioAdapter(HorarioModel.get40(arrayPartida,arrayDestino), getContext());

        rv.setAdapter(forecastadaptersemana40);

        return v;
    }
}