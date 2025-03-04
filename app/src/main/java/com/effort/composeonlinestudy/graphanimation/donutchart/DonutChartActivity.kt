package com.effort.composeonlinestudy.graphanimation.donutchart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.effort.composeonlinestudy.graphanimation.piechart.ChartModel
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class DonutChartActivity : ComponentActivity() {

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

    var animationProgress by remember { mutableFloatStateOf(0f) }

    val animationState by animateFloatAsState(
        targetValue = animationProgress,
        animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing),
        label = ""
    )

    LaunchedEffect(true) {
        animationProgress = 1f
    }

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
                        sweepAngle = it.fraction * animationState * 360f - 2f, //fraction은 고정, animateState가 증가(0~1)
                        useCenter = false,
                        size = Size(size.width, size.height),
                        //style = Fill          // 파이차트
                        style = Stroke(width = 200f) // 도넛차트
                    )

                    startAngle += it.fraction * 360f //다음 조각을 위해 startAngle을 증가 (이전 조각이 끝난 위치)
                }
            }
        }
    }
}

