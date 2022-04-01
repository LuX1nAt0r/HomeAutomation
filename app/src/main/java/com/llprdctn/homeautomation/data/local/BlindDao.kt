package com.llprdctn.homeautomation.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.llprdctn.homeautomation.data.local.entities.Blind
import kotlinx.coroutines.flow.Flow

@Dao
interface BlindDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlind(blind: Blind)

    @Query("SELECT * FROM blinds")
    fun getAllBlinds(): Flow<List<Blind>>


}