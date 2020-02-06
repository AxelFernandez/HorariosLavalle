package com.sistemas51.horarioslavalle.api;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @deprecated
 * Class deprecated for android 4.4, use only when Api Level < 16
 * We upload the min Android in December 2020
 */
public class ApiClientOld {
    Context context;
    Retrofit retrofit;
    private static ApiClientOld instance = null;

    public ApiClientOld(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl("http://telteka.com.ar/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static ApiClientOld getInstance(Context context) {
        if (instance == null) {
            instance = new ApiClientOld(context);
        }
        return instance;
    }

    /**
     * @deprecated from december 2020
      * @return
     */
    public Call<String> version() {
        HourService service = retrofit.create(HourService.class);
        return service.versionOld();
    }
    /**
     * @deprecated  from December 2020
     * @return
     */
    public Call<String> download() {
        HourService service = retrofit.create(HourService.class);
        return service.downloadOld();
    }
}