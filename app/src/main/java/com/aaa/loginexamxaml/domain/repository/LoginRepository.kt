package com.aaa.loginexamxaml.domain.repository

interface LoginRepository {
    suspend fun login(username: String, password: String) :
    suspend fun getLogins()
}