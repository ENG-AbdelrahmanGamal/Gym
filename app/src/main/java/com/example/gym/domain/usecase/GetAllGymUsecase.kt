package com.example.gym.domain.usecase

import com.example.gym.domain.model.Gym
import com.example.gym.domain.repo.GymRepo

class GetAllGymUsecase {
private val gymRepo=GymRepo()
    private val getSortedGymsUsecase=GetSortedGymsUsecase()


    public suspend  operator fun invoke():List<Gym>{
         gymRepo.loadGym()
        return getSortedGymsUsecase()
    }

}