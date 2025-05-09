package com.example.skillboost.ui.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.skillboost.R

@Composable
fun AdminProfileScreen(
    navController: NavController,
    coursesCreated: Int
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F4FC))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(123.dp)
                    .background(Color(0xFF9C6ADE)) // Purple banner
            )
            Spacer(modifier = Modifier.height(84.dp)) // Space below image
        }

        // Profile Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 41.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.sophia_image),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Sophia Laurent",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color(0xFF746868),
                modifier = Modifier.padding(top = 2.dp)
            )

            Text(
                text = "Senior UI/UX Designer",
                fontSize = 16.sp,
                color = Color(0xFF746868),
                modifier = Modifier.padding(top = 2.dp)
            )

            Text(
                text = "\"designs that feel as good as they look\"",
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF746868),
                modifier = Modifier.padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Edit Profile Button
            Button(
                onClick = { navController.navigate("admin_edit") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF884FD0)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(30.dp)
                    .shadow(6.dp, shape = RoundedCornerShape(20.dp))
            ) {
                Text("Edit Profile")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Achievements Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 2.dp)
                    .height(80.dp)
                    .clickable { /* TODO: Open achievements */ },
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1E7FA)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_courses),
                        contentDescription = "Courses Icon",
                        tint = Color(0xFF9C6ADE),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Courses created: $coursesCreated",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color(0xFF746868)
                    )
                }
            }

            // Logout Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 15.dp)
                    .height(80.dp)
                    .clickable { /* TODO: Log out */ },
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1E7FA)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logout),
                        contentDescription = "Logout Icon",
                        tint = Color(0xFF9C6ADE),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Logout",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color(0xFF746868)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAdminProfileScreen() {
    val navController = rememberNavController()
    AdminProfileScreen(navController = navController, coursesCreated = 5)
}
