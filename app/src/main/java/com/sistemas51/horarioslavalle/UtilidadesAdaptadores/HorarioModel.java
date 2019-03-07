package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;


import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by serguei on 03/10/16.
 */

public class HorarioModel {

    private String location;
    private String description;
    private boolean expanded;

    public HorarioModel(String location, String description) {

        this.location = location;
        this.description = description;

    }




    public static List<HorarioModel> get40(String[]arraydestino, String[] arrayllegada){
        boolean isfirst= false;
        List<HorarioModel> fin= new ArrayList<>();
        for (int i=0;i<arraydestino.length;i++){
            if (arraydestino[i].equals("n")==false) {
                if(arrayllegada[i].equals("n")==false) {

                    SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
                    Date hourDate= null;
                    Date now= new Date();
                    try {
                        hourDate = sdf.parse(arraydestino[i]);
                        now = sdf.parse(now.getHours() + ":" + now.getMinutes());
                    } catch (ParseException e) {
                    }
                    if (!isfirst){
                        if (hourDate.after(now)) {
                            isfirst=true;
                            HorarioModel data = new HorarioModel("x","x");
                            fin.add(data);
                        }
                    }
                    HorarioModel data = new HorarioModel("Partida: " + arraydestino[i], "Llegada: " + arrayllegada[i]);
                    fin.add(data);



                }

            }
        }
       return fin;



    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}