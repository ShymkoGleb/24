package com.example.a24.a1_DataSource.source.interner.model

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class UsersPostsFromJSONModel(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("userId") val userId: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("body") val body: String? = null,
        val timestamp: Timestamp?= null
)