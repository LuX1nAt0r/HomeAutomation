package com.llprdctn.homeautomation.data.remote

import com.llprdctn.homeautomation.data.local.entities.Blind
import com.llprdctn.homeautomation.data.remote.responses.SimpleResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BlindsApi {

    @GET("/getCurrentStates")
    suspend fun getCurrentStates(): Response<List<Blind>>


    @POST("/updateCurrentStates")
    suspend fun updateCurrentStates(@Body blind: Blind): Response<ResponseBody>
}