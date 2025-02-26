package com.effort.composeonlinestudy.basiclayout.progressindicator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class ProgressIndicatorActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeOnlineStudyTheme {
                MyProgressIndicator()
            }
        }
    }
}

@Composable
fun MyProgressIndicator() {

    var progress by remember { mutableFloatStateOf(0.0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            if (progress < 1.0f) {
                progress += 0.1f
            }
        }) {
            Text(
                text = "행복게이지", fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.height(10.dp),
            color = Color.Blue,
        )

        Spacer(modifier = Modifier.size(30.dp))

        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier.height(10.dp),
            color = Color.Blue,
            trackColor = Color.Green
        )
    }
}

@Preview
@Composable
fun PreviewProgressIndicator() {
    ComposeOnlineStudyTheme {
        MyProgressIndicator()
    }
}