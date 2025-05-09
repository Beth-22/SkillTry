package com.example.skillboost.ui.admin

sealed class Screen(val route: String) {
    object LandingPage : Screen("landingPage")
    object RoleSelection : Screen("roleSelection")
    object LoginScreen : Screen("loginScreen")
    object SignUpScreen : Screen("signUpScreen")
    object HomeScreen : Screen("homeScreen")
    object SearchScreen : Screen("searchScreen")
    object ProfileScreen : Screen("profileScreen")
    object StudentCourse : Screen("studentCourse")
    object StudentProfileScreen : Screen("studentProfileScreen")
    object AdminDashboard : Screen("adminDashboard")
    object AdminCourse : Screen("adminCourse")
    object AdminCourseManagement : Screen("adminCourseManagement")
    object AdminProfile : Screen("admin_profile")
    object AdminEdit : Screen("admin_edit")
    object CourseDetails : Screen("courseDetails/{courseId}") {
        fun createRoute(courseId: Int) = "courseDetails/$courseId"
    }
    object AdminCourseDetails : Screen("adminCourseDetails/{courseId}") {
        fun createRoute(courseId: Int) = "adminCourseDetails/$courseId"
    }
    object EditCourse : Screen("editCourse/{courseId}") {
        fun createRoute(courseId: Int) = "editCourse/$courseId"
    }
}