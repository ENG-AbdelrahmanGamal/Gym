package com.example.gym.data.remote.gym

import androidx.room.Dao
import com.example.gym.data.remote.gym.response.RemoteGym
import retrofit2.http.GET
import retrofit2.http.Query
@Dao
interface GymsApiService {
    @GET("gyms.json")
   suspend fun getGymsList(): List<RemoteGym>
   @GET("gyms.json?orderBy=\"id\"")
   suspend fun getGym(@Query("equalTo") id:Int):Map<String,RemoteGym>
   companion object{
       const val BASE_URL="https://seniorstepse-commerce-default-rtdb.firebaseio.com/"

   }
}
