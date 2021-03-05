package com.application.recipeapp.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AmbientContext
import com.application.recipeapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

const val DEFAULT_IMAGE = R.drawable.empty_plate
@Composable
fun loadPicture(url: String,
@DrawableRes defaultPic: Int): MutableState<Bitmap?> {
    val bitMapState: MutableState<Bitmap?> = mutableStateOf(null);

    //show default image when picture loads
    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(DEFAULT_IMAGE)
        .into(object: CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitMapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })


    //load image from network
    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(url)
        .into(object: CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitMapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {}
        })

return bitMapState
}