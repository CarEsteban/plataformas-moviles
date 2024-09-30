package com.example.lab8

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    // Estado para las categorías
    private val _categoriesState = mutableStateOf(CategoriesState())
    val categoriesState: State<CategoriesState> = _categoriesState

    //Estado para las recetas filtadas
    private val _recipesState = mutableStateOf(RecipeState())
    val recipesState: State<RecipeState> = _recipesState

    init {
        fetchCategories() // Cargar las categorías al iniciar
    }

    //este es el codig para pdoer hacer el get de las categorias
    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    //este es el codigo para poder obtener las recetas pero mediante la categoria
    fun fetchRecipesByCategory(category: String) {
        viewModelScope.launch {
            try {
                //esto viene de la API , ApiService.kt
                val response = recipeService.getRecipesByCategory(category)
                _recipesState.value = _recipesState.value.copy(
                    list = response.meals,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _recipesState.value = _recipesState.value.copy(
                    loading = false,
                    error = "Error fetching Recipes ${e.message}"
                )
            }
        }
    }

    // Estado para las categorías
    data class CategoriesState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )

    //Estado pra las recetas
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Recipe> = emptyList(),
        val error: String? = null
    )


}