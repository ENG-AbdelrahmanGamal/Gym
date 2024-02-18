package com.example.gym.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gym.model.local.gym.model.listOfGym


class GymViewModel: ViewModel() {
    var state by mutableStateOf(getGym())
  private  fun getGym()= listOfGym
    fun taggleFavouriteState(gymId:Int)
    {
        val gyms = state.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        gyms[itemIndex] = gyms[itemIndex].copy(isFavourite =! gyms[itemIndex].isFavourite)
        state = gyms
    }


}