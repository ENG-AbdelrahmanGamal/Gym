package com.example.gym.domain.repo

import com.example.gym.GymApplication
import com.example.gym.data.local.gym.GymDataBase
import com.example.gym.data.local.gym.model.LocalGymFavouriteState
import com.example.gym.data.local.gym.model.LocalGym
import com.example.gym.data.remote.gym.GymsApiService
import com.example.gym.domain.model.Gym
import com.example.gym.domain.usecase.GetSortedGymsUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GymRepo {

    private val apiService: GymsApiService=    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(GymsApiService.BASE_URL)
        .build()
        .create(GymsApiService::class.java)



    private var gymDao = GymDataBase.getDaoInstance(GymApplication.getApplicationContext())

    suspend fun toggleFavouriteGym(getId:Int,currentFavouriteState:Boolean)= withContext(Dispatchers.IO){
        gymDao.update(LocalGymFavouriteState(id=getId,isFavourite =currentFavouriteState))

        return@withContext  gymDao.getAllGym().map{Gym(it.id,it.name,it.place,it.is_open,it.isFavourite)}
    }

     suspend fun loadGym() = withContext(Dispatchers.IO) {

        try {
            updateData()
        } catch (e: Exception) {
            if(gymDao.getAllGym().isEmpty())
                throw Exception("No data was found ,try connect with the Internet")
        }
    }

     suspend fun updateData() {
        val gyms = apiService.getGymsList()
        val gymFavouriteList=gymDao.getFavouriteGym()

        gymDao.addAllGym(gyms.map { LocalGym(it.id,it.name,it.place,it.is_open) })
        gymDao.updateAll(gymFavouriteList.map{
            LocalGymFavouriteState(id = it.id)
        })
    }

    suspend fun getGym(): List<Gym> {
        return withContext(Dispatchers.IO){
            return@withContext gymDao.getAllGym().map {Gym(it.id,it.name,it.place,it.is_open,it.isFavourite)}
        }
    }

}