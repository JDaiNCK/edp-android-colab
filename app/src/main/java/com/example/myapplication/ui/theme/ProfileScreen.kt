package com.example.myapplication.ui.theme

import com.example.myapplication.ui.PostsViewModel
import com.example.myapplication.ui.ThemeViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ProfileScreen(postsVm: PostsViewModel, themeVm: ThemeViewModel) {
    val posts by postsVm.posts.collectAsStateWithLifecycle()
    val isDarkTheme by themeVm.isDarkTheme.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "My Profile",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Total Posts: ${posts.size}",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Dark Theme")
            Spacer(Modifier.width(8.dp))
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { themeVm.onThemeChanged(it) }
            )
        }
    }
}
