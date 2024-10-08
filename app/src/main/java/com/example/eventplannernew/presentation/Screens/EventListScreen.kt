package com.example.eventplannernew.presentation.Screens
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eventplannernew.R
import java.util.*

@Composable
fun EventListScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val events = remember { mutableStateListOf<Event>() } // List to hold events

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            // Profile image at the top
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { navController.navigate("profile") }
            )

        Spacer(modifier = Modifier.height(16.dp))

        // Search bar
        BasicTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray),
            decorationBox = { innerTextField ->
                Box(Modifier.padding(8.dp)) {
                    if (searchQuery.isEmpty()) Text("Search events...")
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Add event button
        Button(
            onClick = { navController.navigate("createEventScreen") },
            modifier = Modifier.align(Alignment.End)
        ) {
           Icon(Icons.Rounded.Add, contentDescription = "Add Event")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Event list
        val filteredEvents = events.filter { it.title.contains(searchQuery, ignoreCase = true) }
        Column(Modifier.fillMaxWidth()) {
            filteredEvents.forEach { event ->
                EventCard(event)
            }
        }
    }
}

@Composable
fun EventCard(event: Event) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)) {
        Column(Modifier.padding(16.dp)) {
            Text(text = event.title, style = MaterialTheme.typography.displayMedium)
            Text(text = "Venue: ${event.venue}")
            Text(text = "Date: ${event.date}")
        }
    }
}

data class Event(val title: String, val venue: String, val date: String)

@Preview
@Composable
private fun EventListPreview() {
    EventListScreen(navController = rememberNavController())
}