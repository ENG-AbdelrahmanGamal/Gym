package com.example.gym.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import com.example.gym.view.GymsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (horizontalAlignment = Alignment.CenterHorizontally){
               GymsScreen()
            }


  println("add commit from Experiment branch")
            println("add commit from Experiment branch")
            println("add commit for change 3")

        }
    }
}





