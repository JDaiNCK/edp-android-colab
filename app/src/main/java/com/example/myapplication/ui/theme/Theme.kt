package com.example.profileapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val LightColors = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    secondary = LightSecondary,
    surface = LightSurface,
    onSurfaceVariant = LightOnSurfaceVariant
) //[cite: 1]

private val DarkColors = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    secondary = DarkSecondary,
    surface = DarkSurface,
    onSurfaceVariant = DarkOnSurfaceVariant
) //[cite: 1]

@Composable
fun ProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors //[cite: 1]

    // Customize titleLarge to be bold as specified[cite: 1]
    val typography = Typography(
        titleLarge = Typography().titleLarge.copy(fontWeight = FontWeight.Bold)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = Shapes(medium = RoundedCornerShape(16.dp)), // Cards use medium shape[cite: 1]
        content = content
    ) //[cite: 1]
}