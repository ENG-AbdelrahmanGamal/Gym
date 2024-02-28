package com.example.gym.data.local.gym.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class LocalGymFavouriteState(

    @ColumnInfo("gym_id")
    @PrimaryKey
    val id :Int,
    val isFavourite:Boolean=false


)
