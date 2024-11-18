package com.example.ejercicio9as;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class preguntas3 extends AppCompatActivity {
    private Button boton31;
    private Button boton32;
    private Button boton33;

    private ImageButton atras;
    private ImageButton continuar;

    private ProgressBar progressBar3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas3);

        boton31 = findViewById(R.id.boton31);
        boton32 = findViewById(R.id.boton32);
        boton33 = findViewById(R.id.boton33);

        atras = findViewById(R.id.atras51);
        continuar = findViewById(R.id.continuar51);

        progressBar3 = findViewById(R.id.progressBar3);

        progressBar3.setProgress(60);  // Establece el progreso al 60%

        TextView textView = findViewById(R.id.animo3);



        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(preguntas3.this, preguntas21.class);
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(preguntas3.this, preguntas4.class);
            }
        });



        boton31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    obtener.siguientePagina(false,boton33,boton32,boton31,textView,preguntas3.this);
                }
            });


        boton32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    obtener.siguientePagina(false,boton33,boton32,boton31,textView,preguntas3.this);

                }
            });


        boton33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    obtener.siguientePagina(true,boton33,boton32,boton31,textView,preguntas3.this);

                }
            });

    }
}