package com.effort.composeonlinestudy.practice.composexml.composetoxml

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class ComposeToXmlActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(50.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            val intent = Intent(context, TestActivity::class.java)
            context.startActivity(intent)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeOnlineStudyTheme {
        Greeting("Android")
    }
}