package com.sistemas51.horarioslavalle.v2;

import android.content.Context;
import android.content.res.Resources;

import com.sistemas51.horarioslavalle.R;


public class Utils {
    

    final private String R24 =  "Ruta24";
    final private String R40 = "Ruta40";
    final private String CALIFORNIA = "California";
    Resources res;


    public Utils(Resources res){
        this.res= res;
    }
    /**
     * Devuelve el Array correspondiente
     * @param type Ruta
     * @param origennum ID de Punto
     * @param day Dia de la semana
     * @param isIda ¿Es ida o vuelta?
     * @return
     */
    public  String[] getArrayPartida(String type, int origennum, String day, boolean isIda){
    String [] result = null;


            if (type.equals(R24)) {
                if (isIda) {
                    if (origennum == 0) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.ida_Asuncion);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_ida_asuncion);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_ida_asuncion);}
                    }
                    else if (origennum == 1) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.ida_el15);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_ida_el15);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_ida_el15);}
                    }
                    else if (origennum == 2) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.ida_gustavoAndre);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_ida_gustavoAndre);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_ida_gustavoAndre);}
                    }
                    else if (origennum == 3) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.ida_costa);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_ida_costa);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_ida_costa);}
                    }
                    else if (origennum == 4) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.ida_lavalle);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_ida_lavalle);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_ida_lavalle);}
                    }
                    else if (origennum == 5) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.ida_mendoza);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_ida_mendoza);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_ida_mendoza);}

                    }
                }else if (!isIda){
                    if (origennum == 0) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.vuelta_asuncion);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_vuelta_asuncion);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_vuelta_asuncion);}
                    }
                    else if (origennum == 1) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.vuelta_el15);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_vuelta_el15);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_vuelta_el15);}
                    }
                    else if (origennum == 2) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.vuelta_gustavoAndre);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_vuelta_gustavoAndre);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_vuelta_gustavoAndre);}
                    }
                    else if (origennum == 3) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.vuelta_costa);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_vuelta_costa);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_vuelta_costa);}
                    }
                    else if (origennum == 4) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.vuelta_lavalle);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_vuelta_lavalle);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_vuelta_lavalle);}
                    }
                    else if (origennum == 5) {
                        if (day == res.getString(R.string.Semana)) {result = res.getStringArray(R.array.vuelta_mendoza);}
                        else if (day == res.getString(R.string.Sabado)) {result = res.getStringArray(R.array.sabado_vuelta_mendoza);}
                        else if (day == res.getString(R.string.Domingo)) {result = res.getStringArray(R.array.domingo_vuelta_mendoza);}

                    }
                }
            }
            if(type.equals(R40)){
                if (isIda) {
                    if (origennum == 0) {
                       if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_km56);}
                       else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_km56);}
                       else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_km56);}
                    }
                    else if (origennum == 1) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_km47esc);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_km47esc);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_km47esc);}
                    }
                    else if (origennum == 2) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_jocolikm43);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_jocolikm43);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_jocolikm43);}
                    }
                    else if (origennum == 3) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_oscarmendoza);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_oscarmendoza);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_oscarmendoza);}
                    }
                    else if (origennum == 4) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_andacollo);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_andacollo);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_andacollo);}
                    }
                    else if (origennum == 5) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_croco);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_croco);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_croco);}
                    }
                    else if (origennum == 6) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_sguazini);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_sguazini);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_sguazini);}
                    }
                    else if (origennum == 7) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_3demayo);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_3demayo);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_3demayo);}
                    }
                    else if (origennum == 8) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_sanfrancisco);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_sanfrancisco);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_sanfrancisco);}
                    }
                    else if (origennum == 9) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_citalia);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_citalia);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_citalia);}
                    }
                    else if (origennum == 10) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_blacolm);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_blacolm);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_blacolm);}
                    }
                    else if (origennum == 11) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_salvatierra);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_salvatierra);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_salvatierra);}
                    }
                    else if (origennum == 12){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_paramillo);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_paramillo);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_paramillo);}
                    }
                    else if (origennum == 13) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_lavalle);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_lavalle);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_lavalle);}
                    }
                    else if (origennum == 14) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_elvergel);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_elvergel);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_elvergel);}
                    }
                    else if (origennum == 15) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_cruce);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_cruce);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_cruce);}
                    }
                    else if (origennum == 16) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_pastal);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_pastal);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_pastal);}
                    }
                    else if (origennum == 17) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_borbollon);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_borbollon);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_borbollon);}
                    }
                    else if (origennum == 18) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_40_mendoza);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_40_mendoza);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_40_mendoza);}
                    }


                }else if (!isIda) {
                    if (origennum == 0) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_km56);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_km56);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_km56);}
                    }
                    else if (origennum == 1) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_km47esc);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_km47esc);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_km47esc);}
                    }
                    else if (origennum == 2) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_jocolikm43);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_jocolikm43);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_jocolikm43);}
                    }
                    else if (origennum == 3) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_oscarmendoza);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_oscarmendoza);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_oscarmendoza);}
                    }
                    else if (origennum == 4) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_andacollo);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_andacollo);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_andacollo);}
                    }
                    else if (origennum == 5) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_croco);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_croco);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_croco);}
                    }
                    else if (origennum == 6) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_sguazini);}
                        else  if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_sguazini);}
                        else  if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_sguazini);}
                    }
                    else if (origennum == 7) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_3demayo);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_3demayo);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_3demayo);}
                    }
                    else if (origennum == 8) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_sanfrancisco);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_sanfrancisco);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_sanfrancisco);}
                    }
                    else if (origennum == 9) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_citalia);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_citalia);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_citalia);}
                    }
                    else if (origennum == 10) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_blacolm);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_blacolm);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_blacolm);}
                    }
                    else if (origennum == 11) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_salvatierra);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_salvatierra);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_salvatierra);}
                    }
                    else if (origennum == 12){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_paramillo);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_paramillo);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_paramillo);}
                    }
                    else if (origennum == 13) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_lavalle);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_lavalle);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_lavalle);}
                    }
                    else if (origennum == 14) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_elvergel);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_elvergel);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_elvergel);}
                    }
                    else if (origennum == 15) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_cruce);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_cruce);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_cruce);}
                    }
                    else if (origennum == 16) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_pastal);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_pastal);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_pastal);}
                    }
                    else if (origennum == 17) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_borbollon);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_borbollon);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_borbollon);}
                    }
                    else if (origennum == 18) {
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_40_mendoza);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_40_mendoza);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_40_mendoza);}
                    }
                }

            }
            if (type.equals(CALIFORNIA)){
                if (isIda) {
                    if(origennum==0){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_california_william);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_california_william);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_california_william);}
                    }
                    else if(origennum==1){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_california_3portena);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_california_3portena);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_california_3portena);}
                    }
                    else if(origennum==2){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_california_central);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_california_central);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_california_central);}
                    }
                    else if(origennum==3){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_california_california);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_california_california);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_california_california);}
                    }
                    else if(origennum==4){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.ida_semana_california_costa);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.ida_sabado_california_costa);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.ida_domingo_california_costa);}
                    }
                }
                else if(!isIda){

                    if(origennum==0){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_california_william);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_california_william);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_california_william);}
                    }
                    else if(origennum==1){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_california_3portena);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_california_3portena);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_california_3portena);}
                    }
                    else if(origennum==2){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_california_central);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_california_central);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_california_central);}
                    }
                    else if(origennum==3){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_california_california);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_california_california);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_california_california);}
                    }
                    else if(origennum==4){
                        if (day == res.getString(R.string.Semana)) {  result = res.getStringArray(R.array.vuelta_semana_california_costa);}
                        else if (day == res.getString(R.string.Sabado)) {  result = res.getStringArray(R.array.vuelta_sabado_california_costa);}
                        else if (day == res.getString(R.string.Domingo)){  result = res.getStringArray(R.array.vuelta_domingo_california_costa);}
                    }
                }
            }


        return result;
    }

}
