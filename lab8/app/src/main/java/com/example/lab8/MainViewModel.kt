package com.example.lab8

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab8.data.RecipeDao
import com.example.lab8.data.RecipeEntity
import kotlinx.coroutines.launch

class MainViewModel(
    private val recipeDao: RecipeDao,
    private val context: Context
) : ViewModel() {
    // Estado para las categorías
    private val _categoriesState = mutableStateOf(CategoriesState())
    val categoriesState: State<CategoriesState> = _categoriesState

    // Estado para las recetas filtradas
    private val _recipesState = mutableStateOf(RecipeState())
    val recipesState: State<RecipeState> = _recipesState

    // Estado para los detalles de la receta
    private val _detailRecipeState = mutableStateOf(DetailRecipeState())
    val detailRecipeState: State<DetailRecipeState> = _detailRecipeState

    init {
        fetchCategories() // Cargar las categorías al iniciar
    }

    // Obtiene las categorías desde la API
    private fun fetchCategories() {
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
                    error = "Error fetching Categories: ${e.message}"
                )
            }
        }
    }

    // Función para obtener las recetas por categoría
    fun fetchRecipesByCategory(category: String) {
        viewModelScope.launch {
            try {
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

    // Función para obtener los detalles de una receta por ID
    fun fetchDetailRecipe(idMeal: String) {
        viewModelScope.launch {
            try {
                val response = recipeService.getDetailByRecipe(idMeal)
                _detailRecipeState.value = _detailRecipeState.value.copy(
                    detailRecipe = response.meals.first(),
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _detailRecipeState.value = _detailRecipeState.value.copy(
                    loading = false,
                    error = "Error fetching Recipe Details ${e.message}"
                )
            }
        }
    }

    // Función para verificar la conexión a Internet
    fun isConnectedToInternet(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    // Clases de Estado fuera de las funciones
    data class CategoriesState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Recipe> = emptyList(),
        val error: String? = null
    )

    data class DetailRecipeState(
        val loading: Boolean = true,
        val detailRecipe: DetailRecipe? = null,
        val error: String? = null
    )
}
