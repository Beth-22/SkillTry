package com.shareskill.skillbooster

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.shareskill.skillbooster.components.CourseCard
import com.shareskill.skillbooster.viewmodel.StudentCoursesViewModel

@Composable
fun StudentCoursesScreen(
    navController: NavHostController,
    viewModel: StudentCoursesViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // Header
        Header()

        // Courses List
        Spacer(modifier = Modifier.height(64.dp))
        CourseList(
            courses = viewModel.courses,
            onDelete = { viewModel.deleteCourse(it) }
        )
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFF9B6ED8)),
        contentAlignment = Alignment.TopStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, top = 14.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.circular_logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Courses",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun CourseList(courses: List<com.shareskill.skillbooster.components.Course>, onDelete: (com.shareskill.skillbooster.components.Course) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        courses.forEach { course ->
            CourseCard(course = course, onDelete = { onDelete(course) })
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
