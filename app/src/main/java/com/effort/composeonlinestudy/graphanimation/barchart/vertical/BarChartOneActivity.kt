package com.effort.composeonlinestudy.graphanimation.barchart.vertical

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composeonlinestudy.graphanimation.barchart.horizontal.BarChart4
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class BarChartOneActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                BarChart4()
            }
        }
    }
}

@Composable
fun BarChart1() {

    val barDataList: List<Float> = listOf(0.2f, 0.4f, 0.6f, 0.8f, 1f)

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
            barDataList.forEach { barData ->

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "${(barData * 100).toInt()}%"
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxHeight(fraction = barData)
                            .width(30.dp)
                            .background(
                                Color.Black,
                                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                            ),
                    ) { }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBarChart1() {
    BarChart4()
}