package com.example.codelab3

import android.widget.CheckBox
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    taskName: String,
    checkedThis: Boolean,
    onCheckedChangeThis: (Boolean) -> Unit,
    onClose:()->Unit,
    modifier: Modifier = Modifier
){
    Row (
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(checked = checkedThis, onCheckedChange = onCheckedChangeThis)
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }

    }
}
//me quede en el 10 Work With lists cuando definen esta funcion
@Composable
fun WellnessTaskItem(taskName: String,modifier: Modifier=Modifier){
    var checkedState by remember { mutableStateOf(false) }
    WellnessTaskItem(
        taskName = taskName,
        checkedThis = checkedState,
        onCheckedChangeThis = {newValue -> checkedState = newValue},
        onClose = { }
    )
}