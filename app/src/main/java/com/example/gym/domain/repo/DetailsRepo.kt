package com.example.gym.domain.repo

import com.example.gym.data.remote.gym.GymsApiService
import com.example.gym.domain.model.Gym
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsRepo {

    private var apiService: GymsApiService= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(GymsApiService.BASE_URL)
        .build()
        .create(GymsApiService::class.java)


      suspend fun getGymFromRemote(id: Int) =
            withContext(Dispatchers.IO) { apiService.getGym(id).values.first().let {
                Gym(id=it.id, name = it.name, place = it.place,is_open =it.is_open
            ) } }
}
