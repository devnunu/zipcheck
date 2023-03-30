package com.devnunu.zipcheck.data.model.house

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ChecklistItem(
    val name: String = "",
    var isChecked: Boolean = false
) : Parcelable