package com.example.gym.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GymDetailsScreen() {
    val viewModel: DetailsGymsViewModel = viewModel()

    val item = viewModel.state


    item?.let {
        Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize().padding(10.dp)) {

            DefultIcon(
                icon = Icons.Filled.Face,
                contentDescription = "icon for this location",
                weight = Modifier.padding(bottom = 30.dp, top = 30.dp).size(200.dp)

            ){}
            GymDetails(
                gym = item,
                weight = Modifier.padding(bottom = 30.dp),
                horizontalAlignmentLine = Alignment.CenterHorizontally,
            )


            Text(
                text = if (item.is_open) "Gym is Open" else "Gym Closed this Moment",
                color = if (item.is_open) Color.Green else Color.Red
            )
        }
    }
}