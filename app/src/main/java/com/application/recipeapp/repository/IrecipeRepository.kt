package com.application.recipeapp.repository

import com.application.recipeapp.domain.model.Recipe

interface IrecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun getRecipe(token: String, id: Int): Recipe
}