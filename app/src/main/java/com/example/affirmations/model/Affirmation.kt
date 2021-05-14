package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/*
* An object instance of Affirmation represents
* one affirmation and contains the resource ID
* of the string with the affirmation.
 */
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
) {
}

/*
* Developers often use model as the package name
* or classes that model (or represent) the data.
 */