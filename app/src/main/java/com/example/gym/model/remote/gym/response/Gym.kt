package com.example.gym.model.remote.gym.response

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class Gym(
    @SerializedName("id")
    val id: Int,
    @SerializedName("gym_name")
    val name: String,
    @SerializedName("gym_location")
    val place: String,
    @SerializedName("is_open")
    val is_open: Boolean,

    var isFavourite: Boolean = false

)
//
//gym_location":"20 El-Gihad,Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
// "gym_name":"UpTown Gym",
// "id":0,
// "is_open":true