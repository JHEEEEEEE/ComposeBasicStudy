package com.effort.composestudy.practice.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composestudy.ui.theme.ComposeStudyTheme

// Box 3개를 사용하여 clip, background, padding 순서에 따라 결과가 어떻게 달라지는지 테스트

class BoxSequenceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                MyBoxTest()
            }
        }
    }
}

@Composable
fun MyBoxTest() {
    Column(modifier = Modifier.padding(16.dp)) {
        // 첫 번째 Box: 색을 먼저 채우고 -> 모서리를 둥글게 잘라냄
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Green) //  색상을 먼저 채우고
                .clip(RoundedCornerShape(30.dp)) //  그 후 모서리를 둥글게 자름
                .padding(20.dp)
        ) {
            Text(text = "test")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 두 번째 Box: 모서리를 먼저 둥글게 한 후 -> 색을 채움
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(30.dp)) //  먼저 모서리를 둥글게 만든 후
                .background(Color.Green) //  배경색을 적용
                .padding(20.dp)
        ) {
            Text(text = "test")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 세 번째 Box: 패딩을 먼저 적용한 후 -> 모서리를 둥글게 하고 -> 배경색을 채움
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(20.dp) //  패딩을 먼저 적용하면, 박스 전체 크기가 줄어듦
                .clip(RoundedCornerShape(30.dp)) //  모서리를 둥글게 함
                .background(Color.Green) //  배경색을 채움
        ) {
            Text(text = "test")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyBoxTest() {
    MyBoxTest()
}