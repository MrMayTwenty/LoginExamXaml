package com.aaa.loginexamxaml.data.remote

import com.aaa.loginexamxaml.data.mock.LoginCredentialsMock
import com.aaa.loginexamxaml.domain.model.BaseResponse
import com.aaa.loginexamxaml.domain.model.LoginCredentialModel
import kotlinx.coroutines.delay

//Since Retrofit is not used we created a mock API for now
class LoginApiImpl: LoginApi {
    override suspend fun login(username: String, password: String): BaseResponse<Boolean> {
        delay(3000)
        //Check if username and password is existing in the mock
        val loginCredentials = LoginCredentialsMock.mockData.find { it.userName == username && it.password == password }
        if (loginCredentials != null){
            return BaseResponse("200", "Login Success", true)
        }
        return BaseResponse("404", "User not found", false)
    }

    override suspend fun getAllLoginData(): BaseResponse<List<LoginCredentialModel>> {
        delay(3000)
        val loginCredentials = LoginCredentialsMock.mockData
        return BaseResponse("200", "Login Data Retrieved", loginCredentials)
    }
}