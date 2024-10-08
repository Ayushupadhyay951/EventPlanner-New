package com.example.eventplannernew.presentation.Screens

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CreateEventScreen(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var venue by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = venue,
            onValueChange = { venue = it },
            label = { Text("Venue") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date (e.g. 12/12/2024)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Create a new event and navigate back to the event list
                val newEvent = Event(title, venue, date)
                // Passing the event to the previous screen via NavController would require state hoisting
                navController.popBackStack() // Go back to the Event List screen
            },
            modifier = Modifier.align(alignment= androidx.compose.ui.Alignment.End)
        ) {
            Text("Add Event")
        }
    }
}
