package com.example.gym.domain.model

import androidx.room.Entity

data class Gym(

    val id: Int,
    val name: String,
    val place: String,
    val is_open: Boolean,
    val isFavourite: Boolean=false

)
