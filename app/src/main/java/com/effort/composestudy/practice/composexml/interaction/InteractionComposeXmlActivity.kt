package com.effort.composestudy.practice.composexml.interaction

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.effort.composestudy.R
import com.effort.composestudy.ui.theme.ComposeStudyTheme

class InteractionComposeXmlActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                Interaction()
            }
        }
    }
}

@Composable
fun Interaction() {

    val progressValue = remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AndroidView(
            factory = { context ->

                val view = LayoutInflater.from(context).inflate(R.layout.interaction, null, false)

                view
            },
            update = { view ->
                val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
                progressBar.progress = progressValue.value
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { progressValue.value += 10 }
        ) {
            Text(text = "UP")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Interaction()
}