package com.example.gym.model.remote.gym

import com.example.gym.model.remote.gym.response.Gym
import retrofit2.http.GET
import retrofit2.http.Query

interface GymsApiService {

    @GET("gyms.json")
   suspend fun getGymsList(): List<Gym>


   @GET("gyms.json?orderBy=\"id\"")
   suspend fun getGym(@Query("equalTo") id:Int):Map<String,Gym>
   companion object{

       const val BASE_URL="https://seniorstepse-commerce-default-rtdb.firebaseio.com/"

   }
}
