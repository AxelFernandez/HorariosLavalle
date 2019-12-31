package com.sistemas51.horarioslavalle.api;

import com.kwabenaberko.openweathermaplib.constants.Lang;
import com.kwabenaberko.openweathermaplib.constants.Units;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;

public class WeatherSingleton {
    private static OpenWeatherMapHelper helper;

    private WeatherSingleton(){}

    public static OpenWeatherMapHelper getInstance(){
        if (helper == null){
            helper = new OpenWeatherMapHelper("76e3910c785992079e6e363b27f8fd7c");
            helper.setLang(Lang.SPANISH);
            helper.setUnits(Units.METRIC);
        }
        return helper;
    }

}
