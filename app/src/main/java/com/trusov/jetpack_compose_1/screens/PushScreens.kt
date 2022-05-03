package com.trusov.jetpack_compose_1.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PushScreen() {
    Scaffold {
        Text("Push Screen", modifier = Modifier.padding(24.dp))
    }
}