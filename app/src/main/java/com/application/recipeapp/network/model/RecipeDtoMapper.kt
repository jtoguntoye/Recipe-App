package com.application.recipeapp.network.model

import com.application.recipeapp.domain.model.Recipe
import com.application.recipeapp.util.EntityMapper

class RecipeDtoMapper: EntityMapper<RecipeDto, Recipe> {

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
        pk = domainModel.id,
        title = domainModel.title,
        featuredImage = domainModel.featuredImage,
        rating = domainModel.rating,
        publisher = domainModel.publisher,
        sourceUrl = domainModel.sourceUrl,
        description = domainModel.description,
        cookingInstructions = domainModel.cookingInstructions,
        ingredients = domainModel.ingredients,
        dateAdded = domainModel.dateAdded,
        dateUpdated = domainModel.dateUpdated,
        )
    }

    override fun mapToDomainModel(domain: RecipeDto): Recipe {
        return Recipe(
            id = domain.pk,
            title = domain.title,
            featuredImage = domain.featuredImage,
            rating = domain.rating,
            publisher = domain.publisher,
            sourceUrl = domain.sourceUrl,
            description = domain.description,
            cookingInstructions = domain.cookingInstructions,
            ingredients = domain.ingredients?: listOf(),
            dateAdded = domain.dateAdded,
            dateUpdated = domain.dateUpdated,
        )
    }

    fun fromEntityList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map{mapToDomainModel(it)}
    }

    fun toEntityList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map{mapFromDomainModel(it)}
    }
}