package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;


import android.content.Context;

import com.sistemas51.horarioslavalle.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class HorarioModel {

    private String from;
    private String to;
    private String description;
    private boolean next;
    private static final String WEEK = "week";
    private static final String SATURDAY ="saturday";
    private static final String SUNDAY = "sunday";

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public HorarioModel(String from, String to, boolean next,String additional) {

        this.from = from;
        this.to = to;
        this.next = next;
        this.description = additional;
    }

    public static List<HorarioModel> getHour(List<String>from, List<String> to, int day,List<String>additional) throws ParseException {
        boolean isfirst= false;
        List<HorarioModel> result= new ArrayList<>();
        if (from == null || to ==null){
            HorarioModel data = new HorarioModel("No hay horarios diponibles", "Intenta con otro recorrido",false,null);
            result.add(data);
        }else {
            for (int i = 0; i < from.size(); i++) {
                if (!from.get(i).equals("null")) {
                    if (!to.get(i).equals("null")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
                        Date hourDate = null;
                        Date now = new Date();
                        Calendar calendar = Calendar.getInstance();
                        hourDate = sdf.parse(from.get(i));
                        now = sdf.parse(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
                        String additionals = additional.get(i).equals("null") ? " ": additional.get(i);
                        if (!isfirst && hourDate.after(now)) {
                            isfirst = true;
                            boolean isToday = false;
                            if(calendar.get(Calendar.DAY_OF_WEEK) ==  day) {
                                isToday = true;

                            }else if(calendar.get(Calendar.DAY_OF_WEEK) !=  Calendar.SUNDAY && calendar.get(Calendar.DAY_OF_WEEK) !=  Calendar.SATURDAY &&day== -1){
                                isToday = true;
                            }
                            HorarioModel data = new HorarioModel("Partida: " + from.get(i).substring(0,5), "Llegada: " + to.get(i).substring(0,5), isToday,additionals);
                            result.add(data);
                        } else {
                            HorarioModel data = new HorarioModel("Partida: " + from.get(i).substring(0,5), "Llegada: " + to.get(i).substring(0,5), false,additionals);
                            result.add(data);
                        }
                    }
                }
            }
            if (result.size() == 0){
                HorarioModel data = new HorarioModel("No hay horarios diponibles", "Intenta con otro recorrido",false,null);
                result.add(data);
            }
        }
       return result;

    }

    public static String getNamesKey(String from, String to, String route, String day ,Context context){
        String result = null;
        Map<String,String> places = new HashMap<>();
        String resultFrom =null;
        String direction;
        switch (route) {
            case "Ruta 24":
                places = ResourceUtils.getHashMapResource(context, R.xml.r24_places);
                resultFrom = "ruta24";
                break;
            case "Ruta 40":
                places = ResourceUtils.getHashMapResource(context, R.xml.r40_places);
                resultFrom = "ruta40";
                break;
            case "California":
                places = ResourceUtils.getHashMapResource(context, R.xml.california_places);
                resultFrom = "california";
                break;
            case "Internos Costa de Araujo":
                places = ResourceUtils.getHashMapResource(context,R.xml.interno_costa_places);
                resultFrom = "internocosta";
                break;
            case "Internos Villa Tulumaya":
                places = ResourceUtils.getHashMapResource(context,R.xml.interno_villa_places);
                resultFrom = "internolavalle";
                break;
        }
        if (places != null){
            if (Integer.valueOf(places.get(from))<Integer.valueOf(places.get(to))){
                direction = "ida";
            }else{
                direction = "vuelta";
            }

            result = resultFrom+direction+day;
        }


        return result;
    }


    public static String getTableName(String table, String route,Context context){
        String result = null;
        switch (route){
            case "Ruta 24":
                result = ResourceUtils.getHashMapResource(context,R.xml.r24_table_names).get(table);
                break;
            case "Ruta 40":
                result = ResourceUtils.getHashMapResource(context,R.xml.r40_table_names).get(table);
                break;
            case "California":
                result = ResourceUtils.getHashMapResource(context,R.xml.california_table_names).get(table);
                break;
            case "Internos Costa de Araujo":
                result = ResourceUtils.getHashMapResource(context,R.xml.interno_costa_table_names).get(table);
                break;
            case "Internos Villa Tulumaya":
                result = ResourceUtils.getHashMapResource(context,R.xml.interno_villa_table_names).get(table);
                break;
        }
        return result;
    }


    public static List getFromJsonArray(JSONArray jsonArray) throws JSONException {
        ArrayList<String> list = new ArrayList<String>();
        if (jsonArray==null){
            list = null;
        }else{
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i=0;i<len;i++){
                    list.add(jsonArray.get(i).toString());
                }
            }
        }

        return list;

    }

    public static String formattoString(int minutos) {
        String formato = "%02d:%02d";
        long horasReales = TimeUnit.MINUTES.toHours(minutos);
        long minutosReales = TimeUnit.MINUTES.toMinutes(minutos) - TimeUnit.HOURS.toMinutes(TimeUnit.MINUTES.toHours(minutos));
        return String.format(formato, horasReales, minutosReales);
    }
    public static List<String> getPlacesFromRoute(String routeSelected,Context context){
        int arrayId = 0;
        if (routeSelected.equals("Ruta 24")){
            arrayId = R.array.nombredelugares;
        }else if (routeSelected.equals("Ruta 40")){
            arrayId = R.array.nombredelugaresr40;
        }else if (routeSelected.equals("California")){
            arrayId = R.array.nombrelugarescalifornia;
        }else if (routeSelected.equals("Internos Costa de Araujo")){
            arrayId = R.array.placesInternosCosta;
        }else if(routeSelected.equals("Internos Villa Tulumaya")){
            arrayId = R.array.placesInternosVilla;
        }
        String[] placesArray = context.getResources().getStringArray(arrayId);
        List<String> places = new ArrayList<>();
        for (String place : placesArray){
            places.add(place);
        }
        return places;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}