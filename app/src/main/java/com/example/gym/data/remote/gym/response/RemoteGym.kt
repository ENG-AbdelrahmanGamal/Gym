package com.example.gym.data.remote.gym.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Gym")
data class RemoteGym(
    @SerializedName("id")
    val id: Int,
    @SerializedName("gym_name")
    val name: String,
    @SerializedName("gym_location")
    val place: String,
    @SerializedName("is_open")
    val is_open: Boolean,

) {
}
//
//gym_location":"20 El-Gihad,Mit Akaba, Agouza, Giza Governorate 3754204, Egypt",
// "gym_name":"UpTown Gym",
// "id":0,
// "is_open":true