package com.gyrs.avoqr.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AvocadoData(
    val imageResource : Int?,
    val title : String,
    val content : String,
) : Parcelable
{
}