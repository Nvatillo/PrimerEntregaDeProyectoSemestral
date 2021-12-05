package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.SqlLite.Activitys.Asinaturas;

public class Intro extends AppCompatActivity {
    private ImageView credencial;
    private ProgressBar avanzeCarrera;
    private TextView nombreEstudianteText;
    private TextView porcent;
    private ProgressBar mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Bundle parametros = this.getIntent().getExtras();
        String nombreEstudiante = parametros.getString("usuario");
        nombreEstudianteText = findViewById(R.id.nombreEstudianteId);
        nombreEstudianteText.setText(nombreEstudiante);
        credencial = findViewById(R.id.credencial);
        avanzeCarrera = findViewById(R.id.progressBar);
        porcent = findViewById(R.id.porcientanId);
        avanzeCarrera.setProgress(3);
        avanzeCarrera.setMax(4);
        avanzeCarrera.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                porcent.setText("%90");
                return true;
            }
        });
    }

    public void credencial(View v){
        Intent intent = new Intent(this,Credencial.class);
        startActivity(intent);
    }

    public void historialCurso(View v){
        Intent intent = new Intent(this, Asinaturas.class);
        startActivity(intent);
    }

    public void volverLogin(View v){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    public void verAvisos(View v){
        Intent intent = new Intent(this,AgregarAviso.class);
        startActivity(intent);
    }
}