package com.example.lab9

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab9.data.RecipeDao
import com.example.lab9.data.RecipeEntity
import kotlinx.coroutines.launch


class MainViewModel(private val recipeDao: RecipeDao, private val context: Context) : ViewModel() {
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

    // Función para verificar la conexión a Internet
    fun isConnectedToInternet(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    // Función para obtener las categorías
    fun fetchCategories() {
        if (isConnectedToInternet()) {
            viewModelScope.launch {
                try {
                    val response = recipeService.getCategories()
                    _categoriesState.value = _categoriesState.value.copy(
                        list = response.categories,
                        loading = false,
                        error = null
                    )

                    // Guardar las categorías en la base de datos (si es necesario, puedes ajustar esto)
                } catch (e: Exception) {
                    _categoriesState.value = _categoriesState.value.copy(
                        loading = false,
                        error = "Error fetching Categories: ${e.message}"
                    )
                }
            }
        } else {
            // Recuperar las categorías desde la base de datos local
            // Si decides guardar categorías, aquí puedes añadir la lógica para recuperar desde Room.
        }
    }

    // Función para obtener las recetas por categoría
    fun fetchRecipesByCategory(category: String) {
        if (isConnectedToInternet()) {
            viewModelScope.launch {
                try {
                    val response = recipeService.getRecipesByCategory(category)
                    _recipesState.value = _recipesState.value.copy(
                        list = response.meals,
                        loading = false,
                        error = null
                    )
                    // Guardar las recetas en la base de datos
                    recipeDao.insertRecipes(response.meals.map { RecipeEntity.fromRecipe(it, category) })
                } catch (e: Exception) {
                    _recipesState.value = _recipesState.value.copy(
                        loading = false,
                        error = "Error fetching Recipes: ${e.message}"
                    )
                    // Agrega este log para imprimir el error
                    Log.e("MainViewModel", "Error fetching recipes", e)
                }
            }
        } else {
            // Recuperar las recetas desde la base de datos local
            viewModelScope.launch {
                val localRecipes = recipeDao.getRecipesByCategory(category)
                _recipesState.value = _recipesState.value.copy(
                    list = localRecipes.map { it.toRecipe() },
                    loading = false,
                    error = null
                )
            }
        }
    }


    // Función para obtener los detalles de una receta por ID
    fun fetchDetailRecipe(idMeal: String) {
        if (isConnectedToInternet()) {
            viewModelScope.launch {
                try {
                    val response = recipeService.getDetailByRecipe(idMeal)
                    val detailRecipe = response.meals.first()

                    // Actualizar la receta con los detalles completos en la base de datos
                    recipeDao.insertRecipe(RecipeEntity.fromRecipeDetail(detailRecipe))

                    _detailRecipeState.value = _detailRecipeState.value.copy(
                        detailRecipe = detailRecipe,
                        loading = false,
                        error = null
                    )

                    // Log para verificar que se está guardando
                    Log.d("fetchDetailRecipe", "Receta guardada en la base de datos: $detailRecipe")
                } catch (e: Exception) {
                    _detailRecipeState.value = _detailRecipeState.value.copy(
                        loading = false,
                        error = "Error fetching Recipe Details: ${e.message}"
                    )
                }
            }
        } else {
            // Recuperar el detalle de la receta desde la base de datos local
            viewModelScope.launch {
                val localRecipe = recipeDao.getRecipeById(idMeal)
                if (localRecipe != null) {
                    _detailRecipeState.value = _detailRecipeState.value.copy(
                        detailRecipe = localRecipe.toDetailRecipe(),
                        loading = false,
                        error = null
                    )

                    // Log para verificar que se está cargando de la base de datos
                    Log.d("fetchDetailRecipe", "Receta cargada desde la base de datos: ${localRecipe.toDetailRecipe()}")
                }
            }
        }
    }





    // Clases de estado
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

