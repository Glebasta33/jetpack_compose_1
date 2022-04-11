package com.trusov.jetpack_compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
            val message: MutableState<String> = remember { mutableStateOf("Hello Jetpack") }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                    modifier = Modifier
                        .clickable(onClick = {
                            message.value = "Hello Work! Hello Work! Hello Work!"
                        })
                        .fillMaxWidth()
                        .background(Color.Yellow)
                        .padding(56.dp)
                )

                val textInField = remember{ mutableStateOf("")}

                TextField(value = textInField.value, onValueChange = { newText ->
                    textInField.value = newText
                },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    leadingIcon = { Icon(Icons.Filled.Check, contentDescription = "Проверено") },
                    trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Дополнительная информация") },
                    placeholder = { Text("Hello Work!") },
                    colors = TextFieldDefaults.textFieldColors(textColor = Color.Yellow, backgroundColor = Color.Green),
                    modifier = Modifier.fillMaxWidth())

                Button(
                    onClick = {message.value = textInField.value},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black, contentColor = Color.Cyan),
                    border = BorderStroke(10.dp, Color.LightGray)
                ) {
                    Row(horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Click", fontSize = 25.sp)
                        Text(text = "1", fontSize = 25.sp)
                        Text(text = "2", fontSize = 32.sp)
                        Text(text = "3", fontSize = 48.sp)
                    }

                }
            }


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