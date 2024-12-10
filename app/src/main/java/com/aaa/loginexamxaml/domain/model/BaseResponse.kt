package com.aaa.loginexamxaml.domain.model

data class BaseResponse<T>(
    val statusCode: String,
    val message: String,
    val data: T
)

//