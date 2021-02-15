package com.application.recipeapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.recipeapp.domain.model.Recipe
import com.application.recipeapp.repository.IrecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


class RecipeListViewModel
    @ViewModelInject
    constructor(
        private  val recipeRepository: IrecipeRepository,
        private @Named("auth_token") val token: String
    ): ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch{
            val result =   recipeRepository.search(
            token,
            1,
            "chicken"
        )
            recipes.value = result
        }

    }
}