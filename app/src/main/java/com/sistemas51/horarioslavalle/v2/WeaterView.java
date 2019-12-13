package com.sistemas51.horarioslavalle.v2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arthurivanets.bottomsheets.BaseBottomSheet;
import com.arthurivanets.bottomsheets.config.BaseConfig;
import com.arthurivanets.bottomsheets.config.Config;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.implementation.callbacks.CurrentWeatherCallback;
import com.kwabenaberko.openweathermaplib.models.currentweather.CurrentWeather;
import com.sistemas51.horarioslavalle.R;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.ResourceUtils;
import com.sistemas51.horarioslavalle.UtilidadesAdaptadores.WeatherAdapter;
import com.sistemas51.horarioslavalle.api.WeatherSingleton;
import com.sistemas51.horarioslavalle.models.WeatherModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

public class WeaterView extends BottomSheetDialogFragment {



    List<String> arguments;
    WeatherModel fromModel;
    WeatherModel toModel;


    static WeaterView newInstance() {
        return new WeaterView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v  = inflater.inflate(R.layout.fragment_listview, container, false);
        RecyclerView rv = v.findViewById(R.id.recicler);
        int resIdAnim = R.anim.layout_anim_fall_down;
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(),resIdAnim);
        rv.setLayoutAnimation(animation);

        OpenWeatherMapHelper openWeather = WeatherSingleton.getInstance();
        String from = "Lavalle";
        String to = "Mendoza";
        Map<String,String> locations = ResourceUtils.getHashMapResource(getContext(),R.xml.locations);
        String[] arrayFrom = locations.get("location"+from.replace(" ","")).split(",");
        String[] arrayto= locations.get("location"+to.replace(" ","")).split(",");
        fromModel =new WeatherModel();
        toModel =new WeatherModel();

        openWeather.getCurrentWeatherByGeoCoordinates(Double.valueOf(arrayFrom[0]), Double.valueOf(arrayFrom[1]), new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {
                fromModel.setPlace(from);
                fromModel.setCurrent(String.valueOf(currentWeather.getMain().getTemp()));
                fromModel.setDescription(currentWeather.getWeather().get(0).getDescription());
                fromModel.setImage(currentWeather.getWeather().get(0).getIcon());
                fromModel.setMaximun(String.valueOf(currentWeather.getMain().getTempMax()));
                fromModel.setMinimum(String.valueOf(currentWeather.getMain().getTempMin()));
                
            }
            @Override
            public void onFailure(Throwable throwable) {
                Log.e("OpenWather",throwable.getMessage());
                fromModel.setPlace(from);
                fromModel.setCurrent("");
                fromModel.setDescription("Necesitas Conexion a Internet");
                fromModel.setImage(null);
                fromModel.setMaximun("");
                fromModel.setMinimum("");

            }
        });


        openWeather.getCurrentWeatherByGeoCoordinates(Double.valueOf(arrayto[0]), Double.valueOf(arrayto[1]), new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {
                toModel.setPlace(to);
                toModel.setCurrent(String.valueOf(currentWeather.getMain().getTemp()));
                toModel.setDescription(currentWeather.getWeather().get(0).getDescription());
                toModel.setImage(currentWeather.getWeather().get(0).getIcon());
                toModel.setMaximun(String.valueOf(currentWeather.getMain().getTempMax()));
                toModel.setMinimum(String.valueOf(currentWeather.getMain().getTempMin()));

            }
            @Override
            public void onFailure(Throwable throwable) {
                Log.e("OpenWather",throwable.getMessage());
                toModel.setPlace(to);
                toModel.setCurrent("");
                toModel.setDescription("Necesitas Conexion a Internet");
                toModel.setImage(null);
                toModel.setMaximun("");
                toModel.setMinimum("");

            }
        });

        List<WeatherModel> weatherModels = new ArrayList<>();
        weatherModels.add(fromModel);
        weatherModels.add(toModel);
        WeatherAdapter adapter = new WeatherAdapter(weatherModels,getContext());
        rv.setAdapter(adapter);



        return v;
    }
}
