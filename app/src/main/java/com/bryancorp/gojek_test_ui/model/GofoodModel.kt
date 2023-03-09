package com.bryancorp.gojek_test_ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GofoodModel(
    val image: Int,
    val title: String
) : Parcelable