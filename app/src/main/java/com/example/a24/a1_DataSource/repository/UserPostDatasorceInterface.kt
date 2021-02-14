package com.example.a24.a1_DataSource.repository

import com.example.a24.a1_DataSource.model.UsersPostDataSourceModel

interface UserPostDatasorceInterface {

  open fun getPostsFromDataSource(): List<UsersPostDataSourceModel>?
}