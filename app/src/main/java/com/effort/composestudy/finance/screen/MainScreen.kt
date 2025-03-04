package com.effort.composestudy.finance.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.effort.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun MainScreen() {


    Text(text = "Main")
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    ComposeStudyTheme {
        MainScreen()
    }
}