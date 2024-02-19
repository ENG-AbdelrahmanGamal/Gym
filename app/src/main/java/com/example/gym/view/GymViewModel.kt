package com.example.gym.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.model.remote.gym.GymsApiService
import com.example.gym.model.remote.gym.response.Gym
import com.example.gym.model.remote.gym.response.listOfGym
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GymViewModel(
    private val stateHandel:SavedStateHandle

): ViewModel() {


    var state by mutableStateOf(emptyList<Gym>())
    private var apiService :GymsApiService

    init {
        var retrofit:Retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://seniorstepse-commerce-default-rtdb.firebaseio.com/")
            .build()

        apiService=retrofit.create(GymsApiService::class.java)
    }

      fun getGym(){
        viewModelScope.launch{
            apiService.getGymsList()?.let{ gymsList->
        state= gymsList.restoreSelectedGymes()

            }

        }
    }
    fun taggleFavouriteState(gymId:Int)
    {
        val gyms = state.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        gyms[itemIndex] = gyms[itemIndex].copy(isFavourite =! gyms[itemIndex].isFavourite)
        storeSlectedGyms(gyms[itemIndex])
        state = gyms
    }

    private  fun storeSlectedGyms(gym: Gym)
    {
        val saveHandleList=stateHandel.get<List<Int>?>(fav_IDS).orEmpty().toMutableList()
        if(gym.isFavourite)
            saveHandleList.add(gym.id)
        else
            stateHandel[fav_IDS]=saveHandleList
    }
private fun List<Gym>.restoreSelectedGymes():List<Gym>{
        stateHandel.get<List<Int>?>(fav_IDS)?.let{ saveIDS->
          saveIDS.forEach{gymid->
              this.find{ it.id==gymid}?.isFavourite=true
              }
          }
        return this
        }

companion object {
    const val fav_IDS="favouriteGymsIDS"
}
}