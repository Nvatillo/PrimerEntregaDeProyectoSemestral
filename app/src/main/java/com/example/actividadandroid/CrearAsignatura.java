package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.SqlLite.Activitys.Asinaturas;
import com.example.SqlLite.OperacionesCrud.Esquemas.AsignaturaEsquema;
import com.example.SqlLite.OperacionesCrud.OperacionesCRUD;

public class CrearAsignatura extends AppCompatActivity {

    private TextView asignaturaNombre;
    private TextView ratingAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_asignatura);

        asignaturaNombre = findViewById(R.id.nombreAsignaturaCrear);
        ratingAsignatura = findViewById(R.id.ratingAsignaturaCrear);
    }

    public void insertAsignatura( View v){
        OperacionesCRUD instancia = new OperacionesCRUD(this,"BDPROGRAMA",null,2);
        ContentValues datosAsignatura = new ContentValues();

        datosAsignatura.put(AsignaturaEsquema.Esquema.NOMBRE,asignaturaNombre.getText().toString());
        datosAsignatura.put(AsignaturaEsquema.Esquema.RATING,Integer.parseInt(ratingAsignatura.getText().toString()));

        long id_insertada= instancia.insertTabla(datosAsignatura,AsignaturaEsquema.Esquema.TABLE_NAME);


        Toast.makeText(this, "id insertado "+id_insertada, Toast.LENGTH_SHORT).show();

    }

    public void volverAsignatura(View v){
        Intent i = new Intent(this, Asinaturas.class);
        startActivity(i);
    }
}