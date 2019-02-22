package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by serguei on 03/10/16.
 */

public class HorarioModel {

    private String location;
    private String description;


    public HorarioModel(String location, String description) {

        this.location = location;
        this.description = description;

    }


    public static List<HorarioModel> getigual(String[] array){
        List<HorarioModel> semana = new ArrayList<>();

        for (int i=0;i< array.length;i++){

          HorarioModel data= new HorarioModel("Partida: "+ array[i], "Llegada: "+array[i]);

           semana.add(data);
        }
        return semana;


    }

    public static List<HorarioModel> get40(String[]arraydestino, String[] arrayllegada){
       List<HorarioModel> fin= new ArrayList<>();
        for (int i=0;i<arraydestino.length;i++){
            if (arraydestino[i].equals("n")==false) {
                if(arrayllegada[i].equals("n")==false) {
                    HorarioModel data = new HorarioModel("Partida: " + arraydestino[i], "Llegada: " + arrayllegada[i]);
                    fin.add(data);
                }

            }
else{}
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