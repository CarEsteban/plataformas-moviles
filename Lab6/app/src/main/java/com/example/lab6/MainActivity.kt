package com.example.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab6.ui.theme.Lab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6Theme {
                var showSplash by remember { mutableStateOf(true) }
                var showMenu by remember { mutableStateOf(false) }
                var showProduct by remember { mutableStateOf(false) }
                var showFavoriteScreen by remember { mutableStateOf(false) }
                var selectedProductId by remember { mutableStateOf(1) }

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp)
                ) { innerPadding ->
                    when {
                        showSplash -> {
                            Splash(
                                modifier = Modifier.padding(innerPadding),
                                onSplashClick = { showSplash = false }
                            )
                        }
                        showFavoriteScreen -> {
                            FavoriteScreen(onDismiss = { showFavoriteScreen = false })
                        }
                        showMenu -> {
                            MenuDesplegable(
                                modifier = Modifier.padding(innerPadding),
                                onMenuButtonClick = { showMenu = !showMenu }
                            )
                        }
                        showProduct -> {
                            Product(
                                modifier = Modifier.padding(innerPadding),
                                ID = selectedProductId
                            )
                        }
                        else -> {
                            Home(
                                modifier = Modifier.padding(innerPadding),
                                onMenuButtonClick = { showMenu = !showMenu },
                                onProductSelected = { productId ->
                                    selectedProductId = productId
                                    showProduct = true
                                },
                                onFavoriteSelected = { showFavoriteScreen = true } // Mostrar favoritos desde Home
                            )
                        }
                    }
                }
            }
        }
    }
}


