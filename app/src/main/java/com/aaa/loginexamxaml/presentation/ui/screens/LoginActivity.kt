package com.aaa.loginexamxaml.presentation.ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aaa.loginexamxaml.R
import com.aaa.loginexamxaml.presentation.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels<LoginViewModel>()

    private val etUsername: EditText = findViewById(R.id.etUsername)
    private val etPassword: EditText = findViewById(R.id.etPassword)
    private val btnLogin: Button = findViewById(R.id.btnLogin)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupEvents()

        viewModel.loginValidation.observe(this) {
            if (it != null) {
                etUsername.error = it
            }
        }

        viewModel.loginStatus.observe(this) {
            if (it) {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun setupEvents() {
        btnLogin.setOnClickListener {
            val userName = etUsername.text.toString()
            val password = etPassword.text.toString()
            viewModel.login(userName,password)
        }
    }


}