package com.aaa.loginexamxaml.data.remote

import com.aaa.loginexamxaml.domain.model.BaseResponse
import com.aaa.loginexamxaml.domain.model.LoginCredentialModel

interface LoginApi {

    //If Retrofit is used
    //@POST("/login")
    suspend fun login(username: String, password: String): BaseResponse<Boolean>
    //@GET("/login")
    suspend fun getAllLoginData(): BaseResponse<List<LoginCredentialModel>>
}