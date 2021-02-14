package com.example.a24.a1_DataSource.Source.Exe

import com.example.a24.a1_DataSource.Sourc.Api
import retrofit2.Retrofit

class UsersPost_FromJson_Exe(private val retrofit: Retrofit) {

    fun getUsersPost()=
    retrofit.create(Api::class.java).getUsersPosts_API().execute().body()
}