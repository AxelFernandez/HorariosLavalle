package com.sistemas51.horarioslavalle.UtilidadesAdaptadores;

import android.content.res.Resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by axelfernandez on 16/6/17.
 */

public class Horario {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Resources res;

    public Date horaactual() throws ParseException {
        //Devuelve hora actual solo para manipular horas, convertir antes en horaAConvertir
        String horaactua = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
        Date rigthnow = sdf.parse(horaactua);
        return rigthnow;
    }

    public Date sumarhoras(Date fecha, int horas, int minutos) {
        //Dada una fecha le suma horas
        calendar.setTime(fecha);
        calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<
        calendar.add(Calendar.MINUTE, minutos);
        return calendar.getTime();
    }


    public Date parseoADate(String hora) throws ParseException {
        //Convierte un String a DATE (HH:MM)
        Date parseofinal;
        return parseofinal = sdf.parse(hora);
    }


    public String parseoAString(Date horaaparsear) {
        //Convierte un DATE de HH:MM a String
        int hora = horaaparsear.getHours();
        int minut = horaaparsear.getMinutes();
        String newhora;
        String newminutes;
        if (hora < 10) { newhora = "0"+hora;}else{newhora=String.valueOf(hora);}

        if (minut < 10) {newminutes = "0"+minut;}else{newminutes=String.valueOf(minut);}
        return newhora + ":" + newminutes;
    }
public int getidahoras(int origennum, int llegadanum){
int horas= 0;

    if (origennum == 0) {


        if (llegadanum == 0) {
            horas = 0;
        }
        if (llegadanum == 1) {
            horas = 0;
        }
        if (llegadanum == 2) {
            horas = 0;
        }
        if (llegadanum == 3) {
            horas = 0;
        }
        if (llegadanum == 4) {
            horas = 0;
        }
        if (llegadanum == 5) {
            horas = 1;
        }

    }
    if (origennum == 1) {

        if (llegadanum == 1) {
            horas = 0;

        }
        if (llegadanum == 2) {
            horas = 0;

        }
        if (llegadanum == 3) {
            horas = 0;

        }
        if (llegadanum == 4) {
            horas = 0;

        }
        if (llegadanum == 5) {
            horas = 1;

        }

    }
    if (origennum == 2) {

        if (llegadanum == 2) {
            horas = 0;

        }
        if (llegadanum == 3) {
            horas = 0;

        }
        if (llegadanum == 4) {
            horas = 0;

        }
        if (llegadanum == 5) {
            horas = 1;

        }


    }
    if (origennum == 3) {

        if (llegadanum == 3) {
            horas = 0;

        }
        if (llegadanum == 4) {
            horas = 0;

        }
        if (llegadanum == 5) {
            horas = 1;

        }

    }
    if (origennum == 4) {

        if (llegadanum == 4) {
            horas = 0;

        }
        if (llegadanum == 5) {
            horas = 1;

        }

    }
    if (origennum == 5) {

        if (llegadanum == 5) {
            horas = 0;

        }

    }

   return horas;
}
public int getidaminutos(int origennum, int llegadanum){
int minutos = 0;
    if (origennum == 0) {


        if (llegadanum == 0) {
            minutos = 0;
        }
        if (llegadanum == 1) {
            minutos = 10;
        }
        if (llegadanum == 2) {
            minutos = 15;
        }
        if (llegadanum == 3) {
            minutos = 37;
        }
        if (llegadanum == 4) {
            minutos = 58;
        }
        if (llegadanum == 5) {
            minutos = 58;
        }

    }
    if (origennum == 1) {

        if (llegadanum == 1) {
            minutos = 0;
        }
        if (llegadanum == 2) {
            minutos = 5;
        }
        if (llegadanum == 3) {
            minutos = 25;
        }
        if (llegadanum == 4) {
            minutos = 47;
        }
        if (llegadanum == 5) {
            minutos = 47;
        }

    }
    if (origennum == 2) {

        if (llegadanum == 2) {
            minutos = 0;
        }
        if (llegadanum == 3) {
            minutos = 20;
        }
        if (llegadanum == 4) {
            minutos = 43;
        }
        if (llegadanum == 5) {
            minutos = 43;
        }


    }
    if (origennum == 3) {

        if (llegadanum == 3) {
            minutos = 0;
        }
        if (llegadanum == 4) {
            minutos = 23;
        }
        if (llegadanum == 5) {
            minutos = 23;
        }

    }
    if (origennum == 4) {

        if (llegadanum == 4) {
            minutos = 0;
        }
        if (llegadanum == 5) {

            minutos = 0;
        }

    }
    if (origennum == 5) {

        if (llegadanum == 5) {

            minutos = 0;
        }

    }
  return minutos;

}
public int getvueltahoras(int origennum, int llegadanum){
int horas= 0;
    if (llegadanum == 0) {

        if(origennum==0){horas=0; }
        if(origennum==1){horas=0;}
        if(origennum==2){horas=0;}
        if(origennum==3){horas=0;}
        if(origennum==4){horas=0;}
        if(origennum==5){horas=1;}
    }
    if (llegadanum == 1) {

        if(origennum==1){horas=0;}
        if(origennum==2){horas=0;}
        if(origennum==3){horas=0;}
        if(origennum==4){horas=0;}
        if(origennum==5){horas=1;}
    }
    if (llegadanum == 2) {

        if(origennum==2){horas=0;}
        if(origennum==3){horas=0;}
        if(origennum==4){horas=0;}
        if(origennum==5){horas=1;}
    }
    if (llegadanum == 3) {

        if(origennum==3){horas=0;}
        if(origennum==4){horas=0;}
        if(origennum==5){horas=1;}
    }
    if (llegadanum == 4) {

        if(origennum==4){horas=0;}
        if(origennum==5){horas=1;}
    }
    if (llegadanum == 5) {

        if(origennum==5){horas=0;}

    }

    return horas;
}

public int getvueltaminutos(int origennum, int llegadanum){
   int minutos =0;
    if (llegadanum == 0) {

        if(origennum==0){ minutos=0;}
        if(origennum==1){minutos=10;}
        if(origennum==2){minutos=15;}
        if(origennum==3){minutos=37;}
        if(origennum==4){minutos=58;}
        if(origennum==5){minutos=58;}
    }
    if (llegadanum == 1) {

        if(origennum==1){minutos=0;}
        if(origennum==2){minutos=5;}
        if(origennum==3){minutos=25;}
        if(origennum==4){minutos=47;}
        if(origennum==5){minutos=47;}
    }
    if (llegadanum == 2) {

        if(origennum==2){minutos=0;}
        if(origennum==3){minutos=20;}
        if(origennum==4){minutos=43;}
        if(origennum==5){minutos=43;}
    }
    if (llegadanum == 3) {

        if(origennum==3){minutos=0;}
        if(origennum==4){minutos=23;}
        if(origennum==5){minutos=23;}
    }
    if (llegadanum == 4) {

        if(origennum==4){minutos=0;}
        if(origennum==5){minutos=0;}
    }
    if (llegadanum == 5) {

        if(origennum==5){minutos=0;}

    }
    return minutos;
}



}