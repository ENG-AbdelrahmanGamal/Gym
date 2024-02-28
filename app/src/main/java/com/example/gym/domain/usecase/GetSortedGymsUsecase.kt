package com.example.gym.domain.usecase

import com.example.gym.domain.model.Gym
import com.example.gym.domain.repo.GymRepo

class GetSortedGymsUsecase {
    private val repo = GymRepo()
    suspend operator fun invoke(): List<Gym> {
        return repo.getGym().sortedBy { it.name }
    }
}