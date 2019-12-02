package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.sistemas51.horarioslavalle.R;

import java.util.Date;
import java.util.List;

/**
 * Created by axelfernandez on 26/6/17.
 */

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.ForecastViewHolder> {



    private final int NORMAL_VIEW = 0;
    private final int YOU_ARE_HERE = 1;
    private List<HorarioModel> horarioModels;
    private Context context;
    private boolean isfirst = false;
    public HorarioAdapter(List<HorarioModel> horarioModels, Context context) {
        this.horarioModels = horarioModels;
        this.context = context;
    }

    //Metodo que se ejecuta cada vez que tiene que crear el ViewHolder, debemos crear el ViewHolder y devolverlo
    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case NORMAL_VIEW:
                return new ForecastViewHolder(LayoutInflater.from(context).inflate(R.layout.forecast_list_item, parent, false));
            case YOU_ARE_HERE:
                return new ForecastViewHolder(LayoutInflater.from(context).inflate(R.layout.itemyouarehere, parent, false));

            default:
                return new ForecastViewHolder(LayoutInflater.from(context).inflate(R.layout.forecast_list_item, parent, false));
        }
    }

    //Devolvemos la cantidad de items de nuestra lista
    @Override
    public int getItemCount() {
        return horarioModels.size();
    }

    //Metodo que se ejecuta para unir un objeto de la lista de items con el ViewHolder
    @Override
    public void onBindViewHolder(final ForecastViewHolder holder, int position) {


                final HorarioModel horarioModel = horarioModels.get(position);
                holder.locationView.setText(horarioModel.getFrom());
                holder.descriptionView.setText(horarioModel.getTo());
                holder.container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String locationsins = horarioModel.getFrom();
                        String horahorario = locationsins.substring(9, 14);
                        Date horahorariodate = new Date();
                        Date horaactualdate = new Date();
                        Date horariofinal = new Date();
                    }
                });


    }

    @Override
    public int getItemViewType(int position) {
        int result = NORMAL_VIEW;
        if (horarioModels.get(position).isNext()){
            result = YOU_ARE_HERE;
        }
        return result;
    }

       //Clase que representa a nuestro elemento(vista) en el RecyclerView
    static class ForecastViewHolder extends RecyclerView.ViewHolder {

        View container;
        TextView locationView;
        TextView descriptionView;
        TextView temperatureView;

        public ForecastViewHolder(View itemView) {
            super(itemView);

            //Instanciamos las vistas
            container = itemView.findViewById(R.id.forecast_container);
            locationView = (TextView) itemView.findViewById(R.id.forecast_location);
            descriptionView = (TextView) itemView.findViewById(R.id.forecast_description);
            temperatureView = (TextView) itemView.findViewById(R.id.forecast_temperature);
        }
    }
}
