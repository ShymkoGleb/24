package com.example.a24.a1_DataSource.source.interner.exe

import com.example.a24.a1_DataSource.source.interner.api.Api
import retrofit2.Retrofit

class UsersPostFromJsonExe(private val retrofit: Retrofit) {

    fun getUsersPost() =
        retrofit.create(Api::class.java).getUsersPosts_API().execute().body()
}
