package com.example.lab9

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailRecipeScreen(recipeId: String, mainViewModel: MainViewModel, onBack: () -> Unit) {
    val detailRecipeState by mainViewModel.detailRecipeState

    LaunchedEffect(recipeId) {
        mainViewModel.fetchDetailRecipe(recipeId)
    }

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        when {
            detailRecipeState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            detailRecipeState.error != null -> {
                Text(text = "Error loading recipe details", modifier = Modifier.align(Alignment.Center))
            }
            detailRecipeState.detailRecipe != null -> {
                val recipe = detailRecipeState.detailRecipe!!
                Column(
                    modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                ) {
                    // TopAppBar con el botón de regresar
                    TopAppBar(
                        title = { Text(text = "Recipe Details") },
                        navigationIcon = {
                            IconButton(onClick = onBack) {
                                Icon(imageVector = Icons.Filled.Close, contentDescription = "Back")
                            }
                        }
                    )
                    Text(
                        text = recipe.strMeal,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = rememberAsyncImagePainter(recipe.strMealThumb),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().aspectRatio(1f)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Category: ${recipe.strCategory}")
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Area: ${recipe.strArea}")
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Instructions:")
                    Text(text = recipe.strInstructions)
                }
            }
        }
    }
}



