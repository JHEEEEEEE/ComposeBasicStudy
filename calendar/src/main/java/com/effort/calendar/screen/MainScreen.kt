package com.effort.calendar.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.effort.calendar.ui.theme.CalendarTheme

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
    Text(text = "안녕")
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    CalendarTheme {
        MainScreenContent()
    }
}