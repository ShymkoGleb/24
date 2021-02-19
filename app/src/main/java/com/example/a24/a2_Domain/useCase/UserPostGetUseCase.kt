package com.example.a24.a2_Domain.useCase

import com.example.a24.a1_DataSource.repository.UserPostDatasorceInterface
import com.example.a24.a2_Domain.mapper.UserPostDomainToUIMapper
import com.example.a24.a3_UI.modelUi.UsersPostUIModel

class UserPostGetUseCase (

private val usersPostDatasorceInterface: UserPostDatasorceInterface,
private val usersPostDomainToUIMapper: UserPostDomainToUIMapper
        ) {

    suspend fun execute(): List<UsersPostUIModel>? {
        return usersPostDomainToUIMapper.map(usersPostDatasorceInterface.getPostsFromDataSource())
    }

}


