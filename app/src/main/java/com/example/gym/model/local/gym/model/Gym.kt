package com.example.gym.model.local.gym.model



val listOfGym= listOf<Gym>(

    Gym(1,"world Gym","NasrCity-Cairo-Egypt"),
    Gym(2,"Musile Gym","Harm-Giza-Egypt"),
    Gym(3,"power Gym","6OctoberCity-Giza-Egypt"),

)



data class Gym(val id:Int ,val name:String,val place:String, var isFavourite: Boolean = false)
