package com.bryancorp.gojek_test_ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PromosModel (
    val image: Int?,
    val title: String,
    val descFood: String?,
    val category: String?
) : Parcelable