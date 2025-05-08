package com.shareskill.skillbooster.viewmodel


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.shareskill.skillbooster.R

data class AdminCourse(
    val title: String,
    val description: String,
    val status: String,
    val imageRes: Int
)
class AdminCoursesViewModel : ViewModel() {

    private val _courses = mutableStateListOf(
        AdminCourse("Fullstack web development", "This course has all about frontend, backend development and more.", "Explore", R.drawable.rec_1),
        AdminCourse("YouTube for Beginners", "This course has all about how to master and get your earnings from Youtube.", "Explore", R.drawable.rec_2),
        AdminCourse("Figma master class for beginners", "This course has all about how to master figma for UI/ UX design.", "Explore", R.drawable.rec_6)
    )
    val courses: List<AdminCourse> = _courses

    fun deleteCourse(course: AdminCourse) {
        _courses.remove(course)
    }

    // For future addCourse()
}
