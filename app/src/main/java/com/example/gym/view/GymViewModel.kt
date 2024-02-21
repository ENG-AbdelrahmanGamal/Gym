package com.example.gym.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.model.remote.gym.GymsApiService
import com.example.gym.model.remote.gym.response.Gym
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GymViewModel(
    private val stateHandel:SavedStateHandle

): ViewModel() {


    var state by mutableStateOf(emptyList<Gym>())
    private var apiService :GymsApiService
private lateinit var gymsList :List<Gym>
  private val handelError= CoroutineExceptionHandler{ _,throwable->throwable.printStackTrace()}

 private val job= Job()
    val scope= CoroutineScope(context = job+Dispatchers.IO)
    init {
        var retrofit:Retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://seniorstepse-commerce-default-rtdb.firebaseio.com/")
            .build()

        apiService=retrofit.create(GymsApiService::class.java)


        getGym()
    }

     private  fun getGym(){
        scope.launch(handelError){
                val gyms= getGymFromRemote()
                withContext(Dispatchers.Main) {
                    state = gyms.restoreSelectedGymes()

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
private suspend fun getGymFromRemote()= withContext(Dispatchers.IO){apiService.getGymsList()}
companion object {
    const val fav_IDS="favouriteGymsIDS"
}

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}





