package edu.cftic.fichapp.actividades;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.bean.Empleado;
import edu.cftic.fichapp.bean.Empresa;
import edu.cftic.fichapp.persistencia.DB;
import edu.cftic.fichapp.util.Constantes;

public class LoginActivity extends AppCompatActivity  {

    EditText usuario;
    EditText contraseña;
    ImageView logo;

    private Empleado hayGestor() {
        Empleado empleado = null;

        empleado = DB.empleados.getGestor();


        return empleado;
    }

    private boolean hayEmpresa() {
        boolean b = false;

        Empresa empresa = DB.empresas.primero();
        if (empresa != null) {
            b = true;
        }

        return b;
    }

    private void lanzarActividad(Class actividad_destino) {
        Intent i = new Intent(this, actividad_destino);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (!hayEmpresa()) {

            lanzarActividad(RegistroEmpresaActivity.class);
        } else { //hay empresa
            if (null == hayGestor())
            {//no hay gestor
                lanzarActividad(RegistroEmpleadoActivity.class);
            }  //hay empresa y gestor
            //siguo en el login
        }

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //creamos este metodo para que el ActionBar(la flecha hacia atras) funcione bien
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        Intent intent = null;

        if (u.getRol()== Constantes.ROL_EMPLEADO ){

             intent = new Intent(this,MenuEmpleadoActivity.class);
             intent.putExtra("ID_EMPLEADO",u.getId_empleado());
            intent.putExtra("EMPLEADO",u);



        }else if(u.getRol()==Constantes.ROL_GESTOR ){

             intent = new Intent(this,MenuGestorActivity.class);
             intent.putExtra("ID_EMPLEADO",u.getId_empleado());
            intent.putExtra("EMPLEADO",u);


        }

        if( null != intent) {

            startActivity( intent);
        }
    }


    public void limpiarText(EditText ... array ) {//VARARGS

        for (EditText e : array) {

            e.setText("");
            e.clearFocus();

        }
    }

    public void creditos(View view) {

        Intent intent = new Intent(this, Creditos.class);
        startActivity(intent);
        finish();

    }
}

