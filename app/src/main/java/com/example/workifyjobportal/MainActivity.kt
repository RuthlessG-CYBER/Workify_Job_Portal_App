package com.example.workifyjobportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.workifyjobportal.Authentication.LoginScreen
import com.example.workifyjobportal.Authentication.SignupScreen
import com.example.workifyjobportal.Data.CustomSliderElement
import com.example.workifyjobportal.Data.JobListing
import com.example.workifyjobportal.Data.demoSliderData
import com.example.workifyjobportal.Data.jobList
import com.example.workifyjobportal.ui.theme.WorkifyJobPortalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkifyJobPortalTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation(
    data: List<CustomSliderElement> = demoSliderData,
    jobs: List<JobListing> = jobList
) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val showBottomBar = currentRoute == "home"

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(
                    navController = navController,
                    currentRoute = currentRoute
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "welcome",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("welcome") { SplashScreenUI(navController) }
            composable("login") { LoginScreen(navController) }
            composable("signup") { SignupScreen(navController) }
            composable("home") {
                JobUI(data = data, jobs = jobs)
            }
        }
    }
}



@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    currentRoute: String?
) {

    NavigationBar(
        modifier = Modifier
            .height(70.dp)  // ✅ Fixed height
            .fillMaxWidth(),
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        bottomNavItems.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route)
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.route,
                        tint = if (selected) Color(0xFF4B79F1) else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFE0ECFB)
                )
            )
        }
    }
}


val bottomNavItems = listOf(
    BottomNavItem("Welcome", Icons.Default.EmojiPeople, "welcome"),
    BottomNavItem("Login", Icons.Default.Login, "login"),
    BottomNavItem("Signup", Icons.Default.PersonAdd, "signup"),
    BottomNavItem("Home", Icons.Default.Home, "home")
)

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)
