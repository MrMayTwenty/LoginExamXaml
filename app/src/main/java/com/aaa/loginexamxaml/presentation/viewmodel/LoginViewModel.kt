package com.aaa.loginexamxaml.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaa.loginexamxaml.domain.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loginValidation = MutableLiveData<String?>()
    val loginValidation: LiveData<String?> get() = _loginValidation

    private val _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean> get() = _loginStatus

    fun login(username: String, password: String){
        viewModelScope.launch {
            val error =  validateLogin(username, password)
            _loginValidation.value = error
            if(error == null){
                val response = loginRepository.login(username,password)
                _loginStatus.value = response.data
            }
        }
    }

    private fun validateLogin(username: String, password: String) : String?{
        if (username == "" && password == ""){
            return "Username and Password is required"
        }
        if(username == ""){
            return "Username is required"
        }
        if(password == ""){
            return "Password is required"
        }
        return null
    }

}