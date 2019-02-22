package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas51.horarioslavalle.R;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by axelfernandez on 26/6/17.
 */

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.ForecastViewHolder> {



    private final int TODAY = 0;
    private final int OTHER_DAY = 1;
    private List<HorarioModel> horarioModels;
    private Context context;

    public HorarioAdapter(List<HorarioModel> horarioModels, Context context) {
        this.horarioModels = horarioModels;
        this.context = context;
    }

    //Metodo que se ejecuta cada vez que tiene que crear el ViewHolder, debemos crear el ViewHolder y devolverlo
    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Dependiendo del viewType, instanciamos distintas vistas
        switch (viewType) {

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

        //Obtenemos el item de la lista con la posicion
        final HorarioModel horarioModel = horarioModels.get(position);

        //Bindeamos los datos del objeto con la vista

        holder.locationView.setText(horarioModel.getLocation());
        holder.descriptionView.setText(horarioModel.getDescription());


        //Cuando se hace click en el item, se muestra un toast
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locationsins= horarioModel.getLocation();
               String horahorario= locationsins.substring(9,14);
              Date horahorariodate= new Date();
                Date horaactualdate= new Date();
                Date horariofinal= new Date();

            }
        });


    }

    @Override
    public int getItemViewType(int position) {
        //Si es la primer posicion, corresponde al pronostico de hoy
        if (position == 0) {
            return TODAY;
        } else {
            return OTHER_DAY;
        }
    }

    private void removeItem(int position) {
        //Removemos el item de la lista de horarioModels
        horarioModels.remove(position);

        //Debemos notificar al adapter que un item fue removido.
        notifyItemRemoved(position);
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
