package com.effort.composeonlinestudy.graphanimation.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme
import java.text.NumberFormat

class TextAnimationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeOnlineStudyTheme {
                TextUp()
            }
        }
    }
}

@Composable
fun TextUp() {

    var resultMoney: Int by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val animatedMoney by animateIntAsState(
            targetValue = resultMoney,
            animationSpec = tween(durationMillis = 3000),
            label = ""
        )

        val formattedResultMoney = NumberFormat.getNumberInstance().format(animatedMoney)

        Text(
            text = "$formattedResultMoney 원",
            fontSize = 50.sp
        )

        Button(
            onClick = {
                resultMoney = 1000000
            },
            modifier = Modifier.width(150.dp).padding(top = 150.dp)
        ) {
            Text(text = "go")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextUp() {
    ComposeOnlineStudyTheme {
        TextUp()
    }
}