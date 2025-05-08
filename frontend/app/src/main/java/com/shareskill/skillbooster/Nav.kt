package com.shareskill.skillbooster


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Landing.route,
        modifier = modifier
    ) {
        composable(Screen.Landing.route) {
            LandingPage(
                onGetStartedClick = {
                    navController.navigate(Screen.RoleSelection.route)
                }
            )
        }
        composable(Screen.RoleSelection.route) {
            RoleSelectionScreen(navController)
        }
        composable(Screen.StudentHome.route) {
            StudentCoursesScreen(navController)
        }
        composable(Screen.TeacherHome.route) {
            AdminHomePage(navController)
        }
    }
}

@Composable
fun DummyScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = title)
    }
}
