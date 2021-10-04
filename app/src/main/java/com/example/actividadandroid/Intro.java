package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Intro extends AppCompatActivity {
    private ImageView credencial;
    private ProgressBar avanzeCarrera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        credencial = findViewById(R.id.credencial);
        avanzeCarrera = findViewById(R.id.progressBar);
        avanzeCarrera.setProgress(3);
        avanzeCarrera.setMax(4);
    }

    public void credencial(View v){
        Intent intent = new Intent(this,Credencial.class);
        startActivity(intent);
    }

    public void historialCurso(View v){
        Intent intent = new Intent(this,HistorialCurso.class);
        startActivity(intent);
    }

    public void volverLogin(View v){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}