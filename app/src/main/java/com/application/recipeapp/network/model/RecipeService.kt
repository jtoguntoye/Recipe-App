package com.application.recipeapp.network.model

import com.application.recipeapp.network.model.response.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService {

    @GET("search")
    suspend fun search(
            @Header("Authorization") token: String,
            @Query("page") page: Int,
            @Query("query") query: String
    ): RecipeSearchResponse

    @GET("get")
    suspend  fun getRecipe(
            @Header("Authorization") token: String,
            @Query("id") id: Int
    ): RecipeDto
}