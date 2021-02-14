package com.example.a24.a1_DataSource.Sourc

import retrofit2.Call
import com.example.a24.a1_DataSource.source.model.UsersPostsFromJSONModel
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    fun getUsersPosts_API(): Call<List<UsersPostsFromJSONModel>>
}


