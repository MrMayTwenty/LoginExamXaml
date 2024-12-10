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

    private val _loginValidation = MutableLiveData<Map<ValidationField,String>?>()
    val loginValidation: LiveData<Map<ValidationField,String>?> get() = _loginValidation

    private val _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean> get() = _loginStatus

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> get() = _loadingState

    fun login(username: String, password: String){
        viewModelScope.launch {
            _loadingState.value = true
            val error =  validateLogin(username, password)
            _loginValidation.value = error
            if(error == null){
                val response = loginRepository.login(username,password)
                _loginStatus.value = response.data
                if(!response.data)
                {
                    _loginValidation.value = mapOf(ValidationField.API to response.message)
                }
                _loadingState.value = false
            }else{
                _loadingState.value = false
            }
        }
    }


    private fun validateLogin(username: String, password: String) : Map<ValidationField,String>? {
        val errors = mutableMapOf<ValidationField,String>()
        if (username == "") {
            errors[ValidationField.USERNAME] = "Username is required"
        }
        if (password == "") {
            errors[ValidationField.PASSWORD] = "Password is required"
        }
        return if (errors.isEmpty()) null else errors
    }

    enum class ValidationField {
        USERNAME,
        PASSWORD,
        API
    }
}