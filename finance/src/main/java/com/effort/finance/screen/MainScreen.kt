package com.effort.finance.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.finance.R
import com.effort.finance.animation.TextAnimation
import com.effort.finance.ui.theme.FinanceTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons
import kotlinx.coroutines.delay


@Composable
fun MainScreen(innerPaddingValues: PaddingValues) {
    Box(
        modifier = Modifier.padding(innerPaddingValues)
    ) {
        MainScreenContent()
    }
}

@Composable
fun MainScreenContent() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .background(Color.Black)
    ) {
        item { Header() }
        item { TopMenu() }
        item { TopMenuBottom() }
        item { SpendThisMonth() }
        item { SpendThisMonthProgressBar() }
        item { SpendThisMonthCategoryList() }
        item { SpaceGray() }
        item { SpendGraphHeader() }
        item { SpendGraph() }
        item { SpaceGray() }
        item { SpendThisMonthInsuranceHeader() }
        item { SpendThisMonthInsuranceGraph() }
    }
}

@Composable
fun Header() {

    Row(
        modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        FaIcon(
            faIcon = FaIcons.ArrowLeft, tint = Color.White, modifier = Modifier.padding(20.dp)
        )

        FaIcon(
            faIcon = FaIcons.Plus, tint = Color.White, modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun TopMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "자산", color = Color.Gray, fontSize = 16.sp
            )
        }

        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "소비·수입", color = Color.Gray, fontSize = 16.sp
            )
        }

        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "연말정산", color = Color.Gray, fontSize = 16.sp
            )
        }
    }
}

@Composable
fun TopMenuBottom() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {

        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height(2.dp)
                .background(Color.White)
                .padding(top = 15.dp, start = 5.dp, end = 5.dp),
            contentAlignment = Alignment.Center
        ) {

        }

        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {

        }
    }

}

@Composable
fun SpendThisMonth() {

    Row(modifier = Modifier.padding(10.dp)) {

        FaIcon(
            faIcon = FaIcons.CaretLeft, tint = Color.White, modifier = Modifier.padding(
                start = 10.dp, top = 1.5.dp, end = 5.dp
            )
        )

        Text(
            text = "11월 소비", color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(
                start = 5.dp, end = 5.dp
            ), textDecoration = TextDecoration.Underline
        )

        FaIcon(
            faIcon = FaIcons.CaretRight, tint = Color.White, modifier = Modifier.padding(
                start = 5.dp, top = 1.5.dp, end = 10.dp
            )
        )
    }

    /*Text(
        text = "1,000,000원",
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp)
    )*/

    TextAnimation(
        targetValue = 1000000,
        textColor = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        padding = PaddingValues(start = 20.dp)
    )

    Text(
        text = "계좌에서 쓴 금액 포함",
        color = Color.Gray,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
    )
}

@Composable
fun SpendThisMonthProgressBar() {

    var startAnimation by remember { mutableStateOf(false) }
    val weightList = listOf(7f, 1f, 1f, 1f)

    val animatedWeights = weightList.map {
        animateFloatAsState(
            targetValue = if (startAnimation) it else 0.1f,
            animationSpec = tween(durationMillis = 3000),
            label = ""
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
    ) {

        animatedWeights.forEachIndexed { index, state ->
            Box(
                modifier = Modifier
                    .padding(end = 5.dp)
                    .weight(state.value)
                    .height(30.dp)
                    .background(
                        color = when (index) {
                            0 -> {
                                Color.Red
                            }

                            1 -> {
                                Color.Gray
                            }

                            2 -> {
                                Color.Blue
                            }

                            else -> {
                                Color.Green
                            }
                        }, shape = when (index) {
                            0 -> {
                                RoundedCornerShape(
                                    topStart = 5.dp, bottomStart = 5.dp
                                )
                            }

                            3 -> {
                                RoundedCornerShape(
                                    topEnd = 5.dp, bottomEnd = 5.dp
                                )
                            }

                            else -> RectangleShape
                        }
                    )
            )
        }
    }

    LaunchedEffect(Unit) {
        startAnimation = true
    }

    //Row(
    //    modifier = Modifier
    //        .fillMaxWidth()
    //        .padding(top = 20.dp, start = 20.dp, end = 20.dp)
    //) {
    //
    //    Box(
    //        modifier = Modifier
    //            .padding(end = 5.dp)
    //            .weight(7f)
    //            .height(30.dp)
    //            .background(
    //                color = Color.Red,
    //                shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)
    //            )
    //    ) {
    //
    //    }
    //
    //    Box(
    //        modifier = Modifier
    //            .padding(end = 5.dp)
    //            .weight(1f)
    //            .height(30.dp)
    //            .background(color = Color.Gray),
    //
    //        ) {
    //
    //    }
    //
    //    Box(
    //        modifier = Modifier
    //            .padding(end = 5.dp)
    //            .weight(1f)
    //            .height(30.dp)
    //            .background(color = Color.Blue)
    //    ) {
    //
    //    }
    //
    //    Box(
    //        modifier = Modifier
    //            .weight(1f)
    //            .height(30.dp)
    //            .background(
    //                color = Color.Green,
    //                shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
    //            )
    //    ) {
    //
    //    }
    //}
}

@Composable
fun SpendThisMonthCategoryList() {

    Column(
        modifier = Modifier.padding(20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            Color.Red, shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.transfer),
                        contentDescription = "transfer",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )
                }

                Column(modifier = Modifier.padding(start = 50.dp)) {
                    Text(text = "이체", color = Color.White)
                    Text(text = "70%", color = Color.White)
                }
            }

            Text(
                text = "700,000원", color = Color.White, fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            Color.Gray, shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.send_money),
                        contentDescription = "send money",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )
                }

                Column(modifier = Modifier.padding(start = 50.dp)) {
                    Text(text = "송금", color = Color.White)
                    Text(text = "10%", color = Color.White)
                }
            }

            Text(
                text = "100,000원", color = Color.White, fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            Color.Blue, shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.save_money),
                        contentDescription = "save money",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )
                }

                Column(modifier = Modifier.padding(start = 50.dp)) {
                    Text(text = "저축", color = Color.White)
                    Text(text = "10%", color = Color.White)
                }
            }

            Text(
                text = "100,000원", color = Color.White, fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            Color.Green, shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.monthly_rent),
                        contentDescription = "monthly rent",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )
                }

                Column(modifier = Modifier.padding(start = 50.dp)) {
                    Text(text = "월세", color = Color.White)
                    Text(text = "10%", color = Color.White)
                }
            }

            Text(
                text = "100,000원", color = Color.White, fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SpaceGray() {

    Box(
        modifier = Modifier
            .padding(vertical = 20.dp)
            .fillMaxWidth()
            .height(10.dp)
            .background(Color.DarkGray)
    ) {}
}

@Composable
fun SpendGraphHeader() {

    Text(
        text = "이번 달", color = Color.White, modifier = Modifier.padding(start = 15.dp)
    )
}

@Composable
fun SpendGraph() {

    val dotPositions = listOf(400f, 300f, 750f, 600f, 800f)

    val dotPositionSecond = listOf(500f, 200f, 700f)

    val showHideEffect = rememberInfiniteTransition(label = "")

    val showHideAnimation = showHideEffect.animateFloat(
        initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ), label = ""
    )


    Canvas(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        val width = size.width
        val height = size.height

        val maxPosition = dotPositions.max()
        val minPosition = dotPositions.min()


        val positionMap = dotPositions.mapIndexed { index, value ->

            val x = (width / (dotPositions.size - 1)) * index
            val y = height - (height * (value - minPosition) / (maxPosition - minPosition))

            x to y
        }

        val positionMapSecond = dotPositionSecond.mapIndexed { index, value ->

            val x = (width / (dotPositions.size - 1)) * index
            val y = height - (height * (value - minPosition) / (maxPosition - minPosition))

            x to y
        }


        positionMap.zipWithNext { a, b ->

            drawLine(
                color = Color.White,
                start = Offset(a.first, a.second),
                end = Offset(b.first, b.second),
                strokeWidth = 5f,
                cap = Stroke.DefaultCap
            )
        }


        positionMapSecond.zipWithNext { a, b ->

            drawLine(
                color = Color.Blue,
                start = Offset(a.first, a.second),
                end = Offset(b.first, b.second),
                strokeWidth = 5f,
                cap = Stroke.DefaultCap
            )
        }

        positionMapSecond.lastOrNull().let {
            drawCircle(
                color = Color.Blue, radius = 13f, center = Offset(
                    it?.first ?: 0f, it?.second ?: 0f
                ), alpha = showHideAnimation.value
            )
        }
    }

    Spacer(modifier = Modifier.padding(20.dp))
}

@Composable
fun SpendThisMonthInsuranceHeader() {

    Text(
        text = "매달 내는 보험료 적정할까요?",
        color = Color.White,
        modifier = Modifier.padding(start = 15.dp)
    )
}

@Composable
fun SpendThisMonthInsuranceGraph() {

    var leftBoxHeight by remember { mutableStateOf(160.dp) }
    var rightBoxHeight by remember { mutableStateOf(40.dp) }

    val animatedLeftBoxHeight = animateDpAsState(
        targetValue = leftBoxHeight, animationSpec = tween(durationMillis = 3000), label = ""
    )

    val animatedRightBoxHeight = animateDpAsState(
        targetValue = rightBoxHeight, animationSpec = tween(durationMillis = 3000), label = ""
    )

    LaunchedEffect(Unit) {

        while (true) {
            leftBoxHeight = 40.dp
            rightBoxHeight = 160.dp

            delay(2000)

            leftBoxHeight = 160.dp
            rightBoxHeight = 40.dp

            delay(2000)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .height(250.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier.width(80.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "과잉", color = Color.White
                )

                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(60.dp)
                        .height(animatedLeftBoxHeight.value)
                        .background(
                            color = Color.Red, shape = RoundedCornerShape(
                                topStart = 10.dp, topEnd = 10.dp
                            )
                        )
                ) {

                }

                Text(
                    text = "600,000원", color = Color.White
                )
            }
        }

        Box(
            modifier = Modifier.width(80.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "부족", color = Color.White
                )

                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(60.dp)
                        .height(animatedRightBoxHeight.value)
                        .background(
                            Color.Blue, shape = RoundedCornerShape(
                                topStart = 10.dp, topEnd = 10.dp
                            )
                        )
                ) {

                }

                Text(
                    text = "100,000원", color = Color.White
                )
            }
        }
    }

    Spacer(modifier = Modifier.size(20.dp))
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    FinanceTheme {
        MainScreenContent()
    }
}