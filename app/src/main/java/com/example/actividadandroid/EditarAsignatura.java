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

public class EditarAsignatura extends AppCompatActivity {

    private int asignaturaId=0;
    private TextView nombreAsignatura;
    private TextView ratingAsignatura;

    private String nombreAsignaturaExtras;
    private String ratingAsignaturaExtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_asignatura);

        nombreAsignatura = findViewById(R.id.nombreAsignaturaEditar);
        ratingAsignatura = findViewById(R.id.ratingAsignatura);


        if (null != this.getIntent()) {
            if (null != this.getIntent().getExtras()) {
                Bundle parametrosEntrada = this.getIntent().getExtras();

                asignaturaId = parametrosEntrada.getInt("id");
                nombreAsignaturaExtras = parametrosEntrada.getString("nombre");
                ratingAsignaturaExtras = parametrosEntrada.getString("rating");


            }
        }
    }

    public void editarUsuario(View v){
        OperacionesCRUD instancia = new OperacionesCRUD(this,"BDPROGRAMA",null,2);
        ContentValues datosNuevosusuario = new ContentValues();
        datosNuevosusuario.put("NOMBRE",nombreAsignatura.getText().toString());
        datosNuevosusuario.put("RATING_ASIGNATURA",ratingAsignatura.getText().toString());



        String codicion = "ID_ASIGNATURA=?";
        String valores[] = {asignaturaId+""};
        int cantidad_actualizados = 0;
        cantidad_actualizados = instancia.actualizarRegistro(datosNuevosusuario,
                codicion,valores, AsignaturaEsquema.Esquema.TABLE_NAME);

        if(cantidad_actualizados > 0){
            Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Error actualizando usuario", Toast.LENGTH_LONG).show();
        }

    }
    public void volverActividad(View v){
        Intent i = new Intent(this, Asinaturas.class);
        startActivity(i);
    }
}