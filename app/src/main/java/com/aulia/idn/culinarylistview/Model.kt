package com.aulia.idn.culinarylistview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model(
    var type1: String,
    var type2: String,
    var title: String,
    var desc: String,
    var date: String,
    var image: Int
) : Parcelable