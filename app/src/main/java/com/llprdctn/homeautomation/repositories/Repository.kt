package com.llprdctn.homeautomation.repositories

import android.app.Application
import com.llprdctn.homeautomation.data.local.BlindDao
import com.llprdctn.homeautomation.data.remote.BlindsApi
import com.llprdctn.homeautomation.data.local.entities.Blind
import com.llprdctn.homeautomation.other.Resource
import com.llprdctn.homeautomation.other.checkForInternetConnection
import com.llprdctn.homeautomation.other.networkBoundResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor(
    private val blindsApi: BlindsApi,
    private val blindDao: BlindDao,
    private val context: Application
) {


    suspend fun insertBlind(blind: Blind) {
        val response = try {
            blindsApi.updateCurrentStates()
        }// TODO: HERE---------------------------------------------------------------
    }




    suspend fun insertBlinds(blinds: List<Blind>) {
        blinds.forEach{ insertBlind(it)}
    }


    fun getCurrentBlindsState(): Flow<Resource<List<Blind>>> {
        return networkBoundResource(
            query = {
                blindDao.getAllBlinds()
            },
            fetch = {
                blindsApi.getCurrentStates()
            },
            saveFetchResult = { response ->
                response.body()?.let {
                    insertBlinds(it.onEach {  })
                }

            },
            shouldFetch = {
                checkForInternetConnection(context)
            }

        )
    }

}