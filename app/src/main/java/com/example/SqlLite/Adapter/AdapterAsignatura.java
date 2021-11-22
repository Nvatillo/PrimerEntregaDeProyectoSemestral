package com.example.SqlLite.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.SqlLite.Objeto.AsignaturaDto;
import com.example.SqlLite.OperacionesCrud.Esquemas.AsignaturaEsquema;
import com.example.SqlLite.OperacionesCrud.OperacionesCRUD;
import com.example.actividadandroid.EditarAsignatura;
import com.example.actividadandroid.Intro;
import com.example.actividadandroid.R;

import java.util.ArrayList;

public class AdapterAsignatura extends RecyclerView.Adapter<AdapterAsignatura.AsignaturasHolder>{

    private ArrayList<AsignaturaDto> asignaturasDesplegar;


    @NonNull
    @Override
    public AdapterAsignatura.AsignaturasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardasignaturas,parent,false);
        AdapterAsignatura.AsignaturasHolder holder = new AdapterAsignatura.AsignaturasHolder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAsignatura.AsignaturasHolder holder, int position) {
        AsignaturaDto item = asignaturasDesplegar.get(position);


        holder.nombre.setText(item.getNombre());
        holder.rating.setRating(item.getRatingBar());
        holder.eliminar.setId(item.getId_asignatura());
        holder.editar.setId(item.getId_asignatura());


        holder.eliminar.setId(item.getId_asignatura());
        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String condicion = "ID_ASIGNATURA=?";
                String valores[] = {"" + item.getId_asignatura()};
                int cant_regs_eliminados = 0;

                OperacionesCRUD instancia = new OperacionesCRUD(view.getContext(),"BDPROGRAMA",null,2);
                cant_regs_eliminados = instancia.borrarRegistro(AsignaturaEsquema.Esquema.TABLE_NAME,condicion,valores);
                if (cant_regs_eliminados>0){
                    Toast.makeText(view.getContext(), "Asignatura eliminado", Toast.LENGTH_SHORT).show();
                    AdapterAsignatura.this.asignaturasDesplegar.remove(holder.getAdapterPosition());
                    AdapterAsignatura.this.notifyDataSetChanged();

                }else{
                    Toast.makeText(view.getContext(), "Error eliminado Asignatura", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.editar.setId(item.getId_asignatura());
        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editarAsignatura = new Intent(view.getContext(), EditarAsignatura.class);

                editarAsignatura.putExtra("id",item.getId_asignatura());
                editarAsignatura.putExtra("nombre",item.getNombre().toString());
                editarAsignatura.putExtra("rating",item.getRatingBar());


                view.getContext().startActivity(editarAsignatura);
            }
        });


    }

    @Override
    public int getItemCount() {
        return asignaturasDesplegar.size();
    }

    public  AdapterAsignatura(ArrayList<AsignaturaDto> asignaturasDesplegarrin){
        asignaturasDesplegar = asignaturasDesplegarrin;
    }

    public static class AsignaturasHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public RatingBar rating;
        public Button eliminar;
        public Button editar;


        public AsignaturasHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreAsignatura);
            rating = itemView.findViewById(R.id.ratingId);
            eliminar = itemView.findViewById(R.id.EliminarID);
            editar = itemView.findViewById(R.id.EditarId);

        }
    }
}
