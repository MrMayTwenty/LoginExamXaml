package com.aaa.loginexamxaml.data.remote

import com.aaa.loginexamxaml.domain.model.BaseResponse
import com.aaa.loginexamxaml.domain.model.LoginCredentialModel

interface LoginApi {
    suspend fun login(username: String, password: String): BaseResponse<Boolean>
    suspend fun getAllLoginData(): BaseResponse<List<LoginCredentialModel>>
}