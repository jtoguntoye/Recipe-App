package com.application.recipeapp.presentation.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.application.recipeapp.R
import com.application.recipeapp.domain.model.Recipe
import com.application.recipeapp.util.DEFAULT_IMAGE
import com.application.recipeapp.util.loadPicture
import kotlinx.coroutines.ExperimentalCoroutinesApi


@Composable
@ExperimentalCoroutinesApi
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit,
){
    Card (
        shape =MaterialTheme.shapes.small,
         modifier = Modifier.
            padding(
            bottom = 6.dp,
                top = 6.dp)
             .fillMaxWidth()
             .clickable(onClick = onClick),
        elevation = 8.dp
    ){
        Column() {
            recipe.featuredImage?.let{url ->
                val image =  loadPicture(url = url, defaultPic = DEFAULT_IMAGE).value
                image?.let{
                    Image(
                        bitmap = image.asImageBitmap(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .preferredHeight(225.dp),
                        contentScale = ContentScale.Crop,
                    )
                }

            }
            recipe.title?.let{title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ){
                   Text(
                     text = title,
                     modifier = Modifier
                       .fillMaxWidth(0.85f)
                       .wrapContentWidth(Alignment.Start)
                       ,
                        style = MaterialTheme.typography.h5
                   )
                    val rank = recipe.rating.toString()
                    Text(
                        text = rank,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.Start)
                        ,
                        style = MaterialTheme.typography.h6
                    )
                }
            }
            
        }
    }


}