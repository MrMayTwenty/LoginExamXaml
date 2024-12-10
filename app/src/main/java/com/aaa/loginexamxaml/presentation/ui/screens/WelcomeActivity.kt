package com.aaa.loginexamxaml.presentation.ui.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aaa.loginexamxaml.R
import com.aaa.loginexamxaml.presentation.viewmodel.WelcomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : AppCompatActivity() {

    private val viewModel: WelcomeViewModel by viewModels()
    private lateinit var btnLogOut: Button
    private lateinit var btnBonus: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupUI()
        setupEvents()
    }

    private fun setupUI() {
        btnLogOut = findViewById(R.id.btnLogout)
        btnBonus = findViewById(R.id.btnBonus)
    }

    private fun setupEvents() {
        btnLogOut.setOnClickListener{
            viewModel.logout()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnBonus.setOnClickListener{
            val intent = Intent(this, BonusActivity::class.java)
            startActivity(intent)
        }
    }
}