package edu.cftic.fichapp.actividades;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class DialogoSimple extends DialogFragment {


        public DialogoSimple() {
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return createSimpleDialog();
        }

        /**
         * Crea un diálogo de alerta sencillo
         * @return Nuevo diálogo
         */
        public AlertDialog createSimpleDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setTitle("FichApp")
                    .setMessage("¡Bienvenid@!")
                    .setPositiveButton("ACEPTAR",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Acciones
                                }
                            });
                    /*.setNegativeButton("CANCELAR",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });*/

            return builder.create();
        }
    }

