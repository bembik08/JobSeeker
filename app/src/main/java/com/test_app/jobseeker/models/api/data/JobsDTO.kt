package com.test_app.jobseeker.models.api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JobsDTO(
    @SerializedName("count")
    val count: Int,
    @SerializedName("mean")
    val mean: Double,
    @SerializedName("results")
    val results: List<Result>
) : Parcelable