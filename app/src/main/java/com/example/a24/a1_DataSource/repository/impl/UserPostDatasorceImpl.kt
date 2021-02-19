package com.example.a24.a1_DataSource.repository.impl

import com.example.a24.a1_DataSource.mapper.UsersDataPostToModelMapper
import com.example.a24.a1_DataSource.model.UsersPostDataSourceModel
import com.example.a24.a1_DataSource.repository.UserPostDatasorceInterface
import com.example.a24.a1_DataSource.source.interner.exe.UsersPostFromJsonExe
import com.example.a24.a1_DataSource.source.usersCustomPost.exe.UsersPostFromApplicationExe

open class UserPostDatasorceImpl(


    private val usersPostFromJsonExe: UsersPostFromJsonExe,
    //private val usersPostFromApplicationExe: UsersPostFromApplicationExe,
    private val usersDataPostToModelMapper: UsersDataPostToModelMapper
) : UserPostDatasorceInterface {

    override fun getPostsFromDataSource(): List<UsersPostDataSourceModel>? {
        return usersDataPostToModelMapper.map(
            usersPostFromJsonExe.getUsersPost().orEmpty()
        )
    }

    fun addPostFromApplication(){

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

