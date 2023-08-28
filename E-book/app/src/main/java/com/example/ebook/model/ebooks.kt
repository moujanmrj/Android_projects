package com.example.ebook.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ebooks(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val description: Int
)