package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Credencial extends AppCompatActivity {

    private Button volverMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credencial);

        volverMenu = findViewById(R.id.volverIntro);
    }

    public void volverIntro(View v){
        Intent intent = new Intent(this, Intro.class);
        startActivity(intent);
    }
}