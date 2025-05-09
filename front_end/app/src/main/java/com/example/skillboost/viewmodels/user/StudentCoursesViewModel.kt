package com.example.skillboost.viewmodel.user

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.skillboost.R
import com.example.skillboost.models.CourseStatus

class StudentCoursesViewModel : ViewModel() {

    // Backing state for the course list
    private val _courses = mutableStateListOf(
        CourseStatus("Fullstack web development", "This course will teach you all about frontend, backend development and more.", "Completed", R.drawable.rec_1),
        CourseStatus("YouTube for Beginners", "This course will teach you all about how to master and get your earnings from Youtube.", "Active", R.drawable.rec_2),
        CourseStatus("Kotlin app development", "This course will teach you the full android app development in kotlin.", "Enroll", R.drawable.rec_3),
        CourseStatus("Economics Essentials", "This course will teach you how to manage your financial resources.", "Enroll", R.drawable.rec_4),
        CourseStatus("Intro to Applied Math", "This course will teach you the basics of differential equations and integration", "Enroll", R.drawable.rec_5)
    )
    val courses: List<CourseStatus> = _courses

    fun deleteCourse(course: CourseStatus) {
        _courses.remove(course)
    }
}
