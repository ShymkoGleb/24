package com.example.a24.a1_DataSource.repository.impl

import com.example.a24.a1_DataSource.mapper.UsersDataPostToModelMapper
import com.example.a24.a1_DataSource.model.UsersPostDataSourceModel
import com.example.a24.a1_DataSource.repository.UserPostDatasorceInterface
import com.example.a24.a1_DataSource.source.interner.exe.UsersPostFromJsonExe

open class UserPostDatasorceImpl(


    private val usersPostFromJsonExe: UsersPostFromJsonExe,
    private val usersDataPostToModelMapper: UsersDataPostToModelMapper
) : UserPostDatasorceInterface {

    override fun getPostsFromDataSource(): List<UsersPostDataSourceModel>? {
        return usersDataPostToModelMapper.map(
            usersPostFromJsonExe.getUsersPost().orEmpty()
        )
    }
}