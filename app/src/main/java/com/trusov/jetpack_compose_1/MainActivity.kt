package com.trusov.jetpack_compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
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
import com.trusov.jetpack_compose_1.ui.theme.Jetpack_compose_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colors = listOf(Color.Red, Color.Green, Color.Blue)
            val selectedOption = remember { mutableStateOf(colors[0]) }
            Column(modifier =Modifier.padding(20.dp)) {
                Box( Modifier.padding(10.dp).size(100.dp).background(color = selectedOption.value))

                colors.forEach { color ->
                    val selected = selectedOption.value == color
                    Box(
                        Modifier.padding(8.dp)
                            .size(60.dp)
                            .background(color = color)
                            .selectable(
                                selected = selected,
                                onClick = { selectedOption.value = color }
                            )
                            .border(
                                width= if(selected){2.dp} else{0.dp},
                                color = Color.Black
                            )
                    )
                }
            }


        }
    }

    private fun setBoxColor(checkedState: Boolean): Color {
        return if (checkedState) Color.Red else Color.Blue
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