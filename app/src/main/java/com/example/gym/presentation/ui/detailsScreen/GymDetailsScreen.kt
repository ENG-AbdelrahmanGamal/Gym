package com.example.gym.presentation.ui.detailsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gym.presentation.viewModel.DetailsGymsViewModel
import com.example.gym.presentation.ui.DefultIcon
import com.example.gym.presentation.ui.GymDetails

@Composable
fun GymDetailsScreen() {
    val viewModel: DetailsGymsViewModel = viewModel()

    val state = viewModel.state.value

    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .padding(10.dp))
        {

            DefultIcon(
                icon = Icons.Filled.Face,
                contentDescription = "icon for this location",
                weight = Modifier
                    .padding(bottom = 30.dp, top = 30.dp)
                    .size(200.dp)

            ) {

                state.copy(gymById = state.gymById, isLoading = false)

            }
            val gym =  state.copy(gymById=state.gymById,isLoading = false)
            GymDetails(

                gym = gym.gymById,
                weight = Modifier.padding(bottom = 30.dp),
                horizontalAlignmentLine = Alignment.CenterHorizontally,
            )

            Text(
                modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                text = if (state.gymById.is_open) "Gym is Open" else "Gym Closed this Moment",
                color = if (state.gymById.is_open) Color.Blue else Color.Red,

                )

        }
        if (state.isLoading)
        {
            CircularProgressIndicator()
        }
        if (state.isError!=null)
        {
            Text(text = state.isError)

        }

    }


        }

