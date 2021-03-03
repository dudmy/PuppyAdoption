package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Puppy(
    val id: Int,
    val name: String,
    val age: Int,
    val breed: String,
    @DrawableRes val drawable: Int,
    var adoption: Boolean = false
)
