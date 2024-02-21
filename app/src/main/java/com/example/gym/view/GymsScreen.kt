package com.example.gym.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gym.model.remote.gym.response.Gym


@Composable
fun GymsScreen(onItemClick:(Int) -> Unit) {
    val viewModel: GymViewModel = viewModel()

    LazyColumn(Modifier.padding(3.dp)) {
        items(viewModel.state) { gym ->
            GymItem(gym = gym,
                onFavouritItemClick = {viewModel.taggleFavouriteState(it) },
              onItemClick = {id-> onItemClick(id)

        }
            )
        }

}
}


@Composable
fun GymItem(gym: Gym, onFavouritItemClick: (Int) -> Unit, onItemClick: (Int) -> Unit) {
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
    Card(elevation = CardDefaults.cardElevation(
        defaultElevation = 10.dp
    ), modifier = Modifier
        .padding(10.dp)
        .clickable { onItemClick(gym.id) }) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            DefultIcon(
                Icons.Filled.Place, contentDescription = "asset for location",
                weight = Modifier.weight(0.15f)
            ) {}
            GymDetails(gym, Modifier.weight(0.70f))
            DefultIcon(
                icon, contentDescription = "asset for location",
                weight = Modifier.weight(0.15f)
            ) { onFavouritItemClick(gym.id) }
        }

    }

}






