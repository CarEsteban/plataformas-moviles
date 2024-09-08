package com.example.lab6

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Splash(modifier: Modifier = Modifier, onSplashClick: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable { onSplashClick() }

    ) {
        Image(
            painter = painterResource(id = R.drawable.pizza),
            contentDescription = "Imagen de fondo",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.2f),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.gorro_chef),
            contentDescription = "Gorrito",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
                .offset(y = (-80).dp)
        )
        Image(painter = painterResource(id = R.drawable.letras_titulo),
            contentDescription = "Titulo",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
                .offset(y = (100).dp)
        )
    }
}



