package com.application.recipeapp.repository

import com.application.recipeapp.domain.model.Recipe
import com.application.recipeapp.network.model.RecipeDtoMapper
import com.application.recipeapp.network.model.RecipeService

class RecipeRepository_impl(
        private val recipeService: RecipeService,
        private val mapper: RecipeDtoMapper
): IrecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {

        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun getRecipe(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.getRecipe(token, id))
    }
}