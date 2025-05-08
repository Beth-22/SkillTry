package com.example.assignment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment.ui.theme.Primary


@Preview
@Composable
fun AddNewCourse_preview() {
    AddNewCourse()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewCourse(modifier: Modifier = Modifier) {
    var changeableRoute = remember { mutableStateOf(Routes.HomePage.route) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { AppTitle("Add New Course") },
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
        Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
            .padding(it)
            .fillMaxWidth()) {
            TextFieldArea()
        }
    }
}



@Composable
fun TextFieldArea () {
    var name = remember { mutableStateOf("") }

    Column {
        Text("Hello ${name.value}",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Green)
                .border(BorderStroke(4.dp, Color.Red))
                .padding(4.dp))

        TextField(value = name.value, onValueChange = { name.value = it },
            placeholder = {Text("Course Name")},
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .border(1.dp, Color.Black, RoundedCornerShape(16.dp))

        )
    }
}





