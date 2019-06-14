package edu.cftic.fichapp.acitividades;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.bean.Programador;

public class Creditos extends AppCompatActivity {

    private RecyclerView recView;

    private ArrayList<Programador> datos;

    private AdapterCreditos adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creeditos);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Uri uri = Uri.parse(
                "android.resource://"
                        + getPackageName()
                        + "/"
                        + R.raw.programadores
        );

        // Display the raw resource uri in text view
        Log.d("MIAPP", "URI of the image : \n" + uri.toString());
        try {
            InputStream ins = getResources().openRawResource(R.raw.programadores);

            InputStreamReader br = new InputStreamReader(ins, "UTF-8");
            Gson gson = new Gson();

            final Type tipoEnvoltorioEmpleado = new TypeToken<ArrayList<Programador>>() {
            }.getType();
            datos = gson.fromJson(br, tipoEnvoltorioEmpleado);
            Log.d("MIAPP", "tamaño de datos" + datos.size());
            recView = (RecyclerView) findViewById(R.id.RecView);
            recView.setHasFixedSize(true); //mejora el rendimiento, es aconsejable ponerlo

            Collections.shuffle(datos); //hace que el orden en el que salen las filas sea aleatorio cada vez que carga la aplicacion

            adaptador = new AdapterCreditos(datos, this);

            recView.setAdapter(adaptador);

            recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            recView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        } catch (Exception e) {
            Log.e( this.getClass().getCanonicalName(), "Error al procesar los datos de los creditos.",e);
        }
        ImageView cas= (ImageView) findViewById(R.id.imageViewLogoCas); //txt is object of TextView
        cas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.cas-training.com/"));
                startActivity(browserIntent);
            }
        });
        TextView txt= (TextView) findViewById(R.id.textViewAccionFormativa); //txt is object of TextView
        txt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://cftic.centrosdeformacion.empleo.madrid.org"));
                startActivity(browserIntent);
            }
        });
    }

    public void clickGithub(View view) {
        Uri webpage = Uri.parse((String) view.getTag());
        OpenWebPage(webpage);
    }

    private void OpenWebPage(Uri webpage) {
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        String pregunta = "Con que app quieres continuar";
        Intent chooser = Intent.createChooser(intent, pregunta);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public void clickLinkedin (View view){
        if( view.getVisibility() == View.VISIBLE) {
            Uri webpage = Uri.parse((String) view.getTag());
            OpenWebPage(webpage);
        }
    }
}
