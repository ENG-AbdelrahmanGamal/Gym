package com.example.gym.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.gym.model.remote.gym.GymsApiService
import com.example.gym.model.remote.gym.response.Gym
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsGymsViewModel (savedStateHandle: SavedStateHandle): ViewModel() {
    private var apiService: GymsApiService
    var state by mutableStateOf<Gym?>(null)

    private val handelError =
        CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace() }

    init {
        var retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://seniorstepse-commerce-default-rtdb.firebaseio.com/")
            .build()

        apiService = retrofit.create(GymsApiService::class.java)
        var gymId=savedStateHandle.get<Int>("gym_id")?:0
        getGymbbyId(gymId)
    }

    private fun getGymbbyId(int: Int) {
        viewModelScope.launch(handelError) {
            val gym = getGymFromRemote(int)
          state=gym
        }
    }

    private suspend fun getGymFromRemote(id: Int) =
        withContext(Dispatchers.IO) { apiService.getGym(id).values.first() }
}