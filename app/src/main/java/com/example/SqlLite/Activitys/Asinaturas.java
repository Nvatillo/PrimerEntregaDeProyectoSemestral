package com.example.SqlLite.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.SqlLite.Adapter.AdapterAsignatura;
import com.example.SqlLite.Objeto.AsignaturaDto;
import com.example.SqlLite.OperacionesCrud.Esquemas.AsignaturaEsquema;
import com.example.SqlLite.OperacionesCrud.OperacionesCRUD;
import com.example.actividadandroid.CrearAsignatura;
import com.example.actividadandroid.R;

import java.util.ArrayList;
import java.util.List;

public class Asinaturas extends AppCompatActivity {

    private RecyclerView milista;
    private OperacionesCRUD instancia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asinaturas);
        instancia = new OperacionesCRUD(this,"BDPROGRAMA",null,2);


        String[] columnasAsignatura = AsignaturaEsquema.Esquema.ALLCOLUMNAS;
        String condicion = "";
        String[] valoresCondicion = {};

        List<ContentValues> asignaturasObtenidos = instancia.obtenerDatos(columnasAsignatura,condicion,valoresCondicion,AsignaturaEsquema.Esquema.TABLE_NAME);

        ArrayList<AsignaturaDto> listaAsignaturaDtos = new ArrayList<>();

        if (asignaturasObtenidos==null){
            Toast.makeText(this, "no se obtuvieron usuarios", Toast.LENGTH_SHORT).show();
        }else{
            for (int i = 0 ; i < asignaturasObtenidos.size();i++){
                ContentValues auxiliar = asignaturasObtenidos.get(i);
                AsignaturaDto nuevaAsignatura = new AsignaturaDto();
                for (String key : auxiliar.keySet()){
                    switch (key.toString()){
                        case AsignaturaEsquema.Esquema.ID:
                            nuevaAsignatura.setId_asignatura(Integer.parseInt(auxiliar.get(key).toString()));
                            break;
                        case AsignaturaEsquema.Esquema.NOMBRE:
                            nuevaAsignatura.setNombre(auxiliar.get(key).toString());
                            break;

                    }
                }

                listaAsignaturaDtos.add(nuevaAsignatura);
            }
        }

        milista = findViewById(R.id.miLista);
        milista.setHasFixedSize(true);
        LinearLayoutManager manejador = new LinearLayoutManager(this);
        AdapterAsignatura adaptador = new AdapterAsignatura(listaAsignaturaDtos);

        milista.setLayoutManager(manejador);
        milista.setAdapter(adaptador);
    }

    public void AgregarAsignatura(View v){
        Intent i = new Intent(this, CrearAsignatura.class);
        startActivity(i);
    }

}