package com.effort.composeonlinestudy.practice.resume

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.R
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class ResumeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                MyResume()
            }
        }
    }
}

@Composable
fun MyResume() {

    Scaffold(
        topBar = {
            MyTopBarTwo()
        }
    ) { paddingValues ->
        MyResumeContent(paddingValues)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarTwo() {
    TopAppBar(
        title = { Text(text = "Android Dev Resume") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.Green
        )
    )
}

@Composable
fun MyResumeContent(paddingValues: PaddingValues) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mancity),
                    contentDescription = "mancity",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "자기소개",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "매일 조금씩이라도 성장하여 최고의 안드로이드 개발자가 될 유정현입니다.\n" +
                            "\n" +
                            "유지보수가 쉬운 클린 아키텍처를 적용하고, 확장 가능한 모듈 설계를 고민합니다.\n" +
                            "\n" +
                            "새로운 기술도 적극적으로 배우고 적용하며, 변화에 능동적으로 적응하는 개발자가 되고자합니다."
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Color.Black,
                    thickness = 2.dp
                )

                Text(
                    text = "핸드폰 번호 : 010-1234-5678"
                )

                Text(
                    text = "이메일 : example@gmail.com"
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"))
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "전화 걸기")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:example@gmail.com")
                        }
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "이메일 보내기")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyResume() {
    ComposeOnlineStudyTheme {
        MyResume()
    }
}