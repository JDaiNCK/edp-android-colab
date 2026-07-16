package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val backgroundGradient = Brush.radialGradient(
        colors = listOf(
            Color(0xFF0F5A36),
            Color(0xFF02140D)
        ),
        radius = 1200f
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(135.dp)
                .shadow(16.dp, CircleShape)
                .clip(CircleShape)
                .border(3.dp, Color(0xFF69F0AE), CircleShape)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Jhonmark Tecson Lumacang",
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 28.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "GTM ENGINEER",
            color = Color(0xFF69F0AE),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 4.sp
        )

        Spacer(modifier = Modifier.height(36.dp))

        Card(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .width(IntrinsicSize.Max)
                .shadow(10.dp, RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0x1AFFFFFF)
            ),
            border = BorderStroke(
                width = 1.dp,
                brush = Brush.verticalGradient(listOf(Color(0x4DFFFFFF), Color(0x13FFFFFF)))
            )
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                ContactInfo(
                    icon = Icons.Default.Call,
                    text = "+63 991 649 1341"
                )

                ContactInfo(
                    icon = Icons.Default.Share,
                    text = "@jmlwebsite.com"
                )

                ContactInfo(
                    icon = Icons.Default.Email,
                    text = "jlumacang91235@liceo.edu.ph"
                )
            }
        }
    }
}

@Composable
fun ContactInfo(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(36.dp)
                .background(Color(0x1A69F0AE), CircleShape)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF69F0AE),
                modifier = Modifier.size(18.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            fontSize = 15.sp,
            color = Color(0xFFE0E0E0),
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        BusinessCard()
    }
}