package com.example.eventplannernew.presentation.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eventplannernew.R

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9)), // Light green background
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Welcome to Event Planner",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20) // Dark green text
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.eventimage),
                contentDescription = "Event Planner Logo",
                modifier = Modifier.size(300.dp)
            )
            Text(
                text = "Plan your perfect event with ease and style.",
                fontSize = 18.sp,
                color = Color(0xFF424242) // Dark grey text
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { navController.navigate("sign_in") },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) // Green button
            ) {
                Text(
                    text = "Get Started",
                    color = Color.White,
                    fontSize = 18.sp,

                )
            }
        }
    }
}

@Preview
@Composable
private fun WelcomePreview() {
    val navController=rememberNavController()
    WelcomeScreen(navController)
}