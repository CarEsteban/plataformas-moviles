package com.example.lab9

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService{
    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse

    @GET("filter.php")
    suspend fun getRecipesByCategory(@Query("c") category: String): RecipeResponse

    @GET("lookup.php")
    suspend fun getDetailByRecipe(@Query("i") IDmeal: String): DetailResponse

}

