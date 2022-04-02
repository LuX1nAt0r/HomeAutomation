package com.llprdctn.homeautomation.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blinds")
data class Blind(
    @PrimaryKey
    val id: String,
    val name: String,
    val currentLevel: Int
)
