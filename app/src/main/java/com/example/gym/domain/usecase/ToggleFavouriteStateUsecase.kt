package com.example.gym.domain.usecase

import com.example.gym.domain.model.Gym
import com.example.gym.domain.repo.GymRepo

class ToggleFavouriteStateUsecase() {

    private val repo=GymRepo()
    private val getSortedGymsUsecase=GetSortedGymsUsecase()


    suspend  operator fun invoke(id :Int,oldState:Boolean):List<Gym>{
        val newState=oldState.not()
         repo.toggleFavouriteGym(id,newState)
        return getSortedGymsUsecase()

    }

}