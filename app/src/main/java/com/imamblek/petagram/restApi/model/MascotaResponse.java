package com.imamblek.petagram.restApi.model;

import com.imamblek.petagram.pogo.Mascota;

import java.util.ArrayList;

public class MascotaResponse {
    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
