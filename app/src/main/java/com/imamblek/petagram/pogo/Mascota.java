package com.imamblek.petagram.pogo;

public class Mascota {
    private String id;
    private String fullnombre;
    private int huesos = 0;
    private String urlfoto;

    public Mascota(String fullnombre, int huesos, String urlfoto) {
        this.fullnombre = fullnombre;
        this.huesos = huesos;
        this.urlfoto = urlfoto;
    }

    public Mascota(String urlfoto, String fullnombre, int huesos) {
        this.urlfoto = urlfoto;
        this.fullnombre = fullnombre;
        this.huesos = huesos;
    }

    public Mascota(String urlfoto, int huesos) {
        this.urlfoto = urlfoto;
        this.huesos = huesos;
    }

    public Mascota(String fullnombre, String urlfoto) {
        this.fullnombre = fullnombre;
        this.urlfoto = urlfoto;
    }

    public Mascota() {

    }

    public Mascota(int cangrejo, int i) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullnombre() {
        return fullnombre;
    }

    public void setUsername(String fullnombre) {
        this.fullnombre = fullnombre;
    }

    public int getHuesos() {
        return huesos;
    }

    public void setHuesos(int huesos) {
        this.huesos = huesos;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }
}


