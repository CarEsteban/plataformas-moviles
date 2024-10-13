package com.example.lab8

import android.widget.Space
import androidx.collection.scatterSetOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState
    val recipeState by recipeViewModel.recipesState

    val categoryNames = remember(viewState.list) {
        viewState.list.map { it.strCategory }
    }

    var isExpanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf("") }

    LaunchedEffect(categoryNames) {
        if (categoryNames.isNotEmpty()) {
            selectedIndex = categoryNames[0]
        }
    }

    LaunchedEffect(selectedIndex) {
        if (selectedIndex.isNotEmpty()) {
            recipeViewModel.fetchRecipesByCategory(selectedIndex)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 9.dp, vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Selecciona la categoría:",
            modifier = Modifier.padding(bottom = 20.dp)
        )

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ) {
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedIndex,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
            )

            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                categoryNames.forEachIndexed { index, category ->
                    DropdownMenuItem(
                        text = { Text(text = category) },
                        onClick = {
                            selectedIndex = categoryNames[index]
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }

        Text(text = "Elemento actual: $selectedIndex")
    }

    // Muestra las recetas filtradas en CategoryScreen
    Box(modifier = Modifier.fillMaxWidth().padding(top = 200.dp)) {
        when {
            recipeState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            recipeState.error != null -> {
                Text("ERROR OCURRED")
            }
            else -> {
                CategoryScreen(recipes = recipeState.list) { idMeal ->
                    // Navega a la pantalla de detalles
                    navController.navigate("recipeDetail/$idMeal")
                }
            }
        }
    }
}




@Composable
fun CategoryScreen(recipes: List<Recipe>, onRecipeClick: (String) -> Unit) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxWidth()) {
        items(recipes) { recipe ->
            RecipeItem(recipe = recipe, onRecipeClick = onRecipeClick)
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe, onRecipeClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onRecipeClick(recipe.idMeal) },  // Llama a la función cuando se hace clic
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(recipe.strMealThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().aspectRatio(1f)
        )

        Text(
            text = recipe.strMeal,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


