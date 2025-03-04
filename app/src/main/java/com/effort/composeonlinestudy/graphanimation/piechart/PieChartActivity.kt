package com.effort.composeonlinestudy.graphanimation.piechart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class PieChartActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                PieChart()
            }
        }
    }
}

@Composable
fun PieChart() {

    val items: List<ChartModel> = listOf(
        ChartModel(fraction = 0.2f, color = Color.Green),
        ChartModel(fraction = 0.3f, color = Color.Red),
        ChartModel(fraction = 0.5f, color = Color.Black),
    )

    var startAngle = 0f // 시작 각도를 0도로 설정

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.size(300.dp)) {

            items.forEach {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawArc(
                        color = it.color,
                        startAngle = startAngle, // 현재 조각의 시작 위치
                        sweepAngle = it.fraction * 360f - 2f, //현재 조각이 차지하는 크기
                        useCenter = true,
                        size = Size(size.width, size.height),
                        style = Fill          // 파이차트
                        //style = Stroke(width = 200f) // 도넛차트
                    )

                    startAngle += it.fraction * 360f //다음 조각을 위해 startAngle을 증가 (이전 조각이 끝난 위치)
                }
            }
        }
    }
}
