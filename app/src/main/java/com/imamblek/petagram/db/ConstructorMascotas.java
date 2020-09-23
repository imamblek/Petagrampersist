package com.imamblek.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.imamblek.petagram.R;
import com.imamblek.petagram.pogo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    private static final int Hueso = 1;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

       BaseDatos db = new BaseDatos(context);
       insertarMisMascotas(db);
       return db.obtenerTodasLasMascotas();
    }

    public void insertarMisMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Cangrejo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.cangrejo);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Delfin");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.delfin);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Pulpo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.pulpo);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Estrella");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.estrella);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Calamar");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.calamar);

        db.insertarMascota(contentValues);
    }

    public void darHuesoMascota(Mascota mascota) {

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_QTY_HUESOS, Hueso);
        db.insertarHuesosMascota(contentValues);
    }

    public int obtenerHuesosMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerHuesosMascota(mascota);
    }

}
