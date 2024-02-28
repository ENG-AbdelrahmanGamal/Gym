package com.example.gym.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gym.data.remote.gym.DetailsGymState
import com.example.gym.domain.model.Gym
import com.example.gym.domain.repo.DetailsRepo
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class DetailsGymsViewModel (savedStateHandle: SavedStateHandle): ViewModel() {

    private var _state by
    mutableStateOf(DetailsGymState(
        gymById = Gym(1,"","",false,false),
        isLoading = true))
   val state:State<DetailsGymState>get()= derivedStateOf{_state }
    val detailsRepo=DetailsRepo()
    private val handelError =
        CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace()
             _state=_state.copy(isLoading = false, isError = throwable.message)
        }

    init {
        var gymId=savedStateHandle.get<Int>("gym_id")?:0
        getGymbbyId(gymId)
    }

    private fun getGymbbyId(int: Int) {
        viewModelScope.launch(handelError) {
            val gym =detailsRepo.getGymFromRemote(int)

            _state= _state.copy(gymById = gym ,isLoading =false)
        }

        }
    }

