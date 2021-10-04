package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class HistorialCurso extends AppCompatActivity {

    private LinearLayout contenedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_curso);


        contenedor = findViewById(R.id.contenedor);

        // ESTO ES LA CARD
        View ramoMatematica = getLayoutInflater().inflate(R.layout.layoutcard,null);

        TextView nombreRamoM = ramoMatematica.findViewById(R.id.ramoNombre);
        RatingBar notaRamoM = ramoMatematica.findViewById(R.id.ratingBar);

        //Matematicas
        nombreRamoM.setText("Matematicas");
        notaRamoM.setRating(5);


        View ramoIngles = getLayoutInflater().inflate(R.layout.layoutcard,null);

        TextView nombreRamoI = ramoIngles.findViewById(R.id.ramoNombre);
        RatingBar notaRamoI = ramoIngles.findViewById(R.id.ratingBar);

        //Ingles
        nombreRamoI.setText("Ingles");
        notaRamoI.setRating(6);


        View ramoAndroid = getLayoutInflater().inflate(R.layout.layoutcard,null);

        TextView nombreRamoA = ramoAndroid.findViewById(R.id.ramoNombre);
        RatingBar notaRamoA = ramoAndroid.findViewById(R.id.ratingBar);

        //Android
        nombreRamoA.setText("Android");
        notaRamoA.setRating(7);

        contenedor.addView(ramoMatematica);
        contenedor.addView(ramoIngles);
        contenedor.addView(ramoAndroid);
    }

    public void volverMenu(View v){
        Intent intent = new Intent(this,Intro.class);
        startActivity(intent);
    }
}