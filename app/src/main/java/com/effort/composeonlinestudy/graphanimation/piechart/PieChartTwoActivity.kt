package com.effort.composeonlinestudy.graphanimation.piechart

import android.graphics.Color.BLUE
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
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class PieChartTwoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                PieChart2()
            }
        }
    }
}

@Composable
fun PieChart2() {

    val items: List<ChartModel> = listOf(
        ChartModel(fraction = 0.2f, color = Color.Green),
        ChartModel(fraction = 0.3f, color = Color.Red),
        ChartModel(fraction = 0.5f, color = Color.Black),
    )

    var resultPercent by remember { mutableFloatStateOf(0f) }

    val animatedPercent by animateFloatAsState(
        targetValue = resultPercent,
        animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing),
        label = ""
    )

    LaunchedEffect(true) {
        resultPercent = 1f
    }

    var startAngle = 0f // 시작 각도를 0도로 설정

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.size(300.dp)) {

            items.forEach { it ->

                val fraction = (it.fraction * 100).toInt().toString() + "%"

                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawArc(
                        color = it.color,
                        startAngle = startAngle, // 현재 조각의 시작 위치
                        sweepAngle = it.fraction * animatedPercent * 360f,//현재 조각이 차지하는 크기
                        useCenter = true,
                        size = Size(size.width, size.height),
                        style = Fill          // 파이차트
                        //style = Stroke(width = 200f) // 도넛차트
                    )

                    val paint = Paint().asFrameworkPaint().apply {
                        color = BLUE
                        textSize = 60f
                    }

                    val midPosition = startAngle + it.fraction * 180f // 중앙에 위치
                    val radiusPosition = size.width * 0.5f * 0.5f // 원 중앙에서 얼마나 떨어지는지

                    // x y 좌표 계산
                    val xPosition = (radiusPosition * kotlin.math.cos(midPosition * (Math.PI / 180))).toFloat() + size.width * 0.5f // x 좌표
                    val yPosition = (radiusPosition * kotlin.math.sin(midPosition * (Math.PI / 180))).toFloat() + size.height * 0.5f // y 좌표

                    // 텍스트의 너비 및 높이를 계산
                    val textWidth = paint.measureText(it.fraction.toString()) // 텍스트 가로 넓이
                    val textHeight = paint.descent() - paint.ascent() // 텍스트 세로 넓이

                    val xPositionChanged = xPosition - textWidth * 0.5f // 텍스트 가로 넓이 절반
                    val yPositionChanged = yPosition + textHeight * 0.5f // 텍스트 세로 넓이 절반

                    drawIntoCanvas {
                        it.nativeCanvas.drawText(
                            fraction, xPositionChanged, yPositionChanged, paint
                        )
                    }

                    startAngle += it.fraction * 360f //다음 조각을 위해 startAngle을 증가 (이전 조각이 끝난 위치)
                }
            }
        }
    }
}
