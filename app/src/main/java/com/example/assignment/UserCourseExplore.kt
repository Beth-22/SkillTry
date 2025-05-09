package com.example.assignment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment.ui.theme.Primary

@Preview
@Composable
fun UserCourseExplore_preview() {
    UserCourseExplore()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCourseExplore(modifier: Modifier = Modifier) {
    var changeableRoute = remember { mutableStateOf(Routes.HomePage.route) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { AppTitle("Course Overview") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary
                ))
        },
        bottomBar = {
            NavBar(
                selectedRoute = changeableRoute.value,
                onChange = {
                    changeableRoute.value = it
                })
        }
    ) {
        Column(modifier = Modifier
            .padding(it)) {
            CourseDetail("Figma Master Class for Beginners", "28")
        }
    }
}