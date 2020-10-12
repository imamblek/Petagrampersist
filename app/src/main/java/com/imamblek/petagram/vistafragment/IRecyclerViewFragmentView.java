package com.imamblek.petagram.vistafragment;

import com.imamblek.petagram.adapter.MascotaAdaptador;
import com.imamblek.petagram.pogo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    //crear los mtodos para alojar las instrucciones

    void generarLinearLayoutVertical();

    void generarGridLayout();

    MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(MascotaAdaptador mascotaAdaptador);

}
