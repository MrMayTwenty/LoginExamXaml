package com.aaa.loginexamxaml.data.remote

interface LoginApi {
    suspend fun login(username: String, password: String)
}