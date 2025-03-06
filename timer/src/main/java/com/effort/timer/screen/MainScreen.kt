package com.effort.timer.screen

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.timer.ui.theme.TimerTheme
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun MainScreen(innerPaddingValues: PaddingValues) {
    Box(modifier = Modifier.padding(innerPaddingValues)) {
        MainScreenContent()
    }
}

@Composable
fun MainScreenContent() {

    Box(modifier = Modifier.padding(40.dp)) {
        TimeInput()
        Clock()
    }
}

@Composable
fun TimeInput() {

    val context = LocalContext.current

    var inputText by remember { mutableStateOf("") }
    var progress by remember { mutableIntStateOf(0) }

    LaunchedEffect(progress) {

        if (progress > 0) {
            delay(1000)
            progress -= 1
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text(text = "시간 입력(1~60)") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Gray,
                unfocusedLabelColor = Color.Black,
                cursorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = {
                try {
                    val number = inputText.toInt()
                    if (number in 1..60) {
                        progress = number
                    } else {
                        Toast.makeText(context, "1 ~ 60 사이의 값을 입력해주세요", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "숫자를 제대로 입력해주세요", Toast.LENGTH_LONG).show()
                }

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {

            Text(
                text = "시간 설정",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            // 중심
            val center = Offset(size.width / 2, size.height / 2)

            // 반지름
            val radius = size.minDimension / 2

            // 0 ~ 59까지의 눈금을 60개 그림
            for (second in 0 until 60) {

                // 60초간 한 바퀴 1초에 6도  6 * 60 = 360
                val angle = Math.toRadians(second * 6.0 - 90)

                // 원에서 조금 떨어진
                //val startRadius = radius - 10.dp.toPx()
                val startRadius =
                    if (second % 5 == 0) radius - 20.dp.toPx() else radius - 10.dp.toPx()

                // 원에서 많이 떨어지게
                val endRadius = radius

                val startX = center.x + cos(angle).toFloat() * startRadius
                val endX = center.x + cos(angle).toFloat() * endRadius

                val startY = center.y + sin(angle).toFloat() * startRadius
                val endY = center.y + sin(angle).toFloat() * endRadius

                drawLine(
                    Color.Black,
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    strokeWidth = if (second % 5 == 0) 3.dp.toPx() else 1.dp.toPx()
                )
            }

            val sweepAngle = (progress.toFloat() / 60f) * 360f
            drawArc(
                color = Color.Red,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = true,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Fill
            )
        }
    }
}

@Composable
fun Clock() {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TimerTheme {
        MainScreenContent()
    }
}