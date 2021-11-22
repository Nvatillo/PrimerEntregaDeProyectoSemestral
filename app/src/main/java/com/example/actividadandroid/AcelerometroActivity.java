package com.example.actividadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcelerometroActivity extends AppCompatActivity {

    private Button botonEmergencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        botonEmergencia = findViewById(R.id.btnEmergencias);

        botonEmergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + "133"));
                if (i.resolveActivity(getPackageManager())!=null){
                    startActivity(i);
                }
            }
        });
    }
}