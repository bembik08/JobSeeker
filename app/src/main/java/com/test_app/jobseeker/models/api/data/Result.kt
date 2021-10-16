package com.test_app.jobseeker.models.api.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    @SerializedName("category")
    val category: Category,
    @SerializedName("company")
    val company: Company,
    @SerializedName("created")
    val created: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Float,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("location")
    val location: Location,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("redirect_url")
    val url: String,
    @SerializedName("salary_is_predicted")
    val salary: String,
    @SerializedName("salary_max")
    val salaryMax: Int,
    @SerializedName("salary_min")
    val salaryMin: Int,
    @SerializedName("title")
    val title: String
):Parcelable