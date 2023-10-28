package com.example.cobabaru.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val jobTitle: Int,
    val numberOfCourse: Int,
    @DrawableRes val jobImage: Int
)
