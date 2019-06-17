package edu.cftic.fichapp.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import edu.cftic.fichapp.R;

public class RegistroEmpresaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empresa);
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
}
