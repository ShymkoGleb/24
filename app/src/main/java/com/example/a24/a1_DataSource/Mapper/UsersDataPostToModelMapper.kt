package com.example.a24.a1_DataSource.Mapper

import com.example.a24.a1_DataSource.Model.UsersPost_DataSource_Model
import com.example.a24.a1_DataSource.Source.Model.UsersPosts_FromJSON_Model

class UsersDataPostToModelMapper {
    fun map(responses: List<UsersPosts_FromJSON_Model>?): List<UsersPost_DataSource_Model>? {
        return responses?.let {
            responses.map {
                UsersPost_DataSource_Model(
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
