package com.example.myapplication // Adjust if your package is different

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Greeting(val userName: String)