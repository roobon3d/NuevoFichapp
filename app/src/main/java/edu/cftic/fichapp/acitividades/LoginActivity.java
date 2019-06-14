package edu.cftic.fichapp.acitividades;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aeat.valida.Validador;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.bean.Empleado;
import edu.cftic.fichapp.bean.Empresa;
import edu.cftic.fichapp.persistencia.DB;
import edu.cftic.fichapp.util.Constantes;

public class LoginActivity extends AppCompatActivity  {

    EditText usuario;
    EditText contraseña;
    ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);

//TODO recoger la empresa y setear el logo en el login
        logo = findViewById(R.id.imagen_logo);
        Empresa empresa = null;
        empresa = DB.empresas.ultimo();
        if (empresa != null){
            String rutalogo = empresa.getRutalogo();
            logo.setImageURI(Uri.parse(rutalogo));
        }

    }

    /**
     * COTEJAR LOS DATOS INTRODUCIDOS CON LA BASE DE DATOS (USUARIO Y CONTRASEÑA)
     * @return
     */
    public void entrar(View view) {

        String nombre = usuario.getText().toString();
        String cont = contraseña.getText().toString();
        Empleado u = DB.empleados.getEmpleadoUsuarioClave(nombre,cont);
        //Valida
        //Validador validador
        if(u==null){

            TextView incorrecto = findViewById(R.id.incorrecto);

            limpiarText(usuario,contraseña);

            incorrecto.setText(R.string.error_login);

        }
        //TODO SALTAR AL MENU DE TRABAJADOR O GESTOR

        if (u.getRol()== Constantes.ROL_EMPLEADO ){
           /*
            Intent intent = new Intent(this,MenuEmpleado.class);
             intent.putExtra("ID_EMPLEADO",u.getId_empleado());
            intent.putExtra("EMPLEADO",u);
             */



        }else if(u.getRol()==Constantes.ROL_GESTOR ){
           /*
            Intent intent = new Intent(this,MenuGestor.class);
             intent.putExtra("ID_EMPLEADO",u.getId_empleado());
            intent.putExtra("EMPLEADO",u);
             */

        }
        /*
        if( null != intent) {

            startActivity( intent);
        }*/
    }


    public void limpiarText(EditText ... array ) {//VARARGS

        for (EditText e : array) {

            e.setText("");
            //e.clearFocus();

        }
    }

    public void creditos(View view) {

        Intent intent = new Intent(this, Creditos.class);
        startActivity(intent);
        finish();

    }
}

