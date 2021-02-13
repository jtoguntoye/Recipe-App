package com.application.recipeapp.di

import com.application.recipeapp.network.model.RecipeDtoMapper
import com.application.recipeapp.network.model.RecipeService
import com.application.recipeapp.repository.IrecipeRepository
import com.application.recipeapp.repository.RecipeRepository_impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(recipeService: RecipeService,
                                recipeDtoMapper: RecipeDtoMapper): IrecipeRepository {

        return RecipeRepository_impl(
                recipeService,
                recipeDtoMapper
        )
    }

}
