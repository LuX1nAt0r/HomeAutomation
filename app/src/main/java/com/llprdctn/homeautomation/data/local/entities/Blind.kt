package com.llprdctn.homeautomation.data.local.entities

import androidx.room.Entity

@Entity(tableName = "blinds")
data class Blind(
    val id: String,
    val name: String,
    val currentLevel: Int
)
