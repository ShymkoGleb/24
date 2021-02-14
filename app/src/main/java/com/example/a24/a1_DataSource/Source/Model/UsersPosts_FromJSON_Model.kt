package com.example.a24.a1_DataSource.Source.Model

import com.google.gson.annotations.SerializedName

data class UsersPosts_FromJSON_Model(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("userId") val userId: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("body") val body: String? = null
)