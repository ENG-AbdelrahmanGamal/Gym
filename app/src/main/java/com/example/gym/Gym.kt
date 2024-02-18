package com.example.gym



val listOfGym= listOf<Gym>(

    Gym("world Gym","NasrCity-Cairo-Egypt"),
    Gym("Musile Gym","Harm-Giza-Egypt"),
    Gym("power Gym","6OctoberCity-Giza-Egypt"),

)



data class Gym(val name:String,val place:String)
