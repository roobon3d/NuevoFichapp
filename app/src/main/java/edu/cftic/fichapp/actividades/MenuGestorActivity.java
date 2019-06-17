package edu.cftic.fichapp.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.bean.Empleado;
import edu.cftic.fichapp.util.Constantes;

import static edu.cftic.fichapp.util.Constantes.EMPLEADO;

public class MenuGestorActivity extends AppCompatActivity {

    private Empleado u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gestor);
        u = (Empleado) getIntent().getExtras().get(Constantes.EMPLEADO);


    }

    public void editarEmpleadoPulsado(View view) {



       Intent intent = new Intent(this,RegistroEmpleadoActivity.class);
        intent.putExtra("ID_EMPLEADO",u.getId_empleado());
        intent.putExtra("EMPLEADO",u);

    }

    public void editarEmpresaPulsado(View view) {
    }
}
