package com.shareskill.skillbooster

sealed class Screen(val route: String) {
    object Landing : Screen("landing")
    object RoleSelection : Screen("role_selection")
    object StudentHome : Screen("student_home")
    object TeacherHome : Screen("teacher_home")

}
