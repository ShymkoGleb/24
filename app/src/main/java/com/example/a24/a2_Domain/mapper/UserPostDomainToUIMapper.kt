package com.example.a24.a2_Domain.mapper

import com.example.a24.a1_DataSource.model.UsersPostDataSourceModel
import com.example.a24.a2_Domain.UserRepository
import com.example.a24.a2_Domain.UserStatus
import com.example.a24.a3_UI.modelUi.UsersPostUIModel

class UserPostDomainToUIMapper(
    private val usersRepository: UserRepository
) {
    fun map(models: List<UsersPostDataSourceModel>?): List<UsersPostUIModel>? {
        return models?.let {
            models.map {
                if (it.userId in UserRepository.ListOfIdForUserWithWarning) {
                    UsersPostUIModel(
                        it.userId,
                        it.title,
                        it.body,
                        UserStatus.WARNING
                    )
                } else if (it.userId in UserRepository.ListOfIdForUserWithBann) {
                    UsersPostUIModel(
                        it.userId,
                        " ",
                        "Post from User ${it.userId} has been BANNED",
                        UserStatus.BANNED
                    )
                } else UsersPostUIModel(
                    it.userId,
                    it.title,
                    it.body,
                    UserStatus.NORMAL
                )
            }
        }
    }
}