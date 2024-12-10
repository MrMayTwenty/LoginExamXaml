package com.aaa.loginexamxaml.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(): ViewModel() {

    fun logout(){
        //TODO: API wise, this should dispose any caches and tokens for the user
    }
}