package com.example.skillboost.ui.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.skillboost.R
import com.example.skillboost.ui.common.AdminCourseCard
import com.example.skillboost.viewmodel.admin.AdminCoursesViewModel

@Composable
fun AdminHomePage(navController: NavHostController, viewModel: AdminCoursesViewModel = viewModel()) {
    val courses = viewModel.courses

    Scaffold(
        bottomBar = {
            BottomNavigationAdmin(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color(0xFF9B6ED8)),
                contentAlignment = Alignment.TopStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 2.dp, top = 14.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.circular_logo),
                        contentDescription = "App Logo",
                        modifier = Modifier.size(60.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "SkillBoost",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Learning App",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Welcome back Sophia!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Courses Uploaded",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                courses.forEach { course ->
                    AdminCourseCard(
                        course = course,
                        onDelete = { viewModel.deleteCourse(course) }
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* Add course logic can be added here */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 65.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B5CF6)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Add New Course", color = Color.White)
            }
        }
    }
}