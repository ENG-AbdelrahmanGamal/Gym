package com.example.gym.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.GymState
import com.example.gym.domain.repo.GymRepo
import com.example.gym.domain.usecase.GetAllGymUsecase
import com.example.gym.domain.usecase.ToggleFavouriteStateUsecase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch


class GymViewModel(

) : ViewModel() {

   private var _state by mutableStateOf(GymState(gym = emptyList(), isLoading =true))
    val state:State<GymState>get()= derivedStateOf { _state }
    private var getAllGymusecase=GetAllGymUsecase()
    private var toggleFavouriteStateUsecase = ToggleFavouriteStateUsecase()
    private val handelError =
        CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace()
                _state   =_state.copy(
                    isLoading = false,
                    isError =throwable.message )

        }


    init {
        getGym()
    }

    private fun getGym() {
        viewModelScope.launch(handelError) {
            val receivedGym=getAllGymusecase()
            _state = _state.copy(gym=receivedGym, isLoading = false)
        }
    }


    fun taggleFavouriteState(gymId: Int) {
        val gyms = _state.gym.toMutableList()
        val itemIndex = gyms.indexOfFirst { it.id == gymId }
        viewModelScope.launch {
            val updateGymList=toggleFavouriteStateUsecase(gymId,gyms[itemIndex].isFavourite)
        _state=_state.copy(gym = updateGymList)
        }
    }

}





