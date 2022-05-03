package com.trusov.jetpack_compose_1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ListScreen(navController: NavController) {
    val textArray = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")
    Scaffold {
        LazyColumn() {
            textArray.forEach { text ->
                item {
                    Text(text, modifier = Modifier.padding(4.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(24.dp).clickable {
                            navController.navigate("details/$text")
                        })
                }
            }
        }
    }
}