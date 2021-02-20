package com.example.a24.a1_DataSource.mapper

import com.example.a24.a1_DataSource.model.UsersPostDataSourceModel
import com.example.a24.a1_DataSource.source.interner.model.UsersPostsFromJSONModel

class UsersDataPostToModelMapper {
    fun map(responses: List<UsersPostsFromJSONModel>?): List<UsersPostDataSourceModel>? {
        return responses?.let {
            responses.map {
                UsersPostDataSourceModel(
                    it.id.orZero(),
                    it.userId.orZero(),
                    it.title.orEmpty(),
                    it.body.orEmpty()
                )
            }
        }
    }
}

private fun Int?.orZero(): Int? = this ?: 0
