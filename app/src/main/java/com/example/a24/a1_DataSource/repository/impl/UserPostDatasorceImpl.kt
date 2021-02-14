package com.example.a24.a1_DataSource.repository.impl

import com.example.a24.a1_DataSource.Sourc.Api
import com.example.a24.a1_DataSource.mapper.UsersDataPostToModelMapper
import com.example.a24.a1_DataSource.model.UsersPostDataSourceModel
import com.example.a24.a1_DataSource.repository.UserPostDatasorceInterface
import com.example.a24.a1_DataSource.source.exe.UsersPostFromJsonExe
import com.example.a24.a1_DataSource.source.model.UsersPostsFromJSONModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class UserPostDatasorceImpl(


    private val usersPost_FromJson_Exe: UsersPostFromJsonExe,
    private val usersDataPostToModelMapper: UsersDataPostToModelMapper
) : UserPostDatasorceInterface {

    override fun getPostsFromDataSource(): List<UsersPostDataSourceModel>? {
        return usersDataPostToModelMapper.map(
            usersPost_FromJson_Exe.getUsersPost().orEmpty()
        )
    }
}

/*

fun main() {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitCreate: Api = retrofit.create(Api::class.java)
    val retrofitExecute = retrofitCreate.getUsersPosts_API().execute()
    val catsMutableList: MutableList<UsersPostsFromJSONModel>? =
        retrofitExecute.body() as MutableList<UsersPostsFromJSONModel>?

    catsMutableList?.forEach {
        println(it)
    }
}


*/

