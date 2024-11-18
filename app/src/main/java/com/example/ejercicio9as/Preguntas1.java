package com.example.ejercicio9as;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Preguntas1 extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private Button boton3;

    private ImageButton atras;
    private ImageButton continuar;
    private ProgressBar progressBar1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas1);
        progressBar1 = findViewById(R.id.progressBar);

        progressBar1.setProgress(20);  // Establece el progreso al 20%




        Intent intent = getIntent();

        // Obtener el parámetro "palabra" que enviaste
        String nombre = obtener.getNombre();

        TextView textView = findViewById(R.id.animo1);


        boton1 = findViewById(R.id.boton1r);
        boton2 = findViewById(R.id.boton2r);
        boton3 = findViewById(R.id.boton3r);

         atras = findViewById(R.id.atras51);
         continuar = findViewById(R.id.continuar51);




        atras.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 obtener.atras_continuar(Preguntas1.this, MainActivity.class);
             }
         });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(Preguntas1.this, preguntas21.class);
            }
        });




        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(false,boton2,boton1,boton3,textView,Preguntas1.this);
            }
        });


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(true,boton2,boton1,boton3,textView,Preguntas1.this);

            }
        });


        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(false,boton2,boton1,boton3,textView,Preguntas1.this);

            }
        });







    }




}