package edu.cftic.fichapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.CheckBox;


public class Preferencias {

    public static final String MODO_OSCURO = "modo_oscuro";
    public static final String TERMINOS_ACEPTADOS = "terminos_aceptados";
    //TODO GESTIONAR ENVIO AUTOMÁTICO
    //TODO GESTIONAR PERIODICIDAD DEL ENVÍO / GENERACIÓN DEL INFORME

    private static final String NOMBRE_FICHERO = "fichero_prefs";

    public static boolean terminosAceptados(Context context)
    {
        boolean b = false;
        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        b = fichero.getBoolean(TERMINOS_ACEPTADOS, false);

        return b;
    }

    public static void setTerminos(Context context, boolean valor)
    {
        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = fichero.edit();

        editor.putBoolean(TERMINOS_ACEPTADOS,valor);
        editor.commit();

    }




    public static void check(Context context, CheckBox checkBox) {


        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = fichero.edit();

        String x = String.valueOf(checkBox.getId());

        editor.putBoolean(x,true);
        editor.commit();


    }

    //ESTE ISCHECK SE REFIERE SOLO AL CHECKBOX DE LA AYUDA, SIGNIFICA QUE SI ES TRUE NO SE MUES
    public static boolean isCheck (Context context, CheckBox checkBox){

        boolean b = false;
        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);

        String x = String.valueOf(checkBox.getId());

        b = fichero.getBoolean(x, false);

        return b;
    }

    public static void guardar_booleano(Context context, boolean b) {

        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = fichero.edit();

        editor.putBoolean("booleano",b);
        editor.commit();


    }

    public static boolean mostrar_booleano(Context context) {

        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = fichero.edit();

        return fichero.getBoolean("booleano",false);

    }

    public static void guardar_string(Context context, String t) {

        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = fichero.edit();

        editor.putString("texto",t);
        editor.commit();


    }

    public static String mostrar_string(Context context) {

        SharedPreferences fichero = null;

        fichero = context.getSharedPreferences(NOMBRE_FICHERO, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = fichero.edit();

        return fichero.getString("texto",null);

    }


}