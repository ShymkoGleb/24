package com.example.a24.a1_DataSource.Repository.impl

import androidx.lifecycle.viewModelScope
import com.example.a24.a1_DataSource.Mapper.UsersDataPostToModelMapper
import com.example.a24.a1_DataSource.Model.UsersPost_DataSource_Model
import com.example.a24.a1_DataSource.Repository.UserPost_Datasorce_Interface
import com.example.a24.a1_DataSource.Sourc.Api
import com.example.a24.a1_DataSource.Source.Exe.UsersPost_FromJson_Exe
import com.example.a24.a1_DataSource.Source.Model.UsersPosts_FromJSON_Model
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class UserPost_Datasorce_Impl(



    private val usersPost_FromJson_Exe: UsersPost_FromJson_Exe,
    private val usersDataPostToModelMapper: UsersDataPostToModelMapper
) : UserPost_Datasorce_Interface {

    override fun getPostsFromDataSource(): List<UsersPost_DataSource_Model>? {
        return usersDataPostToModelMapper.map(
            usersPost_FromJson_Exe.getUsersPost().orEmpty()
        )
    }
}


fun main() {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitCreate: Api = retrofit.create(Api::class.java)
    val retrofitExecute = retrofitCreate.getUsersPosts_API().execute()
    val catsMutableList: MutableList<UsersPosts_FromJSON_Model>? = retrofitExecute.body() as MutableList<UsersPosts_FromJSON_Model>?

    catsMutableList?.forEach {
        println(it)
    }



   /* var userPost_Datasorce_Impl = UserPost_Datasorce_Impl(
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        )
        .build()
    ), UsersDataPostToModelMapper())*/

}


