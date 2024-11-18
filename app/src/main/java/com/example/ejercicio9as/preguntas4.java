
package com.example.ejercicio9as;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class preguntas4 extends AppCompatActivity {
    private Button boton41;
    private Button boton42;
    private Button boton43;
    private ImageButton atras;
    private ImageButton continuar;

    private ProgressBar progressBar4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas4);

        boton41 = findViewById(R.id.boton41);
        boton42 = findViewById(R.id.boton42);
        boton43 = findViewById(R.id.boton43);

        atras = findViewById(R.id.atras51);
        continuar = findViewById(R.id.continuar51);

        progressBar4 = findViewById(R.id.progressBar4);

        progressBar4.setProgress(80);  // Establece el progreso al 80%

        TextView textView = findViewById(R.id.animo4);



        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(preguntas4.this, preguntas3.class);
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(preguntas4.this, preguntas5.class);
            }
        });

        boton41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(false,boton42,boton41,boton43,textView,preguntas4.this);
            }
        });


        boton42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(true,boton42,boton41,boton43,textView,preguntas4.this);

            }
        });


        boton43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(false,boton42,boton41,boton43,textView,preguntas4.this);

            }
        });


    }
}