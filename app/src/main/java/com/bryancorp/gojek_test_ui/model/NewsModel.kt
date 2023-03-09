package com.bryancorp.gojek_test_ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsModel(
    val image: Int,
    val title: String,
    val descNews: String
) : Parcelable
