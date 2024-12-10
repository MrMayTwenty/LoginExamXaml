package com.aaa.loginexamxaml.data.repository

import com.aaa.loginexamxaml.data.remote.LoginApi
import com.aaa.loginexamxaml.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi
): LoginRepository {
    override suspend fun login(username: String, password: String) {
        loginApi.login(username,password)
    }

    override suspend fun getLogins() {

    }
}