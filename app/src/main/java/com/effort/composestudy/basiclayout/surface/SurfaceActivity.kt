package com.effort.composestudy.basiclayout.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composestudy.ui.theme.ComposeStudyTheme

// Surface
// 컨텐츠를 담아놓는 컨테이너
// Text / Button / Box / Surface

class SurfaceActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                MySurfaceTwo()
            }
        }
    }

}


@Composable
fun MySurfaceOne() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        color = Color.Green,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 1.dp
    ){
        Button(
            onClick = { },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Red
            )
        ) {
            Text(text = "클릭해보세요.")
        }
    }
}

@Composable
fun MySurfaceTwo() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray,
        border = BorderStroke(2.dp, Color.Red),
        contentColor = Color.Blue
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .size(200.dp),
                color = Color.Red,
            ) {
                Box(
                    contentAlignment = Alignment.Center, // Box 내부에서 중앙 정렬
                    modifier = Modifier.fillMaxSize() // Surface 크기만큼 Box 확장
                ) {
                    Text(text = "This is Jetpack Compose")
                }
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "This is Jetpack Compose Surface"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWebView() {
    ComposeStudyTheme {
        MySurfaceTwo()
    }
}