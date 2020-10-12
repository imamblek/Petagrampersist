package com.imamblek.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imamblek.petagram.R;
import com.imamblek.petagram.pogo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{
//esta es la coleccion decalada del la clase interna.

    ArrayList<Mascota> mascotas;
    Activity activity;
    @Override
    public void onBindViewHolder( final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);//obtiene el objeto iterando todas sus partes
        //mascotaViewHolder.imgFotoCV.setImageResource(mascota.getUrlfoto());
        Picasso.with(activity)
                .load(mascota.getUrlfoto())
                .placeholder(R.drawable.icons8_crash_bandicoot_48)
                .into(mascotaViewHolder.imgFotoCV);
        mascotaViewHolder.tvNombreCV.setText(mascota.getFullnombre());
        mascotaViewHolder.tvQtyHuesosCV.setText(String.valueOf(mascota.getHuesos()));
        /*
        mascotaViewHolder.bntDarHueso.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(activity ,"Diste like a "+ mascota.getFullnombre(),Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darHuesoMascota(mascota);
                mascotaViewHolder.tvQtyHuesosCV.setText(String.valueOf(constructorMascotas.obtenerHuesosMascota(mascota)));


            }
        });

         */

    }


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;

    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //le dara vida (inflar) a nuestro Layout CardView al asociarlo cn el view en el Layout.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_petagram, parent, false);
        return new MascotaViewHolder(v);
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        // se llaman los metodos del la clase madre RecliclerView.
        //declarar todos los views del cardView llamandoles con igual ids. ahora son objetos.
        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvQtyHuesosCV;
        private ImageButton bntDarHueso;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            // asocio cada objeto declarado cn su respectivo view en el XLM usando casting y sus Ids.
            //al usar los mismo nombres que los identificadores se hca mas facil asociarlos.
            imgFotoCV = itemView.findViewById(R.id.imgFotoCVgrid);
            tvNombreCV = itemView.findViewById(R.id.tvNombreCV);
            tvQtyHuesosCV = itemView.findViewById(R.id.tvQtyHuesosCV);
            bntDarHueso = itemView.findViewById(R.id.btnDarHueso);


        }
    }

    @Override
    public int getItemCount() {//cantidad de elementos que contine mi lista
        return mascotas.size(); // mascotas .size es la cantidad de elementos que contiene la lista de mascotas
    }


}
