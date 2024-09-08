package com.example.lab6

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun BoxProduct(
    modifier: Modifier,
    painter: Painter,
    contentDescription: String,
    onFavoriteClick: () -> Unit,
    onProductClick: (() -> Unit)? = null
){
    var isFavorite by remember { mutableStateOf(false) }
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
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = "favorite",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .size(24.dp)
                .clickable {
                    isFavorite = !isFavorite
                    onFavoriteClick() // Acción cuando se hace clic en favoritos
                },
            tint = if (isFavorite) Color.Red else Color.White
        )
    }
}

@Composable
fun FavoriteScreen(onDismiss: () -> Unit) {
    // Mostrar el contenido de la pantalla de favoritos
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Welcome to Favorite Screen")
            Spacer(modifier = Modifier.height(20.dp))
            // Botón para volver atrás
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Close Favorite Screen",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { onDismiss() }, // Cerrar pantalla
                tint = Color.Red
            )
        }
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
        modifier = if (fillMaxWidth) modifier
            .padding(top = 10.dp)
            .fillMaxWidth() else modifier.padding(top = 10.dp)
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
@SuppressLint("RememberReturnType")
@Composable
fun CarouselBoxes(onProductSelected: (Int) -> Unit) {
    val images = listOf(
        R.drawable.carne,
        R.drawable.sopa,
        R.drawable.pizza,
        R.drawable.panqueques,
        R.drawable.galleta,
        R.drawable.costilla
    )

    var favorites = remember { mutableStateListOf<Int>() }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Pasamos una función para agregar/eliminar favoritos
        items(images.size) { index ->
            CardContent(images[index]){ imageRes, isFavorite ->
                if (isFavorite) {
                    favorites.add(imageRes)
                } else {
                    favorites.remove(imageRes)
                }
            }
        }
    }
}

@Composable
fun CardContent(imageRes: Int, onFavoriteChange: (Int, Boolean) -> Unit) {
    var isFavorite by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .padding(horizontal = 80.dp)
            .size(250.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = "favorite",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .size(24.dp)
                .clickable {
                    isFavorite = !isFavorite
                    onFavoriteChange(imageRes, isFavorite) // Notificar al contenedor si es favorito
                },
            tint = if (isFavorite) Color.Red else Color.White
        )
    }
}










