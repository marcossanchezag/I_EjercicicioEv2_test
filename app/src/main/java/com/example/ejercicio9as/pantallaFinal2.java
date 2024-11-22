package com.example.ejercicio9as;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class pantallaFinal2 extends AppCompatActivity {

    private ImageView resultadoImagen;
    private DatabaseHelper dbHelper;
    private Button botonVolver;
    private TextView textoFinal;
    private TextView textoGanador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_final2);

        resultadoImagen = findViewById(R.id.resultadoImagen);
        textoGanador = findViewById(R.id.textView14);
        botonVolver = findViewById(R.id.botonVolver);
        textoFinal = findViewById(R.id.textView19);
        obtener.mostrarResultado(textoFinal, pantallaFinal2.this, resultadoImagen);

        // Inicializar la base de datos
        dbHelper = new DatabaseHelper(this);

        // Obtener la mejor puntuación anterior
        String nombreJugador = obtener.getNombre();
        Log.d("Nombre",nombreJugador);
        int mejorPuntuacion = dbHelper.obtenerMejorPuntuacion(nombreJugador);
        Log.d("puntuacion",mejorPuntuacion+"");
        Log.d("nota",obtener.NotaFinal()+"");




        // Verificar si es un nuevo récord
        if (obtener.NotaFinal() > mejorPuntuacion) {
            textoGanador.setText("¡Nuevo récord de " + nombreJugador + "! Puntuación anterior: " + mejorPuntuacion);
            dbHelper.insertarJugadorEjemplo(nombreJugador, obtener.NotaFinal());
        } else {
            textoGanador.setText("Mejor puntuación anterior de " + nombreJugador + ": " + mejorPuntuacion);
        }

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(pantallaFinal2.this, MainActivity.class);
                obtener.respuestas.clear(); // Vacia la lista de respuestas
            }
        });
    }
}
