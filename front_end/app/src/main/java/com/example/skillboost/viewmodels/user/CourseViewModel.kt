package com.example.skillboost.viewmodel.user

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skillboost.data.CourseRepository
import com.example.skillboost.model.Course
import kotlinx.coroutines.launch

class CoursesViewModel(private val repository: CourseRepository = CourseRepository()) : ViewModel() {
    var courses = mutableStateOf<List<Course>>(emptyList())
        private set

    init {
        fetchCourses()
    }

    private fun fetchCourses() {
        viewModelScope.launch {
            courses.value = repository.fetchCourses()
        }
    }
}