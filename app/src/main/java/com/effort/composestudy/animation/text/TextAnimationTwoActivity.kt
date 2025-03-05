package com.effort.composestudy.animation.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.effort.composestudy.ui.theme.ComposeStudyTheme
import java.text.NumberFormat

class TextAnimationTwoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeStudyTheme {
                AutomatedTextUp()
            }
        }
    }
}

@Composable
fun AutomatedTextUp() {

    var resultMoney: Int by remember { mutableIntStateOf(0) }

    val animatedMoney: Int by animateIntAsState(
        targetValue = resultMoney,
        animationSpec = tween(3000), label = ""
    )

    val formattedMoney = NumberFormat.getNumberInstance().format(animatedMoney)

    LaunchedEffect(true) {
        resultMoney = 1000000 //백만
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "$formattedMoney 원")

        Button(onClick = {
            resultMoney = 10000000 //천만
        },
            Modifier.padding(top = 150.dp)) {
            Text(text = "go")
        }
    }
}