package com.example.lab6

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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
@Composable
fun CarouselBoxes() {
    val images = listOf(
        R.drawable.carne,
        R.drawable.sopa,
        R.drawable.pizza,
        R.drawable.panqueques,
        R.drawable.galleta,
        R.drawable.costilla
    )

    var selectedIndex by remember { mutableStateOf<Int?>(null) }

    // Si el índice es diferente de null, mostramos la pantalla del producto
    if (selectedIndex != null) {
        ProductScreen(index = selectedIndex!!, onBack = { selectedIndex = null })
    } else {
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(images.size) { index ->
                CardContent(
                    imageRes = images[index],
                    onClick = {
                        selectedIndex = index // Actualiza el índice cuando haces clic
                    }
                )
            }
        }
    }
}

@Composable
fun CardContent(imageRes: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .padding(horizontal = 80.dp)
            .size(250.dp)
            .clickable { onClick() } // Agregar el evento onClick
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
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

@Composable
fun ProductScreen(index: Int, onBack: () -> Unit) {
    Product(modifier = Modifier,index+1)
}