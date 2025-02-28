package com.effort.composeonlinestudy.practice.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class FontActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeOnlineStudyTheme {

                FontThemeTest1()
            }
        }
    }
}

@Composable
fun FontThemeTest1() {

    Column (
        modifier = Modifier.padding(50.dp)
    ) {
        Text(
            text = "폰트 1",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "폰트 2",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFontThemeTest1() {
    FontThemeTest1()
}
