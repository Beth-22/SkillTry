// AdminProfileViewModel.kt
package com.example.skillboost.viewmodel.admin

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class AdminProfileViewModel : ViewModel() {
    private val _coursesCreated = mutableStateOf(5) // Default value set to 5 for testing
    val coursesCreated: State<Int> = _coursesCreated

    // You can update the course count dynamically
    fun setCoursesCount(count: Int) {
        _coursesCreated.value = count
    }
}
