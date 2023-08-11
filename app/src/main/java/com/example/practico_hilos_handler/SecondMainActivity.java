package com.example.practico_hilos_handler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class SecondMainActivity extends AppCompatActivity {
    String[] descriptions={
            "Crea una aplicación que descargue imágenes en segundo plano utilizando tanto Threads como Coroutines. Muestra las imágenes en una lista o cuadrícula cuando se descarguen.",
            "Crea una aplicación de chat simple en la que los mensajes enviados desde un dispositivo se muestren en otro dispositivo utilizando tanto Handlers como Coroutines para actualizar la interfaz de usuario.",
            "Crea una aplicación que envíe mensajes entre dos actividades utilizando Bundles en los intents para pasar datos, y además, utiliza Coroutines para realizar tareas asincrónicas.",
            "Crea una aplicación que muestre notificaciones periódicas utilizando tanto Handlers como Coroutines, y un servicio en segundo plano para mantener actualizado el contador de tiempo",
            "Crea una aplicación de cronómetro que permita a los usuarios iniciar, pausar y reiniciar el cronómetro utilizando tanto Handlers como Coroutines para realizar el seguimiento del tiempo transcurrido.",
            "Crea una aplicación que permita a los usuarios descargar archivos grandes y muestre el progreso de la descarga utilizando tanto Handlers como Executors para realizar la tarea de descarga.",
            "Crea una aplicación que administre una lista de tareas pendientes y permita al usuario agregar y eliminar tareas utilizando tanto Executors como Coroutines para manejar las tareas en segundo plano.",
            "Crea una aplicación que permita a los usuarios cargar varias imágenes y realice un procesamiento en paralelo utilizando tanto Executors como Coroutines para acelerar el procesamiento.",
            "Encuentra el numero mayor de en un arreglo de números enteros.",
            "Suma los primeros 'n' números naturales.",
            "Calcula el máximo común divisor (MCD) de dos números.",
            "Imprime una cadena al revés usando recursión.",

    };
    String[] titles= {
            "Descarga de Imágenes utilizando Threads y Coroutines",
            "Chat Simple con Handlers y Coroutines",
            "Envío de Mensajes entre Actividades con Bundles y Coroutines",
            "Notificaciones Periódicas con Handlers y Coroutines",
            "Cronómetro con Handlers y Coroutines",
            "Descarga de Archivos con Handlers y Executors",
            "Administrador de Tareas con Executors y Coroutines",
            "Procesamiento de Imágenes en Paralelo con Executors y Coroutines",
            "Recursividad"
    };
    Button btnBackToMenu;
    TextView txtTittle;
    LinearLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);
        main=findViewById(R.id.main);
        txtTittle = findViewById(R.id.txtTittle);
        btnBackToMenu = findViewById(R.id.btnBackToMenu);
        // 0 es el valor por defecto si no se encuentra "option"
        Intent intent = getIntent();
        int option = intent.getIntExtra("option", 0);
        txtTittle.setText("Ejercicio "+option);
        txtTittle.setTypeface(null, Typeface.BOLD);
        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initProyect(option);
    }
    public void initProyect(int option){
        switch (option) {
            case 1:
                title(option);
                description(option);
                break;
            case 2:
                title(option);
                description(option);
                break;
            case 3:
                title(option);
                description(option);
                break;
            case 4:
                title(option);
                description(option);
                break;
            case 5:
                title(option);
                description(option);
                break;
            case 6:
                title(option);
                description(option);
                break;
            case 7:
                title(option);
                description(option);
                break;
            case 8:
                title(option);
                description(option);
                break;
            case 9:
                title(option);
                description(option);
                break;
            case 10:
                title(9);
                description(option);
                break;
            case 11:
                title(9);
                description(option);
                break;
            case 12:
                title(9);
                description(option);
                break;
            default:
                // Manejar opción no válida si es necesario
                break;
        }
    }
    public void title(int t){
        TextView title=new TextView(this);
        title.setText(titles[t-1].toString());
        title.setTextSize(20);
        title.setTypeface(null, Typeface.BOLD);
        main.addView(title);
    }
    public void description(int d){
        TextView description=new TextView(this);
        description.setText(descriptions[d-1].toString());
        description.setTextSize(15);
        main.addView(description);
    }
}