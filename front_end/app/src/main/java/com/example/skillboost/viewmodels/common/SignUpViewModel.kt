package com.example.skillboost.viewmodel.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillboost.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignUpViewModel(private val repository: UserRepository) : ViewModel() {
    private val _signupState = MutableStateFlow<SignUpState>(SignUpState.Idle)
    val signupState: StateFlow<SignUpState> = _signupState

    fun signUp(email: String, password: String, confirmPassword: String) {
        viewModelScope.launch {
            _signupState.value = SignUpState.Loading
            val result = repository.signup(email, password, confirmPassword)
            _signupState.value = if (result == null) {
                SignUpState.Success
            } else {
                SignUpState.Error(result)
            }
        }
    }

    fun clearSignupState() {
        _signupState.value = SignUpState.Idle
    }
}

sealed class SignUpState {
    object Idle : SignUpState()
    object Loading : SignUpState()
    object Success : SignUpState()
    data class Error(val message: String) : SignUpState()
}