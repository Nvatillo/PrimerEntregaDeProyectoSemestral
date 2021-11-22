package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private TextView usuario;
    private TextView pass;
    private Spinner perfil;
    private String perfilSeleccionado;
    private ProgressBar barra;
    private Button logearse;
    private TextView mostrar;
    private ImageView googlemaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        usuario = findViewById(R.id.usuarioText);
        pass = findViewById(R.id.passText);
        perfil = findViewById(R.id.spinnerPerfil);
        barra = findViewById(R.id.mostrarValidar);
        logearse = findViewById(R.id.Logearse);
        mostrar = findViewById(R.id.mostrar);
        googlemaps = findViewById(R.id.googlemaps);

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

        logearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarUsuario asyntask = new ValidarUsuario(
                        Login.this,
                        barra,
                        logearse,
                        mostrar);

                asyntask.execute(usuario.getText(),pass.getText());
                entrar();
            }

        });



    }

    public void mapsGoogle(View v){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void entrar(){
            Intent intent = new Intent(this, Intro.class);
            intent.putExtra("usuario",usuario.getText().toString());
            startActivity(intent);
    }

    public void volver(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}