package com.effort.composestudy.animation.barchart.vertical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composestudy.ui.theme.ComposeOnlineStudyTheme
import kotlinx.coroutines.delay

class BarChartThreeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                BarChart3()
            }
        }
    }
}

@Composable
fun BarChart3() {

    val barDataList: List<Float> = listOf(0.2f, 0.4f, 0.6f, 0.8f, 1f)
    val fullHeight = 600.dp

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            barDataList.forEachIndexed { index, barData ->

                var resultHeight by remember { mutableStateOf(0.dp) }

                // index -> 0 1 2 3 4
                LaunchedEffect(true) {
                    delay(1000L * index)
                    resultHeight = fullHeight * barData
                }

                val animatedHeight by animateDpAsState(
                    targetValue = resultHeight,
                    animationSpec = tween(durationMillis = 1000, easing = FastOutLinearInEasing),
                    label = ""
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "${(barData * 100).toInt()}%"
                    )

                    Box(
                        modifier = Modifier
                            .height(animatedHeight)
                            .width(30.dp)
                            .background(
                                Color.Black,
                                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                            ),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBarChart3() {
    BarChart3()
}