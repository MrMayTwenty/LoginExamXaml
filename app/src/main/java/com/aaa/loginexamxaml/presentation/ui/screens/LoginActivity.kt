package com.aaa.loginexamxaml.presentation.ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aaa.loginexamxaml.R
import com.aaa.loginexamxaml.presentation.viewmodel.LoginViewModel
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var etPassword: EditText
    private lateinit var etLayoutPassword: TextInputLayout
    private lateinit var etUsername: EditText
    private lateinit var etLayoutUsername: TextInputLayout
    private lateinit var tvError: TextView
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupUI()
        setupEvents()

        viewModel.loginValidation.observe(this) {
            val errors = it
            errors?.forEach { (field, message) ->
                when (field) {
                    LoginViewModel.ValidationField.USERNAME -> etLayoutUsername.error = message
                    LoginViewModel.ValidationField.PASSWORD -> etLayoutPassword.error = message
                    else -> {
                        tvError.visibility = TextView.VISIBLE
                        tvError.text = message
                    }
                }
            }
        }

        viewModel.loginStatus.observe(this) {
            if (it) {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        viewModel.loadingState.observe(this) {
            if (it) {
                btnLogin.text = this.getString(R.string.loading)
            } else {
                btnLogin.text = this.getString(R.string.login)
            }
        }
    }

    private fun setupUI() {
        tvError = findViewById(R.id.tvError)
        etLayoutUsername = findViewById(R.id.usernameLayout)
        etLayoutPassword = findViewById(R.id.passwordLayout)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun setupEvents() {
        btnLogin.setOnClickListener {
            val userName = etUsername.text.toString()
            val password = etPassword.text.toString()
            tvError.visibility = TextView.GONE
            viewModel.login(userName,password)
        }
    }


}