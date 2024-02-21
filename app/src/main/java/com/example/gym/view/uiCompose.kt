package com.example.gym.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gym.model.remote.gym.response.Gym
import com.example.gym.ui.theme.Purple40


@Composable
fun DefultIcon(icon: ImageVector, weight: Modifier,contentDescription:String, onclick: () -> Unit) {

    Image(imageVector = icon,
        contentDescription =contentDescription,
        modifier = weight
            .padding(10.dp)
            .clickable { onclick() }
        ,colorFilter = ColorFilter.tint(Color.DarkGray)


    )

}


@Composable
fun GymDetails(gym: Gym, weight: Modifier,horizontalAlignmentLine: Alignment.Horizontal=Alignment.Start) {
    Column(modifier = weight, horizontalAlignment = horizontalAlignmentLine) {
        Text(
            text = gym.name,
            style = MaterialTheme.typography.headlineLarge,
            color = Purple40, fontSize = 22.sp
        )
        CompositionLocalProvider() {
            Text(
                text = gym.place,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )
        }


    }

}