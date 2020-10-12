package com.imamblek.petagram.restApi;

import com.imamblek.petagram.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IEndPointsApi {

    @GET(ConstantesRestApi.URL_GET_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();
}
