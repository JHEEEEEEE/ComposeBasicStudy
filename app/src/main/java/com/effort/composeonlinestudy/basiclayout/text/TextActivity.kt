package com.effort.composeonlinestudy.basiclayout.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeOnlineStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyTextEx(
                        hello = "안녕",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyTextEx(hello: String, modifier: Modifier = Modifier) {
    Text(
        text = hello,
        modifier = modifier,
        fontSize = 30.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        style = TextStyle(background = Color.Blue)
    )
}

@Preview(showBackground = true)
@Composable
fun MyTextExPreview() {
    ComposeOnlineStudyTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MyTextEx(
                hello = "안녕",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}