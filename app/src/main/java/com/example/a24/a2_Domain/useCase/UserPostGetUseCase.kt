package com.example.a24.a2_Domain.useCase

import com.example.a24.a1_DataSource.Sourc.Api
import com.example.a24.a1_DataSource.mapper.UsersDataPostToModelMapper
import com.example.a24.a1_DataSource.repository.UserPostDatasorceInterface
import com.example.a24.a1_DataSource.source.model.UsersPostsFromJSONModel
import com.example.a24.a2_Domain.mapper.UserPostDomainToUIMapper
import com.example.a24.a3_UI.modelUi.UsersPostUIModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserPostGetUseCase (

private val usersPostDatasorceInterface: UserPostDatasorceInterface,
private val usersPostDomainToUIMapper: UserPostDomainToUIMapper
        ) {

    suspend fun execute(): List<UsersPostUIModel>? {
        return usersPostDomainToUIMapper.map(usersPostDatasorceInterface.getPostsFromDataSource())
    }

}


