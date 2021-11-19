package com.sistemas51.horarioslavalle.api

import retrofit2.Call
import retrofit2.http.GET

interface HourService {
    @GET("api/")
    fun version(): Call<String?>?

    @GET("api/download/")
     fun download(): Call<String?>?

    @GET("api/download/")
    suspend fun downloadNew(): String
}
