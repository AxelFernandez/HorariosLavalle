package com.sistemas51.horarioslavalle.api;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HourService {

    @GET("api/")
    Call<String> version();

    @GET("api/download/")
    Call<String> download();


}
