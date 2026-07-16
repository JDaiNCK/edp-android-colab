package com.example.myapplication.ui.theme

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profileapp.ui.theme.ProfileTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Profile", style = MaterialTheme.typography.titleLarge) }, //[cite: 1]
                navigationIcon = {
                    IconButton(onClick = { /* Navigation action */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Overflow action */ }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More Options")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer //[cite: 1]
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Add action */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp) //[cite: 1]
        ) {

            Box(contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .border(2.dp, MaterialTheme.colorScheme.onSurfaceVariant, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Avatar",
                        modifier = Modifier.size(60.dp),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.BottomEnd)
                        .clip(CircleShape)
                        .background(Color.Green)
                        .border(2.dp, MaterialTheme.colorScheme.surface, CircleShape)
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Ada Lovelace",
                    style = MaterialTheme.typography.headlineSmall //[cite: 1]
                )
                Text(
                    text = "Android Developer",
                    style = MaterialTheme.typography.bodyMedium, //[cite: 1]
                    color = MaterialTheme.colorScheme.onSurfaceVariant //[cite: 1]
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp) //[cite: 1]
            ) {
                Button(
                    onClick = { /* Message action */ },
                    modifier = Modifier.weight(1f) //[cite: 1]
                ) {
                    Text("Message")
                }
                OutlinedButton(
                    onClick = { /* Follow action */ },
                    modifier = Modifier.weight(1f) //[cite: 1]
                ) {
                    Text("Follow")
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly //[cite: 1]
                ) {
                    StatColumn(value = "128", label = "Posts")
                    StatColumn(value = "4.2k", label = "Followers")
                    StatColumn(value = "96", label = "Following")
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // Email Row
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Email",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(8.dp)) //[cite: 1]
                        Text(
                            text = "ada@compute.org",
                            style = MaterialTheme.typography.bodyMedium //[cite: 1]
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp)) // Spacer between rows[cite: 1]

                    // Location Row
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(8.dp)) //[cite: 1]
                        Text(
                            text = "London, United Kingdom",
                            style = MaterialTheme.typography.bodyMedium //[cite: 1]
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatColumn(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, style = MaterialTheme.typography.titleMedium)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenLightPreview() {
    ProfileTheme(darkTheme = false) { //[cite: 1]
        Surface(color = MaterialTheme.colorScheme.surface) {
            ProfileScreen()
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES) //[cite: 1]
@Composable
fun ProfileScreenDarkPreview() {
    ProfileTheme(darkTheme = true) { //[cite: 1]
        Surface(color = MaterialTheme.colorScheme.surface) {
            ProfileScreen()
        }
    }
}