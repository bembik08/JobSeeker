package com.test_app.jobseeker.models.api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    @SerializedName("area")
    val area: List<String>,
    @SerializedName("display_name")
    val displayLocation: String
) : Parcelable