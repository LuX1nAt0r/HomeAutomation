package com.llprdctn.homeautomation.repositories

import com.llprdctn.homeautomation.data.BlindsApi
import com.llprdctn.homeautomation.data.entities.Blind
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor(
    private val blindsApi: BlindsApi
) {


    suspend fun getCurrentStates(): Flow<List<Blind>> {
        return blindsApi.getCurrentStates()
    }

}