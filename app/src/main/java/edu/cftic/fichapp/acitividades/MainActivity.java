package edu.cftic.fichapp.acitividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.bean.Empleado;
import edu.cftic.fichapp.bean.Empresa;
import edu.cftic.fichapp.bean.Fichaje;
import edu.cftic.fichapp.persistencia.DB;
import edu.cftic.fichapp.util.Constantes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ejemplo de uso de la base de datos
        /*Empresa em = new Empresa("B123456","XYZYZ SA","T T","xyz@xyz.com");
        boolean v = DB.empresas.nuevo(em);
        Empleado nu = DB.empleados.getEmpleadoUsuarioClave("","");
        ArrayList<Empresa> ae = (ArrayList<Empresa>) DB.empresas.getEmpresas();
        em = DB.empresas.ultimo();

        Log.i(Constantes.TAG_APP, "u: "+ em);

        Empleado tr = new Empleado("JUAN YONG 2","JYON3","12345","B", false, em);
        boolean t = DB.empleados.nuevo(tr);
        ArrayList<Empleado> at = (ArrayList<Empleado>) DB.empleados.getEmpleados();

        tr = DB.empleados.ultimo();
        Log.i(Constantes.TAG_APP, "E: "+tr);
        for(Empleado es : at){
            Log.i(Constantes.TAG_APP, "= "+es);
        }
        at = (ArrayList<Empleado>) DB.empleados.getEmpleados();

        Timestamp de = new Timestamp(new Date().getTime());
        Timestamp hasta = new Timestamp(new Date().getTime());

        Fichaje fe = new Fichaje(tr, de, hasta, "Mensaje");
        Log.i(Constantes.TAG_APP, "F: "+fe);
        boolean d = DB.fichar.nuevo(fe);
        ArrayList<Fichaje> af = (ArrayList<Fichaje>) DB.fichar.getFicheje(tr.getId_empleado());

        for(Fichaje es : af){
            Log.i(Constantes.TAG_APP, "= "+es);
        }

        ArrayList<String> rol = (ArrayList<String>) DB.empleados.getRoles();
        for(String es : rol){
            Log.i(Constantes.TAG_APP, "R:: "+es);
        }

        Fichaje ul = DB.fichar.getFichajeUltimo(tr.getId_empleado());
        Log.i(Constantes.TAG_APP, ""+ul.toString());*/
    }
}
