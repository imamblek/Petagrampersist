package com.imamblek.petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imamblek.petagram.restApi.ConstantesRestApi;
import com.imamblek.petagram.restApi.IEndPointsApi;
import com.imamblek.petagram.restApi.descerializador.MascotaDeserializador;
import com.imamblek.petagram.restApi.model.MascotaResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public IEndPointsApi establecerConexionRestApiInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IEndPointsApi.class);
    }

    public Gson construyeGsonDeserializadorMedia() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }
}
