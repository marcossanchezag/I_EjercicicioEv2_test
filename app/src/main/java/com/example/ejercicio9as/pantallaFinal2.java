package com.example.ejercicio9as;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejercicio10.DatabaseHelper;

public class pantallaFinal2 extends AppCompatActivity {

    private ImageView resultadoImagen;
    private com.example.ejercicio10.DatabaseHelper dbHelper;


    private TextView textoFinal;

    private TextView textoGanador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_final2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        resultadoImagen = findViewById(R.id.resultadoImagen);
        textoGanador = findViewById(R.id.textView14);

        textoFinal = findViewById(R.id.textView19);
        obtener.mostrarResultado(textoFinal, pantallaFinal2.this,resultadoImagen);

        // Inicializar la base de datos
        dbHelper = new DatabaseHelper(this);

        // Obtener la mejor puntuación anterior
        int mejorPuntuacion = dbHelper.ObtenerMejorPuntuacion(obtener.getNombre().toString());
        // Verificar si es un nuevo récord
        if (obtener.NotaFinal() > mejorPuntuacion) {
            textoGanador.setText("¡Nuevo récord de " + obtener.getNombre().toString()+" !  Puntuación anterior: " + mejorPuntuacion);
            dbHelper.insertarJugadorEjemplo(obtener.getNombre().toString(), obtener.NotaFinal());
        } else {
            textoGanador.setText("Mejor puntuación anterior: " + mejorPuntuacion);
        }


    }


}