package com.aaa.loginexamxaml.data.remote

import kotlinx.coroutines.delay

class LoginApiImpl: LoginApi {
    override suspend fun login(username: String, password: String) {
        delay(3000)
    }
}