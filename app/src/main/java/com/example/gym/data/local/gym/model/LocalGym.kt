package com.example.gym.data.local.gym.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "LocalGym")
data class LocalGym(
    @PrimaryKey
    @ColumnInfo(name = "gym_id")
    val id: Int,
    @ColumnInfo(name = "gym_name")
    val name: String,
    @ColumnInfo(name = "gym_location")
    val place: String,
    @ColumnInfo(name = "is_open")
    val is_open: Boolean,
   val isFavourite:Boolean=false


)
