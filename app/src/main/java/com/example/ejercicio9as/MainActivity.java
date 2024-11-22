package com.example.ejercicio9as;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private TextView textoNombre;
    private Button iniciarPreguntas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNombre = findViewById(R.id.introducirNombre);
        iniciarPreguntas = findViewById(R.id.button); // Asegúrate de tener un botón en el XML con este ID

        iniciarPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textoNombre.getText().toString().isEmpty()){
                    textoNombre.setHintTextColor(Color.RED);
                    Toasty.error(MainActivity.this, "¡Debes introducir un nombre!").show();
                }else{


                    obtener.setNombre(textoNombre.getText().toString()); // Guarda el nombre
                    Intent intent = new Intent(MainActivity.this, Preguntas1.class);
                    intent.putExtra("palabra", obtener.getNombre());

                    startActivity(intent); // Lanza la actividad Preguntas1
                 }
            }
        });
    }}