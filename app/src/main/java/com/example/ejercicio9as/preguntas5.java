package com.example.ejercicio9as;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class preguntas5 extends AppCompatActivity {

    private Button boton51;
    private Button boton52;
    private Button boton53;
    private ImageButton atras;
    private ImageButton continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas5);

        boton51 = findViewById(R.id.boton51);
        boton52 = findViewById(R.id.boton52);
        boton53 = findViewById(R.id.boton53);

        atras = findViewById(R.id.atras51);
        continuar = findViewById(R.id.continuar51);

        TextView textView = findViewById(R.id.animo5);



        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(preguntas5.this, preguntas4.class);
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(preguntas5.this, PantallaFinal1.class);
            }
        });

        boton51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(false,boton52,boton51,boton53,textView,preguntas5.this);
            }
        });


        boton52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(true,boton52,boton51,boton53,textView,preguntas5.this);

            }
        });


        boton53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(false,boton52,boton51,boton53,textView,preguntas5.this);

            }
        });

    }
}