package com.application.recipeapp.di

import android.content.Context
import com.application.recipeapp.network.model.RecipeService
import com.application.recipeapp.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {




    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
    return app as BaseApplication
    }


    @Singleton
    @Provides
    @Named("token")
    fun provideAuthToken(): String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}