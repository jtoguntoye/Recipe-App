package com.application.recipeapp.di

import com.application.recipeapp.network.model.RecipeDtoMapper
import com.application.recipeapp.network.model.RecipeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val BASE_URL = "https://food2fork.ca/api/recipe/"

    @Singleton
    @Provides
    fun provideRecipeDtoMapper(): RecipeDtoMapper {
        return RecipeDtoMapper()
    }


    @Singleton
    @Provides
    fun provideRecipeService (): RecipeService {
        return   Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RecipeService::class.java)
    }
}