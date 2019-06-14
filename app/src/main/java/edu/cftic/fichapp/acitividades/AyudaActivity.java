package edu.cftic.fichapp.acitividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.util.Preferencias;

public class AyudaActivity extends AppCompatActivity {
    private boolean estado_barra = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Cargar el fichero HTML en el web view
        WebView wv = (WebView) findViewById(R.id.webView2);

        wv.loadUrl("file:///android_asset/texto_ayuda.html");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void esconderToolbar(View view) {


    if(estado_barra ) {
        getSupportActionBar().hide();
    }else {
        getSupportActionBar().show();
    }
    estado_barra = !estado_barra;
    }


    public void mostrarAvisos(View view){

        Intent intent = new Intent(this, AvisosLegalesActivity.class);
        startActivity(intent);

    }

    public void check(View view) {
        Preferencias.check(this, (CheckBox)findViewById(R.id.no_mostrar));
    }
}