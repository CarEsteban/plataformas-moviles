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
import androidx.compose.material.icons.outlined.StarBorder
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
    // Diálogo con fondo desenfocado
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Imagen de fondo
            Image(
                painter = painterResource(id = R.drawable.pantallafavorito), // Imagen de fondo
                contentDescription = "Imagen de fondo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            // Caja blanca centrada
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(300.dp, 250.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                // Columna para los elementos del cuadro
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Botón para cerrar el diálogo
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.cruz), // Imagen de la cruz en drawable
                            contentDescription = "Cerrar",
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(24.dp) // Tamaño del icono de cierre
                                .clickable { onDismiss() } // Al hacer clic, cierra el diálogo
                        )
                    }

                    // Texto principal
                    Text(
                        text = "YOU DID IT!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Let your friends know about it",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    // Iconos de redes sociales
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 16.dp)
                    ) {
                        val socialIcons = listOf(
                            R.drawable.google_icon, // Asegúrate de tener los íconos correctos
                            R.drawable.facebook,
                            R.drawable.instagram,
                            R.drawable.twitter
                        )
                        socialIcons.forEach { icon ->
                            Image(
                                painter = painterResource(id = icon),
                                contentDescription = "Social icon",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }

                    // Calificación (Dejar una reseña con estrellas)
                    Text(
                        text = "Leave a review",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        repeat(5) {
                            Icon(
                                imageVector = Icons.Outlined.StarBorder, // Estrella vacía
                                contentDescription = "Empty Star",
                                tint = Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
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
    var favorites = remember { mutableStateListOf<Int>() }

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
                ){ imageRes, isFavorite ->
                    if (isFavorite) {
                        favorites.add(imageRes)
                    } else {
                        favorites.remove(imageRes)
                    }
                }
            }
        }
    }
}

@Composable
fun CardContent(imageRes: Int, onClick: () -> Unit, onFavoriteChange: (Int, Boolean) -> Unit) {
    var isFavorite by remember { mutableStateOf(false) }

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

@Composable
fun ProductScreen(index: Int, onBack: () -> Unit) {
    Product(modifier = Modifier,index+1)
    println("Clicked on item index: $index")
}