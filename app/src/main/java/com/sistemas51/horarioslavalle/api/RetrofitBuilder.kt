package com.sistemas51.horarioslavalle.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitBuilder {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://horarioslavalle.com.ar/") // change this in Gradle files
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
    }

    fun buildService(): HourService {
        return getRetrofit().create(HourService::class.java)
    }

}
