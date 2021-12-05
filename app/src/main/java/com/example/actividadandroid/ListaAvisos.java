package com.example.actividadandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListaAvisos extends AppCompatActivity {


    private RecyclerView recycler;
    private AdaptadorAvisos adaptador;
    private ArrayList<Aviso> data;

    FirebaseDatabase miBd;
    DatabaseReference referencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_avisos);

        FirebaseApp.initializeApp(this);

        miBd = FirebaseDatabase.getInstance();
        referencia = miBd.getReference().child("avisos");

        recycler = findViewById(R.id.miLista);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));


        data = new ArrayList<>();
        adaptador = new AdaptadorAvisos(data);
        recycler.setAdapter(adaptador);

        referencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data.clear();

                if (snapshot.exists()){
                    for (DataSnapshot auxliar:snapshot.getChildren()){
                        Aviso objeto = auxliar.getValue(Aviso.class);
                        data.add(objeto);
                    }

                    adaptador.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}