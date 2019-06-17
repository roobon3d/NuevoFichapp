package edu.cftic.fichapp.actividades;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.cftic.fichapp.R;
import edu.cftic.fichapp.bean.Programador;

public class AdapterCreditos extends RecyclerView.Adapter<CreditosViewHolder> {

    private final Context contexto;
    private ArrayList<Programador> datos;

    @NonNull
    @Override
    public CreditosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CreditosViewHolder creditosViewHolder = null;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.programador_layout,parent, false);

        creditosViewHolder = new CreditosViewHolder(itemView, contexto);

        return creditosViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CreditosViewHolder holder, int position) {

        Programador programador = datos.get(position);
        holder.cargarCreditosEnHolder(programador);

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
    public AdapterCreditos (ArrayList<Programador>programador, Context contexto){
        this.datos = programador;
        this.contexto = contexto;
    }
}
