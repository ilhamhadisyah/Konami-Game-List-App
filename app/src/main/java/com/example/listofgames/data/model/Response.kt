package com.example.listofgames.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(

    @field:SerializedName("Response")
    val response: List<ResponseItem?>? = null
) : Parcelable

@Parcelize
data class ResponseItem(

    @field:SerializedName("data-platform")
    val dataPlatform: String? = null,

    @field:SerializedName("img")
    val img: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("url")
    val url: String? = null
) : Parcelable
