package com.effort.composestudy.practice.dice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composestudy.ui.theme.ComposeOnlineStudyTheme
import kotlin.random.Random

class DiceActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                MyDice()
            }
        }
    }
}

@Composable
fun MyDice() {

    var diceNumber by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .size(300.dp)
                .border(BorderStroke(4.dp, Color.Black))
                .background(Color.White)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            DiceFace(diceNumber)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { diceNumber = Random.nextInt(1, 7) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            )
        ) {
            Text(text = "주사위 굴리기", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "🎲 $diceNumber ", fontSize = 30.sp)
    }
}

@Composable
fun DiceFace(number: Int) {

    Canvas(modifier = Modifier.fillMaxSize()) {
        val radius = size.minDimension / 20  // 점 크기 조정
        val spacing = size.minDimension / 4  // 점 간격

        val center = Offset(size.width / 2, size.height / 2)
        val topLeft = Offset(center.x - spacing, center.y - spacing)
        val topRight = Offset(center.x + spacing, center.y - spacing)
        val middleLeft = Offset(center.x - spacing, center.y)
        val middleRight = Offset(center.x + spacing, center.y)
        val bottomLeft = Offset(center.x - spacing, center.y + spacing)
        val bottomRight = Offset(center.x + spacing, center.y + spacing)

        val positions = when (number) {
            1 -> listOf(center)
            2 -> listOf(topLeft, bottomRight)
            3 -> listOf(topLeft, center, bottomRight)
            4 -> listOf(topLeft, topRight, bottomLeft, bottomRight)
            5 -> listOf(topLeft, topRight, center, bottomLeft, bottomRight)
            6 -> listOf(topLeft, topRight, middleLeft, middleRight, bottomLeft, bottomRight)
            else -> emptyList()
        }

        positions.forEach { position ->
            drawCircle(color = Color.Black, radius = radius, center = position)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyDice() {

    ComposeOnlineStudyTheme {
        MyDice()
    }
}