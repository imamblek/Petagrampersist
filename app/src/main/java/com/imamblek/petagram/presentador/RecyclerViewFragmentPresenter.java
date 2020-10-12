package com.imamblek.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.imamblek.petagram.db.ConstructorMascotas;
import com.imamblek.petagram.pogo.Mascota;
import com.imamblek.petagram.restApi.IEndPointsApi;
import com.imamblek.petagram.restApi.adapter.RestApiAdapter;
import com.imamblek.petagram.restApi.model.MascotaResponse;
import com.imamblek.petagram.vistafragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerMascotas();
        obtenerMedia();
    }

    @Override
    public void obtenerMascotas() {
        //constructorMascotas = new ConstructorMascotas(context);
        //mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void obtenerMedia() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMedia = restApiAdapter.construyeGsonDeserializadorMedia();

        IEndPointsApi iEndPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMedia);
        Call<MascotaResponse> responseCall = iEndPointsApi.getRecentMedia();

        responseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, retrofit2.Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotaResponse.getMascotas();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo salio mal en la conexion", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });

    }


    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        //iRecyclerViewFragmentView.generarLinearLayoutVertical();
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
