package com.aaa.loginexamxaml.data.repository

import com.aaa.loginexamxaml.data.mock.LoginCredentialsMock
import com.aaa.loginexamxaml.data.remote.LoginApi
import com.aaa.loginexamxaml.domain.model.BaseResponse
import com.aaa.loginexamxaml.domain.model.LoginCredentialModel
import com.aaa.loginexamxaml.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi
): LoginRepository {
    override suspend fun login(username: String, password: String): BaseResponse<Boolean> {
        return loginApi.login(username,password)
    }

    override suspend fun getUsers(): BaseResponse<List<LoginCredentialModel>> {
        return loginApi.getAllLoginData()
    }


}