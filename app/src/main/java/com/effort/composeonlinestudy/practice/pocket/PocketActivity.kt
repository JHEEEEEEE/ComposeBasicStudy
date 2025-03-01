package com.effort.composeonlinestudy.practice.pocket

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.R
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class PocketActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocketCard()
        }
    }
}

@Composable
fun PocketCard() {

    var cardFront by remember { mutableStateOf(true) }

    val animationDegree by animateFloatAsState(
        targetValue = if (cardFront) 0f else 180f, label = "",
        animationSpec = tween(500)
    )

    Log.d("cardFront", cardFront.toString())
    Log.d("animationDegree", animationDegree.toString())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp, horizontal = 20.dp)
            .clickable {
                cardFront = !cardFront
            }
            .graphicsLayer {
                rotationY = animationDegree
            }
    ) {
        if (animationDegree <= 90) {
            PocketFront()
        } else {
            PocketBack()
        }
    }
}

@Composable
fun PocketFront() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffffd700), shape = RoundedCornerShape(30.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color.Black, shape = RoundedCornerShape(30.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.pocketball),
                contentDescription = null
            )
        }
    }
}

@Composable
fun PocketBack() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffffd700), shape = RoundedCornerShape(30.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color.Red, shape = RoundedCornerShape(30.dp))
                .graphicsLayer {
                    rotationY = 180f
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.monster),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.padding(20.dp))

                Text(
                    text = "파이리",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPocketCard() {
    ComposeOnlineStudyTheme {
        PocketCard()
    }
}