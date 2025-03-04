package com.effort.composestudy.basiclayout.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.effort.composestudy.ui.theme.ComposeOnlineStudyTheme

// Row : Item1 Item2 Item3
/*
* Column :
* Item1
* Item2
* Item3
*  */

class RowActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                RowTestOne()
            }
        }
    }
}

@Composable
fun RowTestOne() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray),
        horizontalArrangement = Arrangement.SpaceEvenly,  //가로로 동일한 간격
        verticalAlignment = Alignment.CenterVertically  // 세로로 중앙정렬
    ) {
        Text(
            text = "text1",
            style = TextStyle(background = Color.Blue),
            fontSize = 30.sp
        )
        Text(
            text = "text2",
            style = TextStyle(background = Color.Green),
            fontSize = 30.sp
        )
        Text(
            text = "text3",
            style = TextStyle(background = Color.Yellow),
            fontSize = 30.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyColumn() {
    ComposeOnlineStudyTheme {
        RowTestOne()
    }
}