package com.example.gym

import com.example.gym.domain.model.Gym

data class GymState(
    val gym:List<Gym>,
    val isLoading:Boolean,
    val isError:String?=null

)
