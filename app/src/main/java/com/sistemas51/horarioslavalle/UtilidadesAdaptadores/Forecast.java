package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by serguei on 03/10/16.
 */

public class Forecast {

    private String location;
    private String description;


    public Forecast(String location, String description) {

        this.location = location;
        this.description = description;

    }

    /**
     * Metodo estatico que genera una lista de forecasts falsos para propositos de mock
     *
     * @return
     */

    public static List<Forecast> getidaList(int hora, int minutos, String[] array, int llegada) throws ParseException {
        Horario horario = new Horario();
        List<Forecast> semana = new ArrayList<>();
        Date horadate;
        String antesdelas6 = "07:31";
        Date antesdelas6date = horario.parseoADate(antesdelas6);
        String llegadahora;

            for (int i = 0; i < array.length; i++) {
                horadate = horario.parseoADate(array[i]);
                horadate = horario.sumarhoras(horadate, hora, minutos);
                llegadahora = horario.parseoAString(horadate);

                if (llegada == 5 && horadate.before(antesdelas6date)) {

                    horadate = horario.sumarhoras(horadate, 0, -13);
                    llegadahora = horario.parseoAString(horadate);
                } else {}

                Forecast data = new Forecast("Partida: " + array[i], "Llegada: " + llegadahora + " aprox.");
                semana.add(data);

            }

        return semana;

    }
public static List<Forecast> getvueltalist(int hora, int minutos, String[] array, int partida) throws ParseException {
    Horario horario = new Horario();
    List<Forecast> semana = new ArrayList<>();
    Date horadate;
    String antesdelas6 = "05:26";
    Date antesdelas6date = horario.parseoADate(antesdelas6);
    String llegadahora;

    for (int i = 0; i < array.length; i++) {
        horadate = horario.parseoADate(array[i]);
        horadate = horario.sumarhoras(horadate, -hora, -minutos);
        llegadahora = horario.parseoAString(horadate);

        if (partida == 5 && horadate.before(antesdelas6date)) {
            horadate = horario.sumarhoras(horadate, 0, -13);
            llegadahora = horario.parseoAString(horadate);

        } else {}

        Forecast data = new Forecast("Partida: " + llegadahora, "Llegada: " + array[i] + " aprox.");
        semana.add(data);

    }

    return semana;


}
    public static List<Forecast> getigual( String[] array){
        List<Forecast> semana = new ArrayList<>();

        for (int i=0;i< array.length;i++){

          Forecast data= new Forecast("Partida: "+ array[i], "Llegada: "+array[i]);

           semana.add(data);
        }
        return semana;


    }

    public static List<Forecast> get40(String[]arraydestino, String[] arrayllegada){
       List<Forecast> fin= new ArrayList<>();
        for (int i=0;i<arraydestino.length;i++){
            if (arraydestino[i].equals("n")==false) {
                if(arrayllegada[i].equals("n")==false) {
                    Forecast data = new Forecast("Partida: " + arraydestino[i], "Llegada: " + arrayllegada[i]);
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