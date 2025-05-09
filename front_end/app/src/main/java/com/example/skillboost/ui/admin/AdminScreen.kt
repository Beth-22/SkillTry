package com.example.skillboost.ui.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.skillboost.R
import com.example.skillboost.ui.admin.Screen

@Composable
fun AdminScreen(navController: NavController) {
    var name by remember { mutableStateOf("Sophia Laurent") }
    var email by remember { mutableStateOf("youremail@gmail.com") }
    var username by remember { mutableStateOf("@Sophia_design") }
    var password by remember { mutableStateOf("password") }
    var job by remember { mutableStateOf("Senior UI/UX Designer") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F4FC))
            .padding(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Button(
                onClick = {
                    navController.navigate(Screen.AdminEdit.route) // Navigate to Edit Screen
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C6ADE)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Edit Profile")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = rememberAsyncImagePainter(
                    model = "https://example.com/profile_image.jpg", // Change with actual URL or resource
                    placeholder = painterResource(id = R.drawable.sophia_image), // Adjust image resource
                    error = painterResource(id = R.drawable.sophia_image) // Adjust image resource
                ),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(2.dp))

            AdminField(label = "Name", value = name, onValueChange = { name = it })
            AdminField(label = "Job", value = job, onValueChange = { job = it })
            AdminField(label = "Email", value = email, onValueChange = { email = it })
            AdminField(label = "Username", value = username, onValueChange = { username = it })
            AdminField(label = "Password", value = password, onValueChange = { password = it }, isPassword = true)

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Save changes logic here */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C6ADE)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Save changes")
            }
        }
    }
}

@Composable
fun AdminField(label: String, value: String, onValueChange: (String) -> Unit, isPassword: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF1E7FA))
                .padding(0.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAdminScreen() {
    val mockNavController = rememberNavController()
    AdminScreen(navController = mockNavController)
}
