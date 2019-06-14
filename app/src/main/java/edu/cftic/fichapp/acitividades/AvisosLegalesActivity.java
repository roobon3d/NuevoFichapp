package edu.cftic.fichapp.acitividades;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.util.Preferencias;

public class AvisosLegalesActivity extends AppCompatActivity {
    private boolean estado_barra = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos_legales);

        //Mensaje de bienvenida

        new DialogoSimple().show(getSupportFragmentManager(), "DialogoSimple");


        //Cargar el fichero HTML en un web view

        WebView wv = (WebView) findViewById(R.id.webView1);

        wv.loadUrl("file:///android_asset/aviso_legal.html");


    }




    public void mostrarAyuda(View view) {

        Intent intent_ayuda = new Intent (this,AyudaActivity.class);
        Preferencias.setPrimeraVez(this, false);
        startActivity(intent_ayuda);
        finish();


    }

}
