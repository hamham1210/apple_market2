package com.example.carrot_market

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.DecimalFormat


@Parcelize
data class MyItem(
    val icon: Int,
    val name: String,
    val ItemInfo: String,
    val nickname: String,
    val pirce: Int,
    val adress: String,
    val comment: Int,
    val heart: Int,
    val islike : Boolean = false
) :
    Parcelable

