import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Ganador(navController: NavController, ganador: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¡Felicidades $ganador!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Has ganado el juego.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {navController.navigate("home") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Jugar de nuevo")
            }
        }
    }
}
