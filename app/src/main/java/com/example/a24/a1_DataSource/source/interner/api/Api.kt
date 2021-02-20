package com.example.a24.a1_DataSource.source.interner.api

import com.example.a24.a1_DataSource.source.interner.model.UsersPostsFromJSONModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    fun getUsersPosts_API(): Call<List<UsersPostsFromJSONModel>>
}


