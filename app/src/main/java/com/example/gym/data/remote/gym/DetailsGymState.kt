package com.example.gym.data.remote.gym

import com.example.gym.domain.model.Gym

data class DetailsGymState(

    val gymById: Gym,
    var isLoading:Boolean,
    val isError:String?=null
)
