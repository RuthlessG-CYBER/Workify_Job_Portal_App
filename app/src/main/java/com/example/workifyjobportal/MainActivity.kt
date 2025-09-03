package com.example.workifyjobportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.workifyjobportal.Data.bottomNavItems
import com.example.workifyjobportal.Data.demoSliderData
import com.example.workifyjobportal.Data.jobList
import com.example.workifyjobportal.screens.JobUI
import com.example.workifyjobportal.screens.SplashScreenUI
import com.example.workifyjobportal.screens.jobApplied

import com.example.workifyjobportal.screens.myProfile
import com.example.workifyjobportal.screens.searchPannel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
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
            // protected routes
            composable("home") { JobUI(navController, data = data, jobs = jobs) }
            composable("search") { searchPannel(navController) }
            composable("applied") { jobApplied(navController) }
            composable("profile") { myProfile(navController) }
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
            .height(70.dp)
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

