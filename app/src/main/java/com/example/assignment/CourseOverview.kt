package com.example.assignment

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.ui.theme.Primary


@Preview
@Composable
fun CourseOverview_preview() {
    CourseOverview()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseOverview(modifier: Modifier = Modifier) {
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
            LessonsUploaded()
        }
    }
}

@Composable
fun AppTitle(text: String,modifier: Modifier = Modifier) {
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
        .padding(8.dp)){
        Image(
            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
            contentDescription = "KeyboardArrowLeft",
            colorFilter = ColorFilter.tint(
                Color.White
            ),
            modifier = Modifier
                .size(32.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

