package com.effort.composeonlinestudy.basiclayout.buttontoast

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class ButtonToastActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                MyButton()
            }
        }
    }
}

@Composable
fun MyButton() {

    val context = LocalContext.current

    Button(
        onClick = {
            Log.d("Main", "onClick")
            Toast.makeText(context, "클릭완료", Toast.LENGTH_LONG).show()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,  //그 담는 버튼 배경색
            contentColor = Color.Blue   // 담길때 들어가는 content 색깔
        ),
        modifier = Modifier
            .width(200.dp)  //버튼 너비
            .height(300.dp) // 버튼 높이
    ) {
        Text(
            text = "버튼입니다. qqqqqqqqqqqqqqqqqqqqqqqqqqqqqq",  //text
            lineHeight = 100.sp, //줄간격
            fontSize = 30.sp,
            color = Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyButton() {
    MyButton()
}