package com.effort.composestudy.basiclayout.lazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composestudy.ui.theme.ComposeStudyTheme

class LazyRowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                MyLazyRowEx()
            }
        }
    }
}

@Composable
fun MyLazyRowEx() {

    val textList = listOf(
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
        "A",
        "B",
        "C",
    )

    LazyRow(
        modifier = Modifier.padding(50.dp)
    ) {
        items(textList) { item ->
            Text(text = item, fontSize = 60.sp, modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    println("Clicked item : $item")
                })
        }
    }
}

@Preview
@Composable
fun PreviewMyLazyRowEx() {
    ComposeStudyTheme {
        MyLazyRowEx()
    }
}