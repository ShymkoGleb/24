package com.example.a24.a1_DataSource.Repository

import com.example.a24.a1_DataSource.Model.UsersPost_DataSource_Model

interface UserPost_Datasorce_Interface {

    fun getPostsFromDataSource(): List<UsersPost_DataSource_Model>?
}