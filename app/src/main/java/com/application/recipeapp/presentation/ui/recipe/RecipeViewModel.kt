package com.application.recipeapp.presentation.ui.recipe

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.application.recipeapp.repository.IrecipeRepository
import com.application.recipeapp.repository.RecipeRepository_impl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeViewModel
@Inject
constructor(private  val recipeRepository: IrecipeRepository,
            private @Named("auth_token") val token: String
): ViewModel() {

    init{
        println("VIEWMODEL: $recipeRepository")
        println("$token")
    }


}