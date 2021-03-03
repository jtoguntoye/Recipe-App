package com.application.recipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import com.application.recipeapp.presentation.components.RecipeCard
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class RecipeListFragment:Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent{

                //recipeList  variable is a MutableState,it's optimized for jetpack compose
                 val recipeList = viewModel.recipes.value
                val query =viewModel.query.value
                
                Column{
                    TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = query,
                            onValueChange = {
                                viewModel.onQueryChanged(it)
                            },
                            label = {
                                Text(text = "Search")
                            }
                    )

                    LazyColumn{
                    itemsIndexed(
                            items = recipeList
                    ){
                        index, recipe ->
                        RecipeCard(recipe = recipe, onClick = { /*TODO*/ })
                        }
                    }
                }

//                for(recipe in recipeList) {
//                   Log.d("TAG ","Recipe: + $recipe.title")
//                }


//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text(
//                        text = "RecipeList",
//                        style = TextStyle(
//                            fontSize = TextUnit.Companion.Sp(21)
//                        )
//                    )
//                    Spacer(modifier = Modifier.padding(10.dp))
//                    Button(onClick = { /*viewModel.newSearch()*/ })
//                    {
//                        Text(text = " Perform Search")
//
//                    }
//
//                }

            }
        }
    }

}