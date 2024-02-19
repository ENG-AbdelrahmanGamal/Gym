package com.example.gym.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gym.model.remote.gym.response.Gym
import com.example.gym.ui.theme.Purple40

@Preview
@Composable
fun GymsScreen() {
    val viewModel: GymViewModel = viewModel()
    viewModel.getGym()
    LazyColumn() {
        items(viewModel.state) { gym ->
            GymItem(gym) { gymId ->
                viewModel.taggleFavouriteState(gymId)

            }
        }

        }
    }

//    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
//        listOfGym.forEach{gym->
//            GymItem(gym)
//
//        }
//    }





@Composable
fun GymItem(gym: Gym, onclick: (Int) -> Unit) {
    val icon = if (gym.isFavourite) {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }
//    SearchBar(
//        query = string
//        , onQueryChange =
//        , onSearch =
//        , active = ,
//        onActiveChange =
//    ) {
//    }
    Card(modifier = Modifier.padding(4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            DefultIcon(Icons.Filled.Place, Modifier.weight(0.15f)) {}
            GymDetails(gym, Modifier.weight(0.70f))
            DefultIcon(icon, Modifier.weight(0.15f)) { onclick(gym.id)}
        }

    }

}

@Composable
fun DefultIcon(icon: ImageVector, weight: Modifier, onclick: () -> Unit) {

    Image(imageVector = icon,
        contentDescription = "Favorite Icon",
        modifier = weight
            .padding(10.dp)
            .clickable { onclick() }
            ,colorFilter = ColorFilter.tint(Color.DarkGray)


    )

}


@Composable
fun GymDetails(gym: Gym, weight: Modifier) {
    Column(modifier = weight) {
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



@Composable
fun show() {
    GymsScreen()
}




