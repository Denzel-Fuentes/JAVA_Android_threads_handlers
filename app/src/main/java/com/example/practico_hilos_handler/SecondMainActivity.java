package com.example.practico_hilos_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;


import android.os.Message;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


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
    LinearLayout section;
    Component component;
    Handler handler;
    int option=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);
        handler=new Handler(Looper.getMainLooper());
        txtTittle = findViewById(R.id.txtTittle);
        btnBackToMenu = findViewById(R.id.btnBackToMenu);
        section = findViewById(R.id.layoutComponent);
        String message=null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            message = bundle.getString("message");
            option= bundle.getInt("option");
        }
        txtTittle.setText("Ejercicio "+option);
        txtTittle.setTypeface(null, Typeface.BOLD);
        initProyect(option);
        if(message!=null && option==3){
            final String mensaje=message;
            handler.post(new Runnable() {
                int time=0;
                @Override
                public void run() {
                    if(time==3){
                        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
                    } else if (time<=3) {
                        time++;
                        handler.postDelayed(this,1000);
                    }

                }
            });
        }
        btnBackToMenu.setOnClickListener(view -> finish());
    }
    public void initProyect(int option){
        component = new Component(section);
        switch (option) {
            case 1:
                title(option);
                description(option);
                component.addEditText("input1");
                component.addEditText("input2");
                component.addButton("btn1","Descargar",v->ej1());
                break;
            case 2:
                title(option);
                description(option);
                component.addButton("btn2","Iniciar Chat",view -> ej2());
                break;
            case 3:
                title(option);
                description(option);
                component.addEditText("txt1");
                component.addButton("btn3","Enviar Mensaje",view -> ej3());
                break;
            case 4:
                title(option);
                description(option);
                activityTime();
                component.addButton("bnt4","Iniciar Notificaciones",view -> ej4());
                break;
            case 5:
                title(option);
                description(option);
                Ej5_cronometro cronometro = new Ej5_cronometro();
                component.addTextView("txtTiempo","");
                component.addButton("btnDetener","Detener",v->cronometro.detener());
                component.addButton("btnIniciar","Iniciar",v->cronometro.Comenzar());
                component.addButton("btnReiniciar","Reiniciar",v->cronometro.reiniciar());
                break;
            case 6:
                title(option);
                description(option);
                component.addEditText("input1");
                component.addButton("","Descargar",v->ej6());
                break;
            case 7:
                title(option);
                description(option);
                Ej7_task ej7_tasks = new Ej7_task();
                component.addButton("btn7","Agregar",v->ej7_tasks.addTask());
                component.addButton("btn8","Eliminar",v->ej7_tasks.removetask());
                break;
            case 8:
                title(option);
                description(option);
                ImageView imageView = new ImageView(section.getContext());
                imageView.setImageResource(R.drawable.image1);
                section.addView(imageView);
                component.addButton("btn8","Procesar",v->ej8());
                break;
            case 9:
                title(option);
                description(option);
                component.addEditText("input9");
                component.addButton("btn","Calcular Max",v->ej9());
                break;
            case 10:
                title(9);
                description(option);
                component.addEditText("input10");
                component.addButton("btn","Sumar",v->ej10());
                break;
            case 11:
                title(9);
                description(option);
                component.addEditText("txt11a",true);
                component.addEditText("txt11b",true);
                component.addButton("btn11","MCD",view -> ej11());
                break;
            case 12:
                title(9);
                description(option);
                component.addEditText("txt12");
                component.addButton("btn12","Invertir",view -> ej12());
                break;
            default:
                // Manejar opción no válida si es necesario
                break;
        }
        component.render();
    }
    public void title(int t){
        TextView title=new TextView(this);
        title.setText(titles[t-1]);
        title.setTextSize(20);
        title.setTypeface(null, Typeface.BOLD);
        section.addView(title);
    }
    public void description(int d){
        TextView description=new TextView(this);
        description.setText(descriptions[d-1]);
        description.setTextSize(15);
        section.addView(description);
    }
    public void activityTime(){
        TextView time=new TextView(this);
        time.post(new Runnable() {
            int seconds=0;
            @Override
            public void run() {
                time.setText("Tiempo transcurrido: "+seconds);
                time.postDelayed(this,1000);
                seconds++;
            }
        });
        section.addView(time);
    }

    public void ej1(){
        /*
        Esto seria la forma de hacerlo con Handlers y Runnables
        Runnable runnable = new Runnable() {
        TextView t = new TextView(getApplicationContext());
        int porcentaje = 0;

            @Override
            public void run() {
                if (porcentaje <= 100) {
                section.removeView(t);
                t.setText("Descargando Imagen: " + porcentaje + "%");
                section.addView(t);
                porcentaje += 25;
                handler.postDelayed(this, 1000);
                } else {
                    section.removeView(t);
                }
            }
        };
        handler.post(runnable);*/
        new Thread(new Runnable() {
            TextView t=new TextView(getApplicationContext());
            int porcentaje=0;
            @Override
            public void run() {
                while (porcentaje<=100) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            section.removeView(t);
                            t.setText("Descargando Imagen: " + porcentaje + "%");
                            section.addView(t);
                            porcentaje+=25;
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        section.removeView(t);
                        ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setImageResource(R.drawable.ic_launcher_background); // R.drawable.my_image es el ID de la imagen en los recursos
                        imageView.setPadding(0,20,0,20);
                        section.addView(imageView);
                    }
                });

            }
        }).start();
    }
    public void ej2(){
        String[] conversation = {
                "Patito Juan \n¡Hola! ¿Cómo estás?",
                "Patito Miguel \n ¡Hola! Estoy bien, ¿y tú?",
                "Patito Juan \nTambién estoy bien, gracias.",
                "Patito Miguel \n ¿Qué has estado haciendo hoy?",
                "Patito Juan \nHe estado trabajando en un proyecto de programación.",
                "Patito Miguel \n ¡Eso suena interesante! Yo fui al gimnasio esta mañana.",
                "Patito Juan \n¡Genial! Mantenerse activo es importante.",
                "Patito Miguel \n Sí, definitivamente. ¡Hablemos luego!",
                "Patito Juan \nClaro, ¡hablamos luego! ¡Adiós!"
        };

        List<TextView> textViews=new ArrayList<>();
        for(int i=0;i<9;i++){
            TextView t=new TextView(this);
            t.setId(i);
            t.setText(conversation[i]);
            t.setPadding(0,20,0,20);
            if(i%2!=0){
                t.setGravity(Gravity.END);
            }
            textViews.add(t);
        }
        Runnable runnable=new Runnable() {
            int quantity=0;
            LinearLayout layout = new LinearLayout(getApplicationContext());
            @Override
            public void run() {
                layout.setOrientation(LinearLayout.VERTICAL);
                section.removeView(layout);
                if(quantity<textViews.size()){
                    layout.addView(textViews.get(quantity));
                    quantity++;
                }else{
                    layout.removeAllViews();
                    quantity=0;
                }
                section.addView(layout);
                handler.postDelayed(this,1500);
            }
        };
        handler.post(runnable);
    }
    public void ej3(){
        EditText editText  = (EditText) component.getViewById("txt1");
        Intent intent = new Intent(SecondMainActivity.this, MainActivity.class);
        intent.putExtra("message",editText.getText().toString());
        startActivity(intent);
    }
    public void ej4(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(isFinishing()==false){
                    handler.postDelayed(this,3000);
                    Notification.showHeadUpNotification(getApplicationContext(), "Título de la Notificación", "Contenido de la notificación");
                }
            }
        });
    }
    class Ej5_cronometro{
        private int minutos , segundos,horas;
        private boolean isRunning;
        private Handler handler;
        private Runnable runnable;
        Ej5_cronometro(){this.minutos = 0;this.horas = 0;this.segundos =0;this.handler = new Handler();this.isRunning =false;}
        private TextView txtTiempo;
        public void detener(){
            this.txtTiempo = (TextView) component.getViewById("txtTiempo");
            if (isRunning) {
                handler.removeCallbacks(runnable);
                //elapsedTime = System.currentTimeMillis() - startTime;
                isRunning = false;
            }
        }
        public void Comenzar(){
            this.txtTiempo = (TextView) component.getViewById("txtTiempo");
            if (!isRunning){
                isRunning = true;
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (segundos == 59) {
                            segundos = 0;
                            if (minutos == 59) {
                                minutos = 0;
                                horas++;
                            } else {
                                minutos++;
                            }
                        } else {
                            segundos++;
                        }
                        actualizarTiempo(horas,minutos,segundos);
                        handler.postDelayed(this, 1000);
                    }
                };
                handler.postDelayed(runnable, 0);
            }
        }
        public void reiniciar(){
            this.txtTiempo = (TextView) component.getViewById("txtTiempo");
            if (!isRunning) {
                actualizarTiempo(0,0,0);
            }
        }
        private void actualizarTiempo(int horas , int minutos, int segundos) {
            final String timeText = String.format("%02d:%02d:%02d",horas,  minutos, segundos);
            txtTiempo.post(new Runnable() {
                @Override
                public void run() {
                    txtTiempo.setText(timeText);
                }
            });
        }
    }
    public void ej6(){
        /**
         * usuarios descargar archivos grandes y muestre el progreso de la
         * descarga utilizando tanto Handlers como Executors para realizar
         * la tarea de descarga.*/
        ExecutorService executor;
        EditText input1 = (EditText) component.getViewById("input1");
        TextView txt = component.addTextView(null,"1");
        final int size =Integer.parseInt(input1.getText().toString());
        executor = Executors.newFixedThreadPool(1);
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                if (msg.what == 1) {
                    txt.setText("Porcentaje: "+msg.arg1+"%  Progreso: "+msg.arg2 + " Estado: Descargado ✅ ");
                }else {
                    txt.setText("Porcentaje: "+msg.arg1+"%  Progreso: "+msg.arg2 + " Estado: Descargando.... ");
                }
                return true;
            }

        });
        executor.execute((new Runnable() {
            int progress;
            @Override
            public void run() {
                while (progress < size){
                    progress++;
                    int percentage = (progress*100)/size;
                    Message message = new Message();
                    message.arg1 = percentage;
                    message.arg2 = progress;
                    if(progress == size){
                        message.what = 1;
                    }else {message.what =0;}

                    handler.sendMessage(message);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }));
    }
    class Ej7_task{
        private ExecutorService executor;
        private int numTask=0,numTaskcompleted = 0;
        private
        Ej7_task(){
            this.executor = Executors.newSingleThreadExecutor();
        }
        public void addTask(){
            numTask++;
            if (numTask == 1){
                component.addTextView(null, "Tarea en ejecucion");
            }else {
                component.addTextView(null, "Tarea Pendiente....");
            }

            if(numTask ==1){
                this.executeTasks();
            }
        }
        public void executeTasks(){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                   while (true){

                           if (numTask >1){
                               updateView();
                           }
                           try {
                               Thread.sleep(3000); // Simulación de 1 segundo de ejecución
                           } catch (InterruptedException e) {
                               Thread.currentThread().interrupt();
                               return;
                           }
                       if (numTask >0){
                           updateViewTaskCompleted();
                       }
                   }
                }
            });
        }
        public void removetask(){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (numTask>=-1)component.deleteAllComponents("txt",1);
                }
            });
            numTask--;
        }
        public void updateViewTaskCompleted(){
            final  int c  = numTask;
            numTaskcompleted++;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    component.deleteAllComponents("txt",c);
                    component.addTextView(null,"Tarea Completada");
                }
            });
            numTask--;
        }
        public void updateView(){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < numTask ; i++) {
                        component.addTextView(null, "Tarea Pendiente....");
                    }
                }
            });
        }
    }
    public void ej8(){
        component.addTextView(null,"Procesando Imagen .....");
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(()->{
            try {
                Thread.sleep(3000);
                section.post(() -> {
                    component.deleteAllComponents("txt",1);
                    ImageView imageView = new ImageView(section.getContext());
                    imageView.setImageResource(R.drawable.image);
                    // Crear un objeto de parámetros para establecer el margen
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    // Establecer el margen superior de 10 píxeles
                    layoutParams.setMargins(100, 10, 0, 0);
                    imageView.setLayoutParams(layoutParams);
                    section.addView(imageView);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    public void ej9(){
        EditText editText = (EditText) component.getViewById("input9");
        //Creamos el objeto recursividad
        Recursividad recursividad = new Recursividad();
        //Ingresamos los datos que utilizaremos al hacer la recursin
        recursividad.setText(editText.getText().toString());
        //le pasasmo a service la recursividad
        service(recursividad);
    }
    public void ej10(){
        EditText editText = (EditText) component.getViewById("input10");
        //Creamos el objeto recursividad
        Recursividad recursividad = new Recursividad();
        //Ingresamos los datos que utilizaremos al hacer la recursin
        recursividad.setNumber(Integer.parseInt(editText.getText().toString()));
        //le pasasmo a service la recursividad
        service(recursividad);
    }
    public void ej11(){
        EditText editText=(EditText) component.getViewById("txt11a");
        EditText editText2=(EditText) component.getViewById("txt11b");
        Recursividad recursividad=new Recursividad();
        recursividad.setNumber(Integer.parseInt(editText.getText().toString()));
        recursividad.setNumbertwo(Integer.parseInt(editText2.getText().toString()));
        service(recursividad);
    }
    public void ej12(){
        Recursividad recursividad=new Recursividad();
        EditText editText= (EditText) component.getViewById("txt12");
        recursividad.setText(editText.getText().toString());
        service(recursividad);
    }
    public void service(Recursividad instance){
        ExecutorService service= Executors.newSingleThreadExecutor();
        Future<Recursividad.Functions> result=service.submit(instance);
        handle(result);
    }
    public void handle(Future<Recursividad.Functions> future){
        handler.post(new Runnable() {
            TextView textView=new TextView(getApplicationContext());
            String text="";
            @Override
            public void run() {
                try {
                    Recursividad.Functions responsive=future.get();
                    switch (option){
                        case 9:
                            text = String.valueOf(responsive.getMaxNumberArray());
                            break;
                        case 10:
                            text = String.valueOf(responsive.getSumNumberNatural());
                            break;
                        case 11:
                            text=String.valueOf(responsive.getCalculeMCD());
                            break;
                        case 12:
                            text=responsive.getInvertText();
                            break;
                    }
                    String result=text.isEmpty()?"No se ingreso nada":"Resultado: "+text;
                    textView.setText(result);
                    section.addView(textView);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}