package com.example.skillboost.model

data class User(
    val id: String,
    val email: String,
    val password: String,
    val isSignedIn: Boolean = false
)