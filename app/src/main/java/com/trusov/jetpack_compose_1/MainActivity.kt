package com.trusov.jetpack_compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trusov.jetpack_compose_1.ui.theme.Jetpack_compose_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val message: MutableState<String> = remember { mutableStateOf("Hello Jetpack") }
            Text(
                text = message.value,
                color = Color.DarkGray,
                fontSize = 40.sp,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.Cursive,
                style = TextStyle(
                    textGeometricTransform = TextGeometricTransform(scaleX = 2f),
                    shadow = Shadow(
                        color = Color.LightGray,
                        offset = Offset(19.0f, 20.0f),
                        blurRadius = 2.0f
                    )
                ),
                modifier = Modifier.clickable(onClick = { message.value = "Hello Work! Hello Work! Hello Work!" })
                    .padding(32.dp)
                    .background(Color.Yellow)
                    .padding(32.dp)
            )
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jetpack_compose_1Theme {
        Greeting("Android")
    }
}