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
import edu.cftic.fichapp.util.Constantes;
import edu.cftic.fichapp.util.Preferencias;

public class AyudaActivity extends AppCompatActivity {
    private boolean estado_barra = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        //Cargar el fichero HTML en el web view
        WebView wv = (WebView) findViewById(R.id.webView2);

        wv.loadUrl("file:///android_asset/texto_ayuda.html");

    }



    public void check(View view) {
        Preferencias.check(this, (CheckBox)findViewById(R.id.no_mostrar));
    }

    public void aceptarAyuda(View view) {
        Log.d(Constantes.TAG_APP, "Transitando a Login desde Ayuda");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}