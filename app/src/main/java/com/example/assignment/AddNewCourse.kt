package com.example.assignment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.ui.theme.Primary
import java.io.File


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
            .fillMaxWidth()
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
            ) {
            TextFieldArea("Course Name")

            DropDownComponents("Add Thumbnail for your course") {
                FileUploadArea(
                    onFilesSelected = { files ->
                        println("Files selected in preview: ${files.size}")
                    }
                )
            }
            DropDownComponents("Add Videos") {
                FileUploadArea(
                    onFilesSelected = { files ->
                        println("Files selected in preview: ${files.size}")
                    }
                )
            }

            DropDownComponents("Add Notes") {
                FileUploadArea(
                    onFilesSelected = { files ->
                        println("Files selected in preview: ${files.size}")
                    }
                )
            }

            DropDownComponents("Add Assignments and Quizzes") {
                FileUploadArea(
                    onFilesSelected = { files ->
                        println("Files selected in preview: ${files.size}")
                    }
                )
            }



            SaveBtn("Save")
        }
    }
}



@Composable
fun TextFieldArea(text: String) {
    val name = remember { mutableStateOf("") }
    OutlinedTextField(
        value = name.value,
        onValueChange = { name.value = it },
        label = { Text(text) },
        singleLine = true,
        modifier = Modifier
            .size(width = 355.dp, height = 58.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF9B6ED8),
            unfocusedBorderColor = Color(0xFF884FD0),
            focusedLabelColor = Color(0xFF9B6ED8),
            cursorColor = Color(0xFF884FD0)
        ),
        shape = RoundedCornerShape(12.dp)
    )
}


@Composable
fun DropDownComponents(
    text: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {


    var isExpanded by remember { mutableStateOf(false) }


    Column(modifier = Modifier
        .padding(top = 32.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    if (!isExpanded) 1.dp else 2.dp,
                    color = if (!isExpanded) Color(0xFF884FD0) else Color(0xFF9B6ED8),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { isExpanded = !isExpanded }) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(end = 30.dp)) {
                Text(text,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold)
            }
            Image(if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = if (isExpanded) "Collapse" else "Expand")
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Box(modifier = Modifier
                .padding(top = 16.dp)) {
                content()
            }
        }

    }
}

@Composable
fun FileUploadArea(
    onFilesSelected: (List<File>) -> Unit,
    modifier: Modifier = Modifier
) {
    var isDragging by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                if (isDragging) Color.LightGray.copy(alpha = 0.3f)
                else Color.LightGray.copy(alpha = 0.1f),
                RoundedCornerShape(24.dp)
            )
            .border(
                BorderStroke(if (isDragging) 0.5.dp else 1.dp, if (isDragging) Color(0xFF9B6ED8) else Color(0xFF884FD0)),
                RoundedCornerShape(12.dp)
            )
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { isDragging = true },
                    onDragEnd = { isDragging = false },
                    onDragCancel = { isDragging = false },
                    onDrag = { change, _ ->
                        change.consume()
                    }
                )
            }
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {

            },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Drag/Drop files here",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold)
            Text("or click to browse", style = MaterialTheme.typography.bodySmall)
        }
    }
}


@Composable
fun FileProgress(
    text: String,
    icon: Int,
    modifier: Modifier = Modifier,
) {

    Column(modifier = Modifier
        .padding(top = 32.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,

                    color = Color.Black,
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color(0xFFF2E5FF))
                .padding(horizontal = 16.dp, vertical = 2.dp)
               ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(icon),
                    contentDescription = "icon",
                    modifier = Modifier
                        .size(32.dp)
                        .padding(end = 8.dp))
                Text(text,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold)
            }

            Image(Icons.Default.Check,
                contentDescription = "CheckedBtn")
        }

    }
}


@Composable
fun SaveBtn(text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /* Handle click */ },
            modifier = Modifier
                .padding(start = 8.dp, top = 16.dp, bottom = 16.dp)
                .wrapContentWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary,
                contentColor = Color.White
            )
        ) {
            Text(text,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}









