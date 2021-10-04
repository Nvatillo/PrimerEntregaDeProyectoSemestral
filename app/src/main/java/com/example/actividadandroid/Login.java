package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private TextView usuario;
    private TextView pass;
    private Spinner perfil;
    private String perfilSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        usuario = findViewById(R.id.usuarioText);
        pass = findViewById(R.id.passText);
        perfil = findViewById(R.id.spinnerPerfil);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.perfiles, android.R.layout.simple_spinner_item);

        perfil.setAdapter(adapter);

        perfil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                perfilSeleccionado = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void entrar(View v){
        if (usuario.getText().toString().equals("f.gajardo")
                && pass.getText().toString().equals("123456")
                && perfilSeleccionado.equals("Estudiante")) {
            Intent intent = new Intent(this, Intro.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Ops ocurrio un error", Toast.LENGTH_SHORT).show();
        }
    }

    public void volver(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}