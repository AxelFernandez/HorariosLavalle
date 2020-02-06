package com.sistemas51.horarioslavalle.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.View;


import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;

public class ApiRequest {

    public void init(SharedPreferences sharedPreferences, Context context, View view){
        validateVersion(sharedPreferences,context,view,false);
    }

    public void forceDownload(SharedPreferences sharedPreferences, Context context, View view){
       validateVersion(sharedPreferences,context,view,true);

    }
    private void validateVersion(final SharedPreferences sharedPreferences, final Context context, final View view, boolean force){
        String result;
        ApiClient apiClient = ApiClient.getInstance(context);
        final Call<String> version = apiClient.version();
        version.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Integer version = sharedPreferences.getInt("version",0);
                Integer apiVersion = null;
                boolean special= false;
                try {
                    JSONObject json = new JSONObject(response.body());
                    apiVersion = json.getInt("version");
                    special = json.getBoolean("special");
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("special",special);
                    editor.apply();
                    Log.e("REQUESTING", response.body());
                    if (force || version<apiVersion){
                        Snackbar.make(view,"Descargando Actualizaciones...", Snackbar.LENGTH_LONG).show();
                        download(sharedPreferences,context,view);
                        editor.putInt("version",apiVersion);
                        editor.apply();
                    }else{
                        Snackbar.make(view,"Los Horarios están actualizados!", Snackbar.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    Log.d("Error trying cast Json", e.toString());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Snackbar.make(view,"No hay conexion para comprobar Actualizaciones", Snackbar.LENGTH_SHORT).show();
                Log.e("Error request ",String.valueOf(t.getMessage()));
            }

        });
    }

    private void download(final SharedPreferences sharedPreferences, Context context,final View view){
        ApiClient apiClient = ApiClient.getInstance(context);
        // Request a string response from the provided URL.

        apiClient.download().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("database",response.body());
                editor.commit();
                Log.e("REQUESTING", response.body());
                Snackbar.make(view,"Nuevos horarios Actualizados, reinicia la App para verlos!", Snackbar.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("Error request ",t.getMessage());
                Snackbar.make(view,"No hay conexion para descargar Actualizaciones", Snackbar.LENGTH_SHORT).show();
            }
        });
    }


}
