package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.models.WeatherModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by axelfernandez on 26/6/17.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ForecastViewHolder> {

    private List<WeatherModel> weatherModels;
    private Context context;
    public WeatherAdapter(List<WeatherModel> weatherModels, Context context) {
        this.weatherModels = weatherModels;
        this.context = context;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForecastViewHolder(LayoutInflater.from(context).inflate(R.layout.weather_view, parent, false));
    }

    //Devolvemos la cantidad de items de nuestra lista
    @Override
    public int getItemCount() {
        return weatherModels.size();
    }

    //Metodo que se ejecuta para unir un objeto de la lista de items con el ViewHolder
    @Override
    public void onBindViewHolder(final ForecastViewHolder holder, int position) {
        final WeatherModel weatherModel = weatherModels.get(position);

        if (weatherModel.getImage() != null){
            Picasso.get().load("http://openweathermap.org/img/w/" + weatherModel.getImage() +".png").into(holder.image);
        }
        holder.descriptionView.setText(weatherModel.getDescription());
        holder.locationView.setText(weatherModel.getPlace());
        holder.temperatureView.setText(weatherModel.getCurrent());
        if (weatherModel.getCurrent() != null){
            holder.current_text.setVisibility(View.VISIBLE);
        }
    }



    //Clase que representa a nuestro elemento(vista) en el RecyclerView
    static class ForecastViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView locationView;
        TextView descriptionView;
        TextView temperatureView;
        TextView current_text;

        public ForecastViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageTemperature);
            locationView = (TextView) itemView.findViewById(R.id.place);
            descriptionView = (TextView) itemView.findViewById(R.id.description);
            temperatureView = (TextView) itemView.findViewById(R.id.currentTemperature);
            current_text = (TextView) itemView.findViewById(R.id.text_current);

        }
    }
}
