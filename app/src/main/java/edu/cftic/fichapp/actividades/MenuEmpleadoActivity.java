package edu.cftic.fichapp.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.bean.Empleado;
import edu.cftic.fichapp.util.Constantes;

public class MenuEmpleadoActivity extends AppCompatActivity {

   private Empleado u ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_empleado);
        u = (Empleado) getIntent().getExtras().get(Constantes.EMPLEADO);
    }
}
