package com.aaa.loginexamxaml.data.mock

import com.aaa.loginexamxaml.domain.model.LoginCredentialModel

class LoginCredentialsMock {
    companion object {
        val mockData = listOf(
            LoginCredentialModel("admin", "admin"),
            LoginCredentialModel("guest", "guest123"),
            LoginCredentialModel("testuser", "test123"),
            LoginCredentialModel("developer", "dev123"),
            LoginCredentialModel("manager", "mgr123"),
            LoginCredentialModel("support", "sup123"),
            LoginCredentialModel("user123", "password123"),
            LoginCredentialModel("employee", "emp123"),
            LoginCredentialModel("customer", "cust123"),
            LoginCredentialModel("owner", "own123")
        )
    }
}