package com.shareskill.skillbooster.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.shareskill.skillbooster.R
import com.shareskill.skillbooster.components.Course

class StudentCoursesViewModel : ViewModel() {

    // Backing state for the course list
    private val _courses = mutableStateListOf(
        Course("Fullstack web development", "This course will teach you all about frontend, backend development and more.", "Completed", R.drawable.rec_1),
        Course("YouTube for Beginners", "This course will teach you all about how to master and get your earnings from Youtube.", "Active", R.drawable.rec_2),
        Course("Kotlin app development", "This course will teach you the full android app development in kotlin.", "Enroll", R.drawable.rec_3),
        Course("Economics Essentials", "This course will teach you how to manage your financial resources.", "Enroll", R.drawable.rec_4),
        Course("Intro to Applied Math", "This course will teach you the basics of differential equations and integration", "Enroll", R.drawable.rec_5)
    )
    val courses: List<Course> = _courses

    fun deleteCourse(course: Course) {
        _courses.remove(course)
    }
}
