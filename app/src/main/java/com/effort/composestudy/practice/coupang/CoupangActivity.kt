package com.effort.composestudy.practice.coupang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composestudy.ui.theme.ComposeOnlineStudyTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

class CoupangActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeOnlineStudyTheme {

                MyCoupang()
            }
        }
    }
}

@Composable
fun MyCoupang() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .verticalScroll(scrollState)
        ) {
            TopLogoArea()
            TopSearchBar()
            TopBanner()
            CategoryList()
            CenterBanner()
        }
    }
}

@Composable
fun TopLogoArea() {
    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp), contentAlignment = Alignment.Center
        ) {

            Row {
                Text(text = "C", fontSize = 30.sp, color = Color(0xFF964b00))
                Text(text = "O", fontSize = 30.sp, color = Color(0xFF964b00))
                Text(text = "U", fontSize = 30.sp, color = Color(0xFF964b00))
                Text(text = "P", fontSize = 30.sp, color = Color.Red)
                Text(text = "A", fontSize = 30.sp, color = Color.Yellow)
                Text(text = "N", fontSize = 30.sp, color = Color.Green)
                Text(text = "G", fontSize = 30.sp, color = Color.Blue)

            }
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "shopping Cart",
                modifier = Modifier
                    .align(
                        Alignment.CenterEnd
                    )
                    .padding(end = 20.dp)
            )
        }
    }
}

@Composable
fun TopSearchBar() {

    var inputText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(IntrinsicSize.Min)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
    ) {
        TextField(
            value = inputText,
            onValueChange = {
                inputText = it
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            placeholder = { Text(text = "쿠팡에서 검색하세요", fontSize = 30.sp) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                errorContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopBanner() {

    val pageState = rememberPagerState()
    val pageCount = 5

    val textList = listOf(
        "광고 문구 1",
        "광고 문구 2",
        "광고 문구 3",
        "광고 문구 4",
        "광고 문구 5",
    )

    Box(
        modifier = Modifier.padding(top = 20.dp)
    ) {

        HorizontalPager(
            count = pageCount,
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray)
        ) { page ->
            Text(
                text = textList[page],
                fontSize = 30.sp
            )
        }

        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(15.dp)
        )
    }
}

@Composable
fun CategoryList() {

    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(10.dp)
    ) {


        val itemList = listOf(
            "Item1",
            "Item2",
            "Item3",
            "Item4",
            "Item5",
        )

        val iconList = listOf(
            Icons.Default.Favorite,
            Icons.Default.Person,
            Icons.Default.ShoppingCart,
            Icons.Default.Lock,
            Icons.Default.Phone,
        )

        itemList.forEachIndexed { index, item ->

            Column(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .width(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = iconList[index % iconList.size], contentDescription = null)

                Text(text = item, fontSize = 20.sp)

                Spacer(modifier = Modifier.padding(20.dp))

                Icon(imageVector = iconList[index % iconList.size], contentDescription = null)

                Text(text = item, fontSize = 20.sp)
            }
        }
    }
}


@Composable
fun CenterBanner() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(20.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "배너 영역",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFontThemeTest1() {
    MyCoupang()
}
