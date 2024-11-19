package com.example.ejercicio9as;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
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

    // Método para calcular la nota final y mostrar el resultado
    public static  void mostrarResultado(TextView textView, Context context, ImageView resultadoImagen) {
        // Calcula la nota final basada en el ArrayList respuestas
        int notaFinal = 0;
        for (Boolean respuesta : obtener.respuestas) {
            if (respuesta) {
                notaFinal++;
            }
        }

        String mensajeAprobado = context.getString(R.string.aprobado10, nombre); // Combina el string con la variable
        String mensajeAprobado2 = context.getString(R.string.aprobado, nombre); // Combina el string con la variable
        String mensajeSuspenso = context.getString(R.string.suspendido, nombre); // Combina el string con la variable

        // Muestra el mensaje basado en la nota final
        if (notaFinal == 5) {
            textView.setText(mensajeAprobado + notaFinal * 2);
            resultadoImagen.setImageResource(R.drawable.enhorabuena); // Imagen de excelencia

        } else if (notaFinal >= 4 && notaFinal>=3) {
            textView.setText(mensajeAprobado2 + notaFinal * 2);
            resultadoImagen.setImageResource(R.drawable.enhorabuena); // Imagen de excelencia

        } else {
            textView.setText(mensajeSuspenso+ notaFinal * 2);
            resultadoImagen.setImageResource(R.drawable.lo_sentimos); // Imagen de excelencia

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
