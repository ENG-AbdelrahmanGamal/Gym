package com.example.gym.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gym.ui.theme.GYMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                GYMTheme {
                    GymAround()

                }



        }
    }
}

@Composable
private fun GymAround(){

    val navController= rememberNavController()

        NavHost(navController = navController, startDestination = "gyms" ){
            composable(route="gyms"){
                GymsScreen{id->
                navController.navigate("gyms/$id")

            }}
            composable(route = "gyms/{gym_id}",
                arguments = listOf(navArgument("gym_id"){type= NavType.IntType})

                ){
                GymDetailsScreen()}
        }

}





