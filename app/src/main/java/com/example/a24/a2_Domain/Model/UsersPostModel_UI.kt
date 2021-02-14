package com.example.a24.a2_Domain.Model

import com.example.a24.a2_Domain.Mapper.UserStatus

class UsersPostModel_UI(
    private val id: Int?,
    private val userId: Int?,
    private val title: String?,
    private val body: String?,
    private val status: UserStatus
)
