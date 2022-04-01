package com.llprdctn.homeautomation.di

import android.content.Context
import androidx.room.Room
import com.llprdctn.homeautomation.data.remote.BlindsApi
import com.llprdctn.homeautomation.data.local.HomeAutomationDatabase
import com.llprdctn.homeautomation.other.Constants.BASE_URL
import com.llprdctn.homeautomation.other.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, HomeAutomationDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideBlindsDao(db: HomeAutomationDatabase) = db.blindsDao()

    @Singleton
    @Provides
    fun provideHomeAutomationApi(): BlindsApi {
        val client = OkHttpClient.Builder()
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(BlindsApi::class.java)

    }


}