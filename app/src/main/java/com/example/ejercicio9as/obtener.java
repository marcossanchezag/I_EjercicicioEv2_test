package com.example.ejercicio9as;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class obtener {

    static ArrayList<Boolean> respuestas = new ArrayList<>(); // Lista para almacenar respuestas


    //obtener nombre
    private static String nombre;

    public static void setNombre(String n) {
        nombre = n;
    }

    public static String getNombre() {
        return nombre;
    }



//________________________________________________________________________________
//obtener nombre
//private static int contadorPagina =1;
//
//    public static int setNumPagina(int n) {
//        contadorPagina += n;
//        return contadorPagina;
//    }



//________________________________________________________________________________


    // obtener Respuesta correcta o incorrecta:
    private static boolean correcto;

    public static void setCorrecto(boolean n) {
        correcto = n;
        String nombre = obtener.nombre; // Obtener el nombre desde la clase obtener

    }



    public static boolean getCorrecto() {
        return correcto;
    }

//________________________________________________________________________________

    //Metodo para guardar si ha pulsado la respuesta correcta y cambiar color boton y los deshabilita
    public static void siguientePagina(Boolean esCorrecto, Button botonCorrecto,Button botonError1,Button botonError2, TextView textView, Context context) {
        obtener.setCorrecto(esCorrecto);  // Asegúrate de que 'obtener' esté definido y accesible
        int contador=0;
        contador++;
        if (esCorrecto == true &&contador<=1) {
            botonCorrecto.setBackgroundColor(botonCorrecto.getContext().getResources().getColor(R.color.verde)); // Cambia a verde
            botonError1.setEnabled(false);
            botonError2.setEnabled(false);
            botonCorrecto.setEnabled(false);

            String mensaje1 = context.getString(R.string.animo1, nombre); // Combina el string con la variable
            textView.setText(mensaje1); // Establece el texto en el TextView

            respuestas.add(esCorrecto);

        } else if (esCorrecto == false &&contador<=1) {
            botonCorrecto.setBackgroundColor(botonCorrecto.getContext().getResources().getColor(R.color.verde)); // Cambia a verde
            botonError1.setBackgroundColor(botonError1.getContext().getResources().getColor(R.color.rojo));
            botonError2.setBackgroundColor(botonError2.getContext().getResources().getColor(R.color.rojo));
            botonError1.setEnabled(false);
            botonError2.setEnabled(false);
            botonCorrecto.setEnabled(false);

            String mensaje2 = context.getString(R.string.animo2, nombre); // Combina el string con la variable
            textView.setText(mensaje2); // Establece el texto en el TextView
        }


    }



    //________________________________________________________________________________

    // pagina anterior
    public static void atras_continuar(Context context, Class<?> destinationClass) {
        Intent abrirPantalla = new Intent(context, destinationClass);
         context.startActivity(abrirPantalla);
    }
    //________________________________________________________________________________

    //numero de pregunta


}
