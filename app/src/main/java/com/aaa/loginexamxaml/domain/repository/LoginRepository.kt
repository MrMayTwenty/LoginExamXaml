package com.aaa.loginexamxaml.domain.repository

import com.aaa.loginexamxaml.domain.model.BaseResponse
import com.aaa.loginexamxaml.domain.model.LoginCredentialModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(username: String, password: String):BaseResponse<Boolean>
    suspend fun getUsers(): BaseResponse<List<LoginCredentialModel>>
}