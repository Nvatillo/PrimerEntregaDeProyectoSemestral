package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class AgregarAviso extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;

    private EditText nombreProfesor,avisoProfesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_aviso);


        nombreProfesor = findViewById(R.id.nombreProfesorid);
        avisoProfesor = findViewById(R.id.avisoProfesorId);


        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("avisos");
    }


    public void inserAviso(View v){
        try {
            Aviso aviso = new Aviso();

            String id_registro = UUID.randomUUID().toString();
            aviso.setId_aviso(id_registro);
            aviso.setNombreProfesor(nombreProfesor.getText().toString());
            aviso.setAvisoProfesor(avisoProfesor.getText().toString());


            reference.child(id_registro).setValue(aviso);
            Toast.makeText(this, "Aviso Insertado", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void listaAvisos(View v){
        Intent i = new Intent(this,ListaAvisos.class);
        startActivity(i);
    }
}