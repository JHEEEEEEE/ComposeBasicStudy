package com.effort.calendar.screen

import android.icu.util.Calendar
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.calendar.model.CalendarData.spendingData
import com.effort.calendar.ui.theme.CalendarTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun MainScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier.padding(paddingValues)
    ) {
        MainScreenContent()
    }
}

@Composable
fun MainScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CalendarHeader()
        CalendarLazyList()
    }
}

@Composable
fun CalendarHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.End
    ) {


        FaIcon(
            faIcon = FaIcons.Cog,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )

        FaIcon(
            faIcon = FaIcons.Bell,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )

        FaIcon(
            faIcon = FaIcons.Bars,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    CalendarTheme {
        MainScreenContent()
    }
}

@Composable
fun CalendarDayNames() {

    val nameList = listOf("일", "월", "화", "수", "목", "금", "토")

    Row {

        nameList.forEach { name ->

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {

                Text(text = name, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun CalendarDayList() {

    val time = remember { mutableStateOf(Calendar.getInstance()) }
    val date = time.value

    // 시간 세팅
    date.set(Calendar.YEAR, 2023)
    date.set(Calendar.MONTH, Calendar.DECEMBER)
    date.set(Calendar.DAY_OF_MONTH, 1)

    // 달력 계산 공식
    val thisMonthDayMax = date.getActualMaximum(Calendar.DAY_OF_MONTH) // 현재 달의 MAX
    val thisMonthFirstDay = date.get(Calendar.DAY_OF_WEEK) - 1 // 1일이 무슨 요일
    val thisMonthWeeksCount = (thisMonthDayMax + thisMonthFirstDay + 6) / 7  // 현재 달의 week 개수

    Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {

        repeat(thisMonthWeeksCount) { week ->

            Row {
                repeat(7) { day ->

                    val resultDay = week * 7 + day - thisMonthFirstDay + 1

                    if (resultDay in 1..thisMonthDayMax) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp)
                                .border(1.dp, Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Top
                            ) {

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(20.dp)
                                        .background(Color(0xFF89CFF0))
                                ) {

                                    val income = spendingData[resultDay]?.get(0)?.price ?: 0
                                    val outcome = spendingData[resultDay]?.get(1)?.price ?: 0

                                    val result = income - outcome

                                    if (result < 0) {
                                        Text(
                                            text = result.toString(),
                                            color = Color.Red
                                        )
                                    } else {
                                        Text(
                                            text = result.toString(),
                                            color = Color.Blue
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = resultDay.toString(),
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    } else {
                        // 달력 범위 밖
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp)
                                .border(1.dp, Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CalendarLazyList() {

    val lazyColumnState = rememberLazyListState()
    val lazyRowState = rememberLazyListState()
    val isScrolling = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        snapshotFlow { lazyColumnState.isScrollInProgress }.collect {
            isScrolling.value = it
            Log.d("isScrolling", "${isScrolling.value}")
        }
    }

    LaunchedEffect(lazyColumnState.firstVisibleItemIndex) {
        lazyRowState.scrollToItem(lazyColumnState.firstVisibleItemIndex)
    }

    if (isScrolling.value) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            state = lazyRowState
        ) {
            items(spendingData.size) {
                Log.d("spendingData", (it + 1).toString())

                val day = it + 1

                Box(
                    modifier = Modifier
                        .width(55.dp)
                        .height(60.dp)
                        .border(1.dp, Color.Gray),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .background(Color(0xFF89CFF0))
                        ) {
                            val income = spendingData[day]?.get(0)?.price ?: 0
                            val outcome = spendingData[day]?.get(1)?.price ?: 0

                            val result = income - outcome

                            if (result < 0) {
                                Text(
                                    text = result.toString(),
                                    color = Color.Red
                                )
                            } else {
                                Text(
                                    text = result.toString(),
                                    color = Color.Blue
                                )
                            }
                        }

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = day.toString(),
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }

    } else {
        CalendarDayNames()
        CalendarDayList()
    }

    Log.d("spendingData", "$spendingData")
    LazyColumn(
        modifier = Modifier.padding(20.dp),
        state = lazyColumnState
    ) {
        spendingData.keys.forEach { day ->

            item {
                Text(
                    text = "2023년 12월 ${day}일",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                spendingData[day]?.forEach { data ->

                    Row(
                        modifier = Modifier
                            .padding(start = 5.dp, top = 3.dp)
                    ) {
                        Text(text = data.type, fontSize = 12.sp)
                        Text(
                            text = "${data.price}원",
                            fontSize = 12.sp,
                            color = if (data.type == "수입") Color.Blue else Color.Red,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
            }
        }
    }
}
