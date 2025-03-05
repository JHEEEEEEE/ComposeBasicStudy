package com.effort.composestudy.basiclayout.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effort.composestudy.ui.theme.ComposeStudyTheme

// TextField : 사용자가 입력하는 필드

class TextFieldActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                MyTextFieldThree()
            }
        }
    }
}

@Composable
fun MyTextFieldOne() {

    var textState by remember { mutableStateOf("Hello") }

    // label이 입력창 내부에 존재, 테두리 아래 라인만 존재
    TextField(
        modifier = Modifier.padding(30.dp),
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "입력하는 공간")
        }
    )
}

@Composable
fun MyTextFieldTwo() {

    var textState by remember { mutableStateOf("Hello") }

    // label이 테두리 상에 위치, 테두리가 생성됨
    OutlinedTextField(
        modifier = Modifier.padding(30.dp),
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "입력하는 공간")
        }
    )
}

// TextField에 입력하고 버튼을 클릭할 시에 아래에 입력한 값이 출력되도록
@Composable
fun MyTextFieldThree() {

    var textState by remember { mutableStateOf("") }

    var enteredText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,  // 세로로 중앙정렬
        horizontalAlignment = Alignment.CenterHorizontally // 가로로 중앙정렬
    ) {

        TextField(
            value = textState,
            onValueChange = { textState = it },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                enteredText = textState
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "입력하기")
        }

        Text(
            text = "결과값 텍스트 : $enteredText"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyTextField() {
    ComposeStudyTheme {
        MyTextFieldThree()
    }
}