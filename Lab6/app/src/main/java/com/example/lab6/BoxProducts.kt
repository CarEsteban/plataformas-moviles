package com.example.lab6

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun BoxProduct(
    modifier: Modifier,
    painter: Painter,
    contentDescription: String
){
    Box(
        modifier
    ){
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Icon(
            imageVector = Icons.Filled.FavoriteBorder,
            contentDescription = "favorite",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .size(24.dp),
            tint = Color.White
        )
    }
}


@Composable
fun Stars(
    ID: Int,
    modifier: Modifier,
    countStars: Float,
    fillMaxWidth: Boolean=true
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center ,
        modifier = if (fillMaxWidth) modifier.padding(top = 10.dp).fillMaxWidth() else modifier.padding(top = 10.dp)
    ){
        val rating: Float = countStars

        val fullStars = rating.toInt()

        val hasHalfStar = (rating-fullStars)>=0.5

        // Dibuja estrellas llenas
        for (i in 1..fullStars) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = Color(0xFFFFD700), // Color dorado
                modifier = Modifier.size(20.dp)
            )
        }

        // Dibuja una media estrella si es necesario
        if (hasHalfStar) {
            Icon(
                imageVector = Icons.Filled.StarHalf,
                contentDescription = "Half Star",
                tint = Color(0xFFFFD700),
                modifier = Modifier.size(20.dp)
            )
        }

        // Dibuja estrellas vacías para completar 5
        val emptyStars = if (hasHalfStar) 5 - fullStars - 1 else 5 - fullStars
        for (i in 1..emptyStars) {
            Icon(
                imageVector = Icons.Outlined.StarOutline,
                contentDescription = "Empty Star",
                tint = Color(0xFFFFD700),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

val images = listOf(
    R.drawable.costilla,
    R.drawable.sopa,
    R.drawable.pizza
)
@Composable
fun CarouselBoxes() {
    val images = listOf(
        R.drawable.costilla,
        R.drawable.sopa,
        R.drawable.pizza
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(images) { image ->
            CardContent(image)
        }
    }
}

@Composable
fun CardContent(image: Int) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp) // Set the size of the card
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Fit image in card
        )
        Icon(
            imageVector = Icons.Filled.FavoriteBorder,
            contentDescription = "favorite",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .size(24.dp),
            tint = Color.White
        )
    }
}

