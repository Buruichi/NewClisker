package com.example.newclicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newclicker.ui.theme.NewClickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewClickerTheme {
                // A surface container using the 'background' color from the theme
                setContent {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircleItem()
                    }
                }
            }
        }
    }

@Composable
fun CircleItem() {
            val counter = remember {
                mutableStateOf(0)
            }
            var color = remember {
                mutableStateOf(Color.Blue)
            }
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = color.value, shape = CircleShape)
                    .clickable {
                        counter.value++
                        when (++counter.value) {
                            10 -> color.value = Color.Red
                            20 -> color.value = Color.Green
                            30 -> color.value = Color.Yellow
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = counter.value.toString(),
                    style = TextStyle(color = Color.White, fontSize = 20.sp)
                )
            }
        }
    }


