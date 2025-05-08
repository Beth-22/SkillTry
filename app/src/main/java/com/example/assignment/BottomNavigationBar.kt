package com.example.assignment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.ui.theme.Primary

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {

    val HomePage = NavPage("Home", Icons.Outlined.Home, "home")
    val MenuPage = NavPage("Menu", Icons.Outlined.Menu, "menu")
    val ProfilePage = NavPage("Profile", Icons.Outlined.Person, "profile")

    val pages = listOf(HomePage, MenuPage, ProfilePage)
}

@Composable
fun NavBar(selectedRoute: String = Routes.MenuPage.route, onChange: (String) -> Unit) {
    Row(horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .background(Primary)
            .padding(16.dp)) {
        for (page in Routes.pages) {
            NavBarItem(
                page,
                selected = selectedRoute == page.route,
                modifier = Modifier.clickable {
                    onChange(page.route)
                }
            )
        }
    }
}



@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 16.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Color.White else Color.Black
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(32.dp)
        )

    }
}