package com.shareskill.skillbooster


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
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
import com.shareskill.skillbooster.components.AdminCourseCard
import com.shareskill.skillbooster.viewmodel.AdminCoursesViewModel

@Composable
fun AdminHomePage(navController: NavHostController, viewModel: AdminCoursesViewModel= viewModel()) {
    val courses = viewModel.courses

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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

