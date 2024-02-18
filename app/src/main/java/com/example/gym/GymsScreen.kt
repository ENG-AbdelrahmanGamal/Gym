package com.example.gym

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.LocalPinnableContainer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gym.ui.theme.Purple40
import com.example.gym.ui.theme.Purple80

@Preview
@Composable
fun GymsScreen()
{


    LazyColumn(){

       items(listOfGym){gym->
           GymItem(gym = gym)

       }
    }

//    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
//        listOfGym.forEach{gym->
//            GymItem(gym)
//
//        }
//    }


}


@Composable
fun GymItem(gym: Gym) {
Card(modifier = Modifier.padding(4.dp)) {

    Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)){
        GymIcon(Icons.Filled.Place,Modifier.weight(0.15f))
        GymDetails(gym,Modifier.weight(0.70f))
        GymFavouriteIcon(Modifier.weight(0.15f))
    }

}

}

@Composable
fun GymFavouriteIcon(weight: Modifier) {
var isFavorite by remember{mutableStateOf(false)}
    val icon =if(isFavorite)
    {
        Icons.Filled.Favorite
    }
    else
    {
        Icons.Filled.FavoriteBorder
    }
    Image(imageVector = icon,
        contentDescription ="Favorite Icon" ,
        modifier = weight.padding(10.dp).clickable { isFavorite=!isFavorite }

    )

}




@Composable
fun GymDetails(gym: Gym,weight: Modifier) {

Column(modifier = weight) {
    Text(text = gym.name,
        style = MaterialTheme.typography.headlineLarge,
        color = Purple40
        )
    CompositionLocalProvider() {
        Text(text = gym.place,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.DarkGray
        )
    }


}

}

@Composable
fun GymIcon(place: ImageVector, weight: Modifier) {
Image(imageVector = place,
    contentDescription = "image icon",
    modifier = weight,
    colorFilter = ColorFilter.tint(Color.DarkGray)

)

}

@Composable
fun show()
{
    GymsScreen()
}




