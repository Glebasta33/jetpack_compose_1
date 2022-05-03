package com.trusov.jetpack_compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.trusov.jetpack_compose_1.screens.DetailsScreen
import com.trusov.jetpack_compose_1.screens.ListScreen
import com.trusov.jetpack_compose_1.screens.PushScreen
import com.trusov.jetpack_compose_1.screens.SearchScreen
import com.trusov.jetpack_compose_1.ui.theme.Jetpack_compose_1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val bottomItems = listOf("list", "search", "push")
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        bottomItems.forEach { screen ->
                            BottomNavigationItem(
                                selected = false,
                                onClick = { navController.navigate(screen) },
                                label = { Text(screen) },
                                icon = {}
                            )
                        }
                    }
                }
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "list"
                ) {
                    composable("list") { ListScreen(navController) }
                    composable("search") { SearchScreen() }
                    composable("push") { PushScreen() }
                    composable("details/{text}") { backStackEntry ->
                        DetailsScreen(backStackEntry.arguments?.getString("text")) }
                }
            }
        }
    }
}