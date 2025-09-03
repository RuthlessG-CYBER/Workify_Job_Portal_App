package com.example.workifyjobportal.Data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Approval
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.workifyjobportal.R

// Slide Bar Data
data class CustomSliderElement(
    val title1 : String,
    val title2 : String,
    val subtitle1 : String,
    val subtitle2 : String,
    val image : Int
)
val demoSliderData = listOf(
    CustomSliderElement(
        title1 = "Discover top tech jobs",
        title2 = "in India",
        subtitle1 = "Stay updated with the latest roles",
        subtitle2 = "and companies",
        image = R.drawable.background
    ),
    CustomSliderElement(
        title1 = "Remote-friendly companies",
        title2 = "in India",
        subtitle1 = "Apply to remote jobs easily",
        subtitle2 = "and get hired",
        image = R.drawable.background_2
    ),
    CustomSliderElement(
        title1 = "Startup opportunities",
        title2 = "in India",
        subtitle1 = "Join innovative teams",
        subtitle2 = "and build your career",
        image = R.drawable.background_3
    )
)



data class JobListing(
    val company: String,
    val role: String,
    val location: String,
    val salaryRange: String,
    val jobType: String,
    val logoResId: Int, // R.drawable.xyz
    val isFreelance: Boolean
)
val jobList = listOf(
    JobListing(
        company = "Pensive",
        role = "Senior UI Designer",
        location = "Jakarta, Indonesia",
        salaryRange = "$4k - 8k",
        jobType = "Full time",
        logoResId = R.drawable.logo_1,
        isFreelance = false
    ),
    JobListing(
        company = "Advetic",
        role = "Senior UX Researcher",
        location = "New York, US",
        salaryRange = "$4k - 8k",
        jobType = "Freelance",
        logoResId = R.drawable.logo_1,
        isFreelance = true
    ),
    JobListing(
        company = "Heikyo Studio",
        role = "Graphic Designer",
        location = "Yogyakarta, Indonesia",
        salaryRange = "$4k - 8k",
        jobType = "Full time",
        logoResId = R.drawable.logo_1,
        isFreelance = false
    ),
    JobListing(
        company = "Pensive",
        role = "Senior UI Designer",
        location = "Jakarta, Indonesia",
        salaryRange = "$4k - 8k",
        jobType = "Full time",
        logoResId = R.drawable.logo_1,
        isFreelance = false
    ),
    JobListing(
        company = "Advetic",
        role = "Senior UX Researcher",
        location = "New York, US",
        salaryRange = "$4k - 8k",
        jobType = "Freelance",
        logoResId = R.drawable.logo_1,
        isFreelance = true
    ),
)


val bottomNavItems = listOf(
    BottomNavItem("Home", Icons.Default.Home, "home"),
    BottomNavItem("Profile", Icons.Default.Person, "profile"),
    BottomNavItem("jobApplied", Icons.Default.Approval, "applied"),
    BottomNavItem("Search", Icons.Default.Search, "search"),
    )

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)
