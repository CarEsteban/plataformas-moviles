package com.example.codelab3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(count, {count++}, modifier)
}

@Composable
fun StatelessCounter(
        count: Int,
        onIncrement: ()-> Unit,
        modifier: Modifier = Modifier
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            if (count>0){
                Text(text = "Has tomado $count vasos")
            }
            Button(
                onClick = onIncrement,
                Modifier.padding(top = 8.dp),
                enabled = count<10
            ) {
                Text(text = "Agrega uno")
            }
        }
}