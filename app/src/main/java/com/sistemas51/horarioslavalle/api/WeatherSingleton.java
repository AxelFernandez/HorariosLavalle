package com.sistemas51.horarioslavalle.api;

import com.kwabenaberko.openweathermaplib.constants.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.network.OpenWeatherMapClient;

public class WeatherSingleton {
    private static OpenWeatherMapHelper helper;

    private WeatherSingleton(){}

    public static OpenWeatherMapHelper getInstance(){
        if (helper == null){
            helper = new OpenWeatherMapHelper("76e3910c785992079e6e363b27f8fd7c");
            helper.setUnits(Units.METRIC);
        }
        return helper;
    }

}
