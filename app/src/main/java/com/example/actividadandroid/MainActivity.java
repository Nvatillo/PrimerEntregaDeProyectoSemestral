package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.SqlLite.OperacionesCrud.Esquemas.AsignaturaEsquema;
import com.example.SqlLite.OperacionesCrud.OperacionesCRUD;

public class MainActivity extends AppCompatActivity {

    private Button siguienteActividad;
    private SensorManager manejadorSensores;
    private Sensor intanciaSensorAcelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siguienteActividad = findViewById(R.id.irAlLogin);
        manejadorSensores = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        intanciaSensorAcelerometro = manejadorSensores.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (intanciaSensorAcelerometro == null){
            System.out.println("No existe el sensor");
            finish();
        }


    }
    private int contadorMovimientos =0;
    private SensorEventListener eventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            float posicionEnx = sensorEvent.values[0];
            float posicionEnY = sensorEvent.values[1];
            System.out.println("Aceleracion en Y "+ posicionEnx);
            System.out.println("Aceleracion en X "+posicionEnY);
            System.out.println("Aceleracion en Z "+sensorEvent.values[2]);

            if (posicionEnx <= 4 && contadorMovimientos == 0){
                contadorMovimientos++;
                System.out.println("se movio el dispositivo der");
            }else if (posicionEnx > 4 && contadorMovimientos ==1){
                contadorMovimientos++;
                System.out.println("se movio el dispositivo iz");

            }
            if (contadorMovimientos == 2 ){
                Intent i = new Intent(MainActivity.this,AcelerometroActivity.class);
                startActivity(i);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
    @Override
    protected void onPause() {
        manejadorSensores.unregisterListener(eventListener);
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        manejadorSensores.registerListener(eventListener,intanciaSensorAcelerometro,SensorManager.SENSOR_DELAY_NORMAL);
        super.onPostResume();
    }

    public void irAlLogin(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }




    public void social(View v) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "https://www.facebook.com/SantoTomasST/");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void noticias(View v) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "https://twitter.com/SantoTomas_ST");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void contacto(View v) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "https://www.santotomas.cl/cont_aulas_virtuales/contacto-andres-prueba/?mobile=FALSE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}