package com.example.a24.a1_DataSource.Sourc

import retrofit2.Call
import com.example.a24.a1_DataSource.Source.Model.UsersPosts_FromJSON_Model
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    fun getUsersPosts_API(): Call<List<UsersPosts_FromJSON_Model>>
}


