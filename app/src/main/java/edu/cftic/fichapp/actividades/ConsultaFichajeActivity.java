package edu.cftic.fichapp.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import edu.cftic.fichapp.R;

public class ConsultaFichajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_fichaje);
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

    public void añadirFichajeClick(View view) {
    }
}
