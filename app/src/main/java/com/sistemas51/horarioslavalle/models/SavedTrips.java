package com.sistemas51.horarioslavalle.models;

import android.content.SharedPreferences;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sistemas51.horarioslavalle.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SavedTrips {


    private String name;
    private String route;
    private String from;
    private String to;
    private int drawable;

    public SavedTrips(String name, String route, String from, String to, int drawable) {
        this.name = name;
        this.route = route;
        this.from = from;
        this.to = to;
        this.drawable = drawable;
    }

    public SavedTrips(String name, String route, String from, String to) {
        this.name = name;
        this.route = route;
        this.from = from;
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public static List<SavedTrips> getSavedTrips(SharedPreferences sharedPreferences) throws JSONException {
        List<SavedTrips> result = new ArrayList<>();
        result.add(new SavedTrips("Actualizar Horarios",null,null,null, R.drawable.ic_get_app));
        result.add(new SavedTrips("Ayuda",null,null,null,R.drawable.ic_help_outline));

        JSONArray jsonArray = new JSONArray(sharedPreferences.getString("favorites", String.valueOf(new JSONArray())));
        for (int i = 0 ; i< jsonArray.length();i++){
            JSONObject trip = new JSONObject(jsonArray.getString(i));
            result.add(new SavedTrips(trip.getString("name"),trip.getString("route"),trip.getString("from"),trip.getString("to"),R.drawable.ic_favorite));
        }


        return result;
    }

    public static void saveTrip(SharedPreferences sharedPreferences, SavedTrips savedTrips) throws JSONException {
       SharedPreferences.Editor editor =  sharedPreferences.edit();
        //get current favorites
        JSONArray favorites = new JSONArray(sharedPreferences.getString("favorites", String.valueOf(new JsonArray())));

        //create a new Trip
        JsonObject trip = new JsonObject();
        trip.addProperty("name",savedTrips.getName());
        trip.addProperty("route",savedTrips.getRoute());
        trip.addProperty("from",savedTrips.getFrom());
        trip.addProperty("to",savedTrips.getTo());

        //put this trip in the favorites
       favorites.put(trip);

       //override for the new favorites
       editor.putString("favorites", String.valueOf(favorites));
       editor.apply();
    }

    public static void unsaveTrip(SharedPreferences sharedPreferences, SavedTrips savedTrips) throws JSONException {

        //get current favorites
        JSONArray favorites = new JSONArray(sharedPreferences.getString("favorites",null)); //its null cause we cant unsave a trip if it dosnt created yet
        SharedPreferences.Editor editor =  sharedPreferences.edit();

        for (int i = 0 ; i< favorites.length();i++){
            JSONObject trip = new JSONObject(favorites.getString(i));
            if (savedTrips.getName().equals(trip.getString("name"))){
                favorites.remove(i);
                break;
            }
        }
        //override for the new favorites
        editor.putString("favorites", String.valueOf(favorites));
        editor.apply();
    }

    public static boolean isFavorited(SharedPreferences sharedPreferences, String name) throws JSONException {
        boolean result = false;
        JSONArray jsonArray = new JSONArray(sharedPreferences.getString("favorites", String.valueOf(new JSONArray())));
        for (int i = 0 ; i< jsonArray.length();i++){
            JSONObject trip = new JSONObject(jsonArray.getString(i));
            if(trip.getString("name").equals(name)){
                result = true;
                break;
            }
        }
        return result;
    }
}
