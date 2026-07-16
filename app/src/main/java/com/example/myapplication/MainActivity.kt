package com.example.myapplication

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.compose.material3.Icon
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val isDark = isSystemInDarkTheme()

    val backgroundColor = if (isDark) Color(0xFF121212) else Color(0xFFF8F9FA)
    val cardBackgroundColor = if (isDark) Color.Black else Color.White
    val accentColor = if (isDark) Color.Red else Color(0xFF5E8AE7)
    val secondaryAccentColor = if (isDark) Color(0xFF8B0000) else Color(0xFF0323F1)
    val textColor = if (isDark) Color.White else Color(0xFF1A1C1E)
    val subtitleColor = Color.Gray

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .shadow(elevation = 16.dp, shape = RoundedCornerShape(28.dp)),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = cardBackgroundColor)
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .background(accentColor)
                ) {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .offset(x = 220.dp, y = (-20).dp)
                            .clip(CircleShape)
                            .background(secondaryAccentColor)
                    )
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .offset(x = 100.dp, y = 70.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.3f))
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .offset(y = (-50).dp)
                            .size(110.dp)
                            .clip(CircleShape)
                            .background(cardBackgroundColor)
                            .border(4.dp, accentColor, CircleShape)
                            .padding(4.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.jd),
                            contentDescription = "Profile Photo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )
                    }

                    Column(modifier = Modifier.offset(y = (-40).dp)) {
                        Text(
                            text = "Josh Daniel Uy",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = textColor
                        )
                        Text(
                            text = "Quality Assurance",
                            fontSize = 16.sp,
                            color = subtitleColor
                        )

                        Spacer(Modifier.height(24.dp))

                        ContactRow(
                            icon = Icons.Default.Phone,
                            label = "Phone",
                            value = "09452365444",
                            accentColor = accentColor,
                            textColor = textColor,
                            onClickLabel = "Call Josh"
                        )
                        ContactRow(
                            icon = Icons.Default.Email,
                            label = "Email",
                            value = "juy62610@liceo.edu.ph",
                            accentColor = accentColor,
                            textColor = textColor,
                            onClickLabel = "Email Josh"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ContactRow(
    icon: ImageVector,
    label: String,
    value: String,
    accentColor: Color,
    textColor: Color,
    onClickLabel: String
) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .semantics {
                onClick(label = onClickLabel) { true }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(accentColor.copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = accentColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(Modifier.width(16.dp))

        Column {
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )
        }
    }
}

@Preview(name = "Light Mode", showBackground = true, widthDp = 360)
@Composable
fun BusinessCardPreview() {
    MyApplicationTheme(darkTheme = false) {
        BusinessCard()
    }
}

@Preview(name = "Dark Mode", showBackground = true, widthDp = 360, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BusinessCardDarkPreview() {
    MyApplicationTheme(darkTheme = true) {
        BusinessCard()
    }
}

@Preview(name = "Large Font", showBackground = true, widthDp = 360, fontScale = 1.5f)
@Composable
fun BusinessCardFontPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}
