package com.llprdctn.homeautomation.data.remote

import com.llprdctn.homeautomation.data.local.entities.Blind
import retrofit2.Response
import retrofit2.http.GET

interface BlindsApi {

    @GET("/getCurrentStates")
    suspend fun getCurrentStates(): Response<List<Blind>>
}