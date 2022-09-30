package com.empresaurios.petfriend.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.empresaurios.petfriend.InfMascotas;
import com.empresaurios.petfriend.R;
import com.empresaurios.petfriend.entidades.Mascotas;

import java.util.ArrayList;

public class ListaMascotasAdapter extends RecyclerView.Adapter<ListaMascotasAdapter.MascotaViewHolder> {

    ArrayList<Mascotas> listaMascotas;

    public ListaMascotasAdapter(ArrayList<Mascotas> listaMascotas){
        this.listaMascotas = listaMascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_mascota, null,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {

        holder.viewNombre.setText(listaMascotas.get(position).getNombre());
        holder.viewRaza.setText(listaMascotas.get(position).getRaza());
        holder.viewPeso.setText(listaMascotas.get(position).getPeso());
        holder.viewEdad.setText(listaMascotas.get(position).getEdad());


    }

    @Override
    public int getItemCount() {
        System.out.println(listaMascotas.size());
        return listaMascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewRaza,viewPeso, viewEdad;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.card_nombre);
            viewRaza = itemView.findViewById(R.id.card_raza);
            viewPeso = itemView.findViewById(R.id.card_peso);
            viewEdad = itemView.findViewById(R.id.card_edad);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, InfMascotas.class);
                    intent.putExtra("ID", listaMascotas.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });

        }
    }

}
