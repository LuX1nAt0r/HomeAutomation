package com.llprdctn.homeautomation.data

import com.llprdctn.homeautomation.data.entities.Blind
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface BlindsApi {

    @GET("/getCurrentStates")
    suspend fun getCurrentStates(): Response<List<Blind>>
}