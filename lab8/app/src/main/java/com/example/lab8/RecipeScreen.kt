package com.example.lab8

import android.content.Context
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
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
fun RecipeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    val viewState by mainViewModel.categoriesState
    val recipeState by mainViewModel.recipesState
    var connectionStatus by remember { mutableStateOf("") }

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
            mainViewModel.fetchRecipesByCategory(selectedIndex)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botón para verificar la conexión a Internet
        Button(onClick = {
            // Aquí se verifica la conexión a internet cada vez que se pulsa el botón
            val isConnected = mainViewModel.isConnectedToInternet()
            connectionStatus = if (isConnected) "Conectado a Internet" else "No hay conexión"
        }) {
            Text(text = "Verificar Conexión")
        }
        // Muestra el estado de la conexión
        Text(text = connectionStatus, modifier = Modifier.padding(top = 8.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Selecciona la categoría:",
            modifier = Modifier.padding(bottom = 10.dp)
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

        Spacer(modifier = Modifier.height(20.dp)) // Agrega más espacio para que las imágenes bajen correctamente.

        // Muestra las recetas filtradas en CategoryScreen
        if (recipeState.loading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (recipeState.error != null) {
            Text("ERROR OCURRED", color = Color.Red)
        } else {
            // Aquí es donde debes colocar el LazyVerticalGrid para las imágenes
            CategoryScreen(
                recipes = recipeState.list,
                onRecipeClick = { idMeal ->
                    navController.navigate("recipeDetail/$idMeal")
                },
                modifier = Modifier.padding(top = 20.dp) // Ajusta este padding si necesitas más espacio
            )
        }
    }
}

@Composable
fun CategoryScreen(
    recipes: List<Recipe>,
    onRecipeClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxWidth() // Ajusta el modificador para ocupar todo el ancho disponible
    ) {
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
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

        Text(
            text = recipe.strMeal,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}



