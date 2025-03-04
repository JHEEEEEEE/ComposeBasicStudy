package com.effort.composestudy.basiclayout.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composestudy.ui.theme.ComposeOnlineStudyTheme

class CanvasActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                MyCanvas()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBoxExample() {
    MyCanvas()
}

@Composable
fun MyCanvas() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Color.Red)
    ) {
        Canvas(modifier = Modifier.fillMaxSize().align(Alignment.Center)) {
            drawCircle(Color.Black, radius = size.minDimension / 2)
        }
    }



    /*Box(
        modifier = Modifier
            .width(100.dp)
            .height(200.dp)
            .background(Color.Green)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(Color.Black, radius = size.minDimension / 2)
        }
    }*/

  /*  Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Gray)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(Color.Black, radius = size.minDimension / 2)
        }
    }*/
}
