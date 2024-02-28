package com.example.gym.data.local.gym.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.gym.data.local.gym.model.LocalGymFavouriteState
import com.example.gym.data.local.gym.model.LocalGym


@Dao
interface GymDAO {


    @Query("select * from LocalGym")
    suspend fun getAllGym(): List<LocalGym>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun  addAllGym(remoteGym:List<LocalGym>)


   @Update(entity = LocalGym::class)
   suspend fun update(localGymFavouriteState: LocalGymFavouriteState)

   @Query("select * from LocalGym where isFavourite=1")
   suspend fun getFavouriteGym():List<LocalGym>

    @Update(entity = LocalGym::class)
    suspend fun updateAll(gymState:List<LocalGymFavouriteState>)
}