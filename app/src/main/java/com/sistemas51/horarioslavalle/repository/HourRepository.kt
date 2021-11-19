package com.sistemas51.horarioslavalle.repository

import com.sistemas51.horarioslavalle.api.HourService

class HourRepository(private val apiService: HourService) {


    suspend fun getHours() = apiService.downloadNew()


}