package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;


import android.content.Context;

import com.sistemas51.horarioslavalle.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HorarioModel {

    private String from;
    private String to;

    public HorarioModel(String from, String to) {

        this.from = from;
        this.to = to;

    }

    public static List<HorarioModel> get40(String[]from, String[] to){
        boolean isfirst= false;
        List<HorarioModel> result= new ArrayList<>();
        for (int i=0;i<from.length;i++){
            if (from[i].equals("n")==false) {
                if(to[i].equals("n")==false) {

                    SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
                    Date hourDate= null;
                    Date now= new Date();
                    try {
                        hourDate = sdf.parse(from[i]);
                        now = sdf.parse(now.getHours() + ":" + now.getMinutes());
                    } catch (ParseException e) {
                    }
                    if (!isfirst){
                        if (hourDate.after(now)) {
                            isfirst=true;
                            HorarioModel data = new HorarioModel("x","x");
                            result.add(data);
                        }
                    }
                    HorarioModel data = new HorarioModel("Partida: " + from[i], "Llegada: " + to[i]);
                    result.add(data);



                }

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
        }
        if (Integer.valueOf(places.get(from))<Integer.valueOf(places.get(to))){
            direction = "ida";
        }else{
            direction = "vuelta";
        }

        result = resultFrom+direction+day;

        return result;
    }


    public static String getTableName(String table, String route,Context context){
        String result = null;
        switch (route){
            case "Ruta 24":
                result = ResourceUtils.getHashMapResource(context,R.xml.r24_table_names).get(table);
            case "Ruta 40":
                result = ResourceUtils.getHashMapResource(context,R.xml.r40_table_names).get(table);
            case "California":
                result = ResourceUtils.getHashMapResource(context,R.xml.california_table_names).get(table);
        }
        return result;
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


}