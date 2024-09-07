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
                var showMenu by remember { mutableStateOf(false) } // State to control the menu

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp)
                ) { innerPadding ->
                    // Pass showMenu state and the function to toggle it
                    /*if (showMenu) {
                        MenuDesplegable(
                            modifier = Modifier.padding(innerPadding),
                            onMenuButtonClick = { showMenu = !showMenu }
                        )
                    } else {
                        Home(
                            modifier = Modifier.padding(innerPadding),
                            onMenuButtonClick = { showMenu = !showMenu }
                        )
                    }*/
                    Product(modifier =  Modifier.padding(innerPadding))
                }
            }
        }
    }
}
