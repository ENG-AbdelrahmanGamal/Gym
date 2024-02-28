package com.example.gym.data.local.gym

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gym.data.local.gym.dao.GymDAO
import com.example.gym.data.local.gym.model.LocalGym
import com.example.gym.data.remote.gym.response.RemoteGym


@Database(entities = [LocalGym::class], version = 3, exportSchema = false)
abstract class GymDataBase :RoomDatabase(){

    abstract val gymDAO:GymDAO



    companion object {
        @Volatile
        private var daoInstance: GymDAO? = null
        fun provideGymDatabase(application: Context): GymDataBase {
            return Room.databaseBuilder(
                application,
                GymDataBase::class.java,

                "Gym_database"
            ).fallbackToDestructiveMigration()
            .build()
        }
            fun getDaoInstance(context: Context): GymDAO {
                synchronized(this){
                    if (daoInstance == null)
                        daoInstance = provideGymDatabase(context).gymDAO

                    return daoInstance as GymDAO
                }

            }
        }

}