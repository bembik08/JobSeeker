package com.test_app.jobseeker.models.api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company(
    @SerializedName("display_name")
    val displayName: String
):Parcelable