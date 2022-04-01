package com.llprdctn.homeautomation.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.llprdctn.homeautomation.data.local.entities.Blind


@Database(
    entities = [Blind::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class HomeAutomationDatabase : RoomDatabase() {
    abstract fun blindsDao(): BlindDao
}