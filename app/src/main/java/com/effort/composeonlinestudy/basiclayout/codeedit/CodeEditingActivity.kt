package com.effort.composeonlinestudy.basiclayout.codeedit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class CodeEditingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                MyTextAreaThree()
            }
        }
    }
}

@Composable
fun MyTextAreaOne() {

    Column() {

        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Red
        )
        Text(
            text = "나는",
            fontSize = 100.sp,
            color = Color.Gray
        )
        Text(
            text = "둘리야",
            fontSize = 100.sp,
            color = Color.Green
        )
    }
}

@Composable
fun MyTextAreaTwo() {
    Column {
        MyTextFormat1("안녕", 100.sp, Color.Red)
        MyTextFormat1("나는", 100.sp, Color.Gray)
        MyTextFormat1("수지야", 100.sp, Color.Green)
    }
}

@Composable
fun MyTextFormat1(text: String, fontSize: TextUnit, color: Color) {

    Text(
        text = text,
        fontSize = fontSize,
        color = color
    )
}

@Composable
fun MyTextAreaThree() {
    MyTextFormat2 {
        Text(
            text ="안녕",
            fontSize = 100.sp,
            color = Color.Yellow
        )
    }
}

@Composable
fun MyTextFormat2(content : @Composable () -> Unit) {
    Column {
        content()
        content()
        content()
        content()
        content()
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewUI() {
    ComposeOnlineStudyTheme {
        MyTextAreaOne()
    }
}