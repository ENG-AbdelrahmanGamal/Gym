package com.example.gym.model.remote.gym

import com.example.gym.model.remote.gym.response.Gym
import retrofit2.Call
import retrofit2.http.GET

interface GymsApiService {



    @GET("gyms.json")
   suspend fun getGymsList(): List<Gym>


   companion object{

       const val BASE_URL="https://seniorstepse-commerce-default-rtdb.firebaseio.com/"

   }
}
