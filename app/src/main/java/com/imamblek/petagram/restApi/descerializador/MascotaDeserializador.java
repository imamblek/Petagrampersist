package com.imamblek.petagram.restApi.descerializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.imamblek.petagram.pogo.Mascota;
import com.imamblek.petagram.restApi.JsonKeys;
import com.imamblek.petagram.restApi.model.MascotaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {


    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarMascotaJson(mascotaResponseData));
        return mascotaResponse;
    }

    private ArrayList<Mascota> deserializarMascotaJson(JsonArray mascotaResponseData) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            JsonObject ownerJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.OWNER);
            String id = ownerJson.get(JsonKeys.USER_ID).getAsString();

            String username = mascotaResponseDataObject.get(JsonKeys.USER_NAME).getAsString();
            String urlfoto = mascotaResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();
            int likes = mascotaResponseDataObject.get(JsonKeys.MEDIA_LIKES).getAsInt();

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setUsername(username);
            mascotaActual.setUrlfoto(urlfoto);
            mascotaActual.setHuesos(likes);

            mascotas.add(mascotaActual);

        }
        return mascotas;
    }
}
