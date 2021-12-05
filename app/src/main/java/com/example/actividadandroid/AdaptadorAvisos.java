package com.example.actividadandroid;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdaptadorAvisos extends RecyclerView.Adapter<AdaptadorAvisos.AvisosHolder> {

    private ArrayList<Aviso> avisosDesplegar;
    FirebaseDatabase database;
    DatabaseReference reference;

    @NonNull
    @Override
    public AdaptadorAvisos.AvisosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.avisosprofesor,parent,false);
        AdaptadorAvisos.AvisosHolder holder = new AdaptadorAvisos.AvisosHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorAvisos.AvisosHolder holder, int position) {
        Aviso item = avisosDesplegar.get(position);

        holder.profesor.setText(item.getNombreProfesor());
        holder.avisosProfesor.setText(item.getAvisoProfesor());


        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseApp.initializeApp(view.getContext());
                database = FirebaseDatabase.getInstance();
                reference = database.getReference().child("avisos");

                reference.child(String.valueOf(item.getId_aviso())).removeValue();
                AdaptadorAvisos.this.avisosDesplegar.remove(holder.getAdapterPosition());
                AdaptadorAvisos.this.notifyDataSetChanged();
            }
        });

        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editarAviso = new Intent(view.getContext(),EditarAviso.class);

                editarAviso.putExtra("id",item.getId_aviso());
                editarAviso.putExtra("nombreProfesor",item.getNombreProfesor());
                editarAviso.putExtra("avisoProfesor",item.getAvisoProfesor());

                view.getContext().startActivity(editarAviso);
            }
        });

    }

    @Override
    public int getItemCount() {
        return avisosDesplegar.size();
    }

    public  AdaptadorAvisos(ArrayList<Aviso> asignaturasDesplegarrin){
        avisosDesplegar = asignaturasDesplegarrin;
    }

    public static class AvisosHolder extends RecyclerView.ViewHolder {

        public TextView profesor;
        public TextView avisosProfesor;
        public Button editar;
        public Button eliminar;

        public AvisosHolder(@NonNull View itemView) {
            super(itemView);
            profesor = itemView.findViewById(R.id.profedorId);
            avisosProfesor = itemView.findViewById(R.id.avisoProfesorId);
            eliminar = itemView.findViewById(R.id.borrarAviso);
            editar = itemView.findViewById(R.id.editarAviso);
        }
    }
}
