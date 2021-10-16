package com.test_app.jobseeker.models.api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    @SerializedName("label")
    val label: String,
    @SerializedName("tag")
    val tag: String
):Parcelable