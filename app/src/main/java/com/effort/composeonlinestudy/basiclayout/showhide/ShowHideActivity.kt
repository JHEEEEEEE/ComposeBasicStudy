package com.effort.composeonlinestudy.basiclayout.showhide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class ShowHideActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposeOnlineStudyTheme {
                MyShowHideExTwo()
            }
        }
    }
}

// 버튼을 클릭하면 새로운 버튼이 나오는 것
@Composable
fun MyShowHideExOne() {

    var isButtonVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                isButtonVisible = !isButtonVisible
                println(isButtonVisible)
            }
        ) {
            if (isButtonVisible) {
                Text(
                    text = "숨기기",
                    fontSize = 50.sp
                )
            } else {
                Text(
                    text = "보이기",
                    fontSize = 50.sp
                )
            }
        }

        Spacer(modifier = Modifier.size(30.dp))

        if (isButtonVisible) {
            Button(
                onClick = {},
            ) {
                Text(
                    text = "짜잔",
                    fontSize = 50.sp
                )
            }
        }
    }
}

@Composable
fun MyShowHideExTwo() {

    var switchState by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(40.dp)
    ) {
        Switch(
            checked = switchState,
            onCheckedChange = { checked ->
                switchState = checked
            }
        )

        Text(
            text = if (switchState) "ON" else "OFF",
            fontSize = 30.sp
        )

        if (switchState) {
            Button(onClick = {}) {
                Text(
                    text = "짜잔",
                    fontSize = 30.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewShowHide() {
    MyShowHideExTwo()
}