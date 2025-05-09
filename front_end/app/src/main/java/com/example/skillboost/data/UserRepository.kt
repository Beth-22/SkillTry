package com.example.skillboost.data

import android.content.Context
import com.example.skillboost.model.User
import java.util.UUID

class UserRepository(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("auth", Context.MODE_PRIVATE)

    suspend fun signup(email: String, password: String, confirmPassword: String): String? {
        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            return "Please fill all fields."
        }
        if (password != confirmPassword) {
            return "Passwords do not match."
        }
        // TODO: Implement backend API call for signup
        // Example: Send email, password to backend and receive user ID, token
        try {
            // Mock response for testing
            val mockResponse = AuthResponse(
                id = UUID.randomUUID().toString(),
                token = "mock_token_${email}",
                success = true
            )
            sharedPreferences.edit()
                .putString("user_id", mockResponse.id)
                .putString("token", mockResponse.token)
                .apply()
            return null
        } catch (e: Exception) {
            return "Error: ${e.message}"
        }
    }

    suspend fun login(email: String, password: String): String? {
        if (email.isBlank() || password.isBlank()) {
            return "Please fill all fields."
        }
        // TODO: Implement backend API call for login
        // Example: Send email, password to backend and receive user ID, token
        try {
            // Mock response for testing
            val mockResponse = AuthResponse(
                id = UUID.randomUUID().toString(),
                token = "mock_token_${email}",
                success = true
            )
            sharedPreferences.edit()
                .putString("user_id", mockResponse.id)
                .putString("token", mockResponse.token)
                .apply()
            return null
        } catch (e: Exception) {
            return "Error: ${e.message}"
        }
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getString("token", null) != null
    }

    fun getUser(email: String): User? {
        val userId = sharedPreferences.getString("user_id", null)
        return if (userId != null && isLoggedIn()) {
            User(id = userId, email = email, password = "", isSignedIn = true)
        } else {
            null
        }
    }

    fun isUserSignedIn(email: String): Boolean {
        return isLoggedIn() && getUser(email) != null
    }

    fun addUser(email: String, password: String): Boolean {
        // TODO: Implement backend API call to add user
        try {
            val mockResponse = AuthResponse(
                id = UUID.randomUUID().toString(),
                token = "mock_token_${email}",
                success = true
            )
            sharedPreferences.edit()
                .putString("user_id", mockResponse.id)
                .putString("token", mockResponse.token)
                .apply()
            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun loginUser(email: String, password: String): Boolean {
        // TODO: Implement backend API call to login user
        try {
            val mockResponse = AuthResponse(
                id = UUID.randomUUID().toString(),
                token = "mock_token_${email}",
                success = true
            )
            sharedPreferences.edit()
                .putString("user_id", mockResponse.id)
                .putString("token", mockResponse.token)
                .apply()
            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun clearSession() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }
}

data class AuthResponse(val id: String, val token: String, val success: Boolean)