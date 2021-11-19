package com.sistemas51.horarioslavalle.api;

import android.content.Context;
import android.os.Build;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    Context context;
    Retrofit retrofit;
    private static ApiClient instance = null;

    public ApiClient(Context context) {
        this.context = context;
        String url = null;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // versiones con android 5.0 o superior
            url = "http://horarioslavalle.com.ar/";
        } else {
            // para versiones anteriores a android 5.0
            url = "http://horarioslavalle.com.ar/";
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static ApiClient getInstance(Context context) {
        if (instance == null) {
            instance = new ApiClient(context);
        }
        return instance;
    }


    public Call<String> version() {
        HourService service = retrofit.create(HourService.class);
        return service.version();
    }

    public Call<String> download() {
        HourService service = retrofit.create(HourService.class);
        return service.download();
    }
}