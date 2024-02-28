package com.example.gym.data.remote.gym.repo

import com.example.gym.data.local.gym.GymDataBase
import com.example.gym.data.remote.gym.GymsApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GymRepoImpl @Inject constructor(
    private val GymApi:GymsApiService,
    private val movieDatabase: GymDataBase) {


    suspend fun getGym(id: Int) {


    }

}