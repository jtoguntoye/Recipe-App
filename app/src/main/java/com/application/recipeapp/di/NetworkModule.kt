package com.application.recipeapp.di

import com.application.recipeapp.network.model.RecipeDtoMapper
import com.application.recipeapp.network.model.RecipeService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
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
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(RecipeService::class.java)
    }


    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}