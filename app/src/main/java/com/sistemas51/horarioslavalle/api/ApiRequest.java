package com.sistemas51.horarioslavalle.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.sistemas51.horarioslavalle.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiRequest {

    public void init(SharedPreferences sharedPreferences, Context context, View view){
        validateVersion(sharedPreferences,context,view,false);

    }

    public void forceDownload(SharedPreferences sharedPreferences, Context context, View view){
        validateVersion(sharedPreferences,context,view,true);

    }
    private void validateVersion(final SharedPreferences sharedPreferences, final Context context, final View view,boolean force){
        String result;
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, context.getResources().getString(R.string.urlApi),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Integer version = sharedPreferences.getInt("version",0);
                        Integer apiVersion = null;
                        boolean special= false;
                        try {
                            JSONObject json = new JSONObject(response);
                            apiVersion = json.getInt("version");
                            special = json.getBoolean("special");
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("special",special);
                            editor.apply();
                            Log.e("REQUESTING", response);
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
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(view,"No hay conexion para comprobar Actualizaciones", Snackbar.LENGTH_SHORT).show();
                Log.e("Error request ",String.valueOf(error));
            }
        });
        queue.add(stringRequest);
    }

    private void download(final SharedPreferences sharedPreferences, Context context,final View view){
        RequestQueue queue = Volley.newRequestQueue(context);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, context.getResources().getString(R.string.urlApiDownload),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       SharedPreferences.Editor editor = sharedPreferences.edit();
                       editor.putString("database",response);
                       editor.commit();
                       Log.e("REQUESTING", response);
                        Snackbar.make(view,"Nuevos horarios Actualizados, reinicia la App para verlos!", Snackbar.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error request ",error.getMessage());
                Snackbar.make(view,"No hay conexion para descargar Actualizaciones", Snackbar.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }

}
