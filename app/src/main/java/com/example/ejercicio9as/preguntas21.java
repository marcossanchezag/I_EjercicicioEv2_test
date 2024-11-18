package com.example.ejercicio9as;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class preguntas21 extends AppCompatActivity {

    private Button boton21;
    private Button boton22;
    private Button boton23;
    private ImageButton atras;
    private ImageButton continuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preguntas21);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        boton21 = findViewById(R.id.boton21);
        boton22 = findViewById(R.id.boton22);
        boton23 = findViewById(R.id.boton23);

        atras = findViewById(R.id.atras51);
        continuar = findViewById(R.id.continuar51);

        TextView textView = findViewById(R.id.animo2);



        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(preguntas21.this, Preguntas1.class);
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.atras_continuar(preguntas21.this, preguntas3.class);
            }
        });



        boton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(false,boton22,boton21,boton23,textView,preguntas21.this);
            }
        });


        boton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(true,boton22,boton21,boton23,textView,preguntas21.this);

            }
        });


        boton23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtener.siguientePagina(false,boton22,boton21,boton23,textView,preguntas21.this);

            }
        });
    }
}