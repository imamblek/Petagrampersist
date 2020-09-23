package com.imamblek.petagram.vistafragment;

import com.imamblek.petagram.adapter.MascotaAdaptador;
import com.imamblek.petagram.pogo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    //crear los mtodos para alojar las instrucciones

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
