package com.llprdctn.homeautomation.repositories

import com.llprdctn.homeautomation.data.local.BlindDao
import com.llprdctn.homeautomation.data.remote.BlindsApi
import com.llprdctn.homeautomation.data.local.entities.Blind
import com.llprdctn.homeautomation.other.Resource
import com.llprdctn.homeautomation.other.networkBoundResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor(
    private val blindsApi: BlindsApi,
    private val blindDao: BlindDao
) {


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

                }

            },
            shouldFetch = {
                //TODO: Here
            }

        )
    }

}