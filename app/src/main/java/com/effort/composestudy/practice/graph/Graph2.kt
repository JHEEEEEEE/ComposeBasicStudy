package com.effort.composestudy.practice.graph

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composestudy.ui.theme.ComposeOnlineStudyTheme

@Composable
fun Graph2() {

    Box(
        modifier = Modifier.padding(top = 120.dp)
    ) {
        Graph2Pie()
    }
}

@Composable
fun Graph2Pie() {

    val pieSize1 = 25f
    val pieSize2 = 75f

    val colorList = listOf(Color.Red, Color.Blue)

    PieChart(
        pieSize1,
        pieSize2,
        colorList
    )
}

@Composable
fun PieChart(
    pieSize1 : Float, pieSize2 : Float, colorList: List<Color>
) {
    val totalSize = pieSize1 + pieSize2

    BoxWithConstraints (
        modifier = Modifier.padding(20.dp)
    ) {
        val pieDetailSize = constraints.maxWidth.toFloat()

        Canvas(modifier = Modifier.size(pieDetailSize.dp)) {
            val sweep1 = 360 * (pieSize1 / totalSize)

            drawArc(
                color = colorList[0],
                startAngle = 0f,
                sweepAngle = sweep1,
                useCenter = true,
                size = Size(pieDetailSize, pieDetailSize)
            )

            val sweep2 = 360 * (pieSize2 / totalSize)

            drawArc(
                color = colorList[1],
                startAngle = sweep1,
                sweepAngle = sweep2,
                useCenter = true,
                size = Size(pieDetailSize, pieDetailSize)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGraph2() {
    ComposeOnlineStudyTheme {
        Graph2()
    }
}