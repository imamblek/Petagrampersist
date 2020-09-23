package com.imamblek.petagram.vistafragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imamblek.petagram.R;
import com.imamblek.petagram.adapter.MascotaAdaptador;
import com.imamblek.petagram.pogo.Mascota;
import com.imamblek.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.imamblek.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList <Mascota> mascotas;
    public RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this vista.vistafragment
        View v = inflater.inflate(R.layout.fragment_recicler_view, container, false);

        rvMascotas = ( RecyclerView) v.findViewById(R.id.rvMascotasFragment);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }




    /*public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.cangrejo, "Cangrejo", 0));
        mascotas.add(new Mascota(R.drawable.delfin, "Delfin", 0));
        mascotas.add(new Mascota(R.drawable.pulpo, "Pulpo", 0));
        mascotas.add(new Mascota(R.drawable.estrella, "Estrella", 0));
        mascotas.add(new Mascota(R.drawable.calamar, "Calamar", 0));
    }*/


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(linearLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}