package com.example.gym.di

import android.app.Application
import androidx.room.Room
import com.example.gym.data.local.gym.GymDataBase
import com.example.gym.data.remote.gym.GymsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModules {

    @Provides
    @Singleton
fun  provideGymApiService() :GymsApiService{
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(GymsApiService.BASE_URL)
        .build()
        .create(GymsApiService::class.java)

}

    @Provides
    @Singleton
    fun provideGymDatabase(application: Application): GymDataBase {
        return Room.databaseBuilder(
            application,
            GymDataBase::class.java,
            "Gym_database").build()
    }
}