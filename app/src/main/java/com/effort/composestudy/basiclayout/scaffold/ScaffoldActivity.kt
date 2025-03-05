package com.effort.composestudy.basiclayout.scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.effort.composestudy.ui.theme.ComposeStudyTheme

class ScaffoldActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                MyScaffold()
            }
        }
    }
}

@Composable
fun MyScaffold() {

    Scaffold(
        topBar = {
            MyTopBar()
        },
        floatingActionButton = {
            MyFloatingActionButton()
        },
        bottomBar = {
            MyBottomBar()
        }
    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)  // 컨텐츠가 상단바랑 하단바에 겹치지 않게 padding을 줌
        ) {
            Text(text = "this is content.")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        title = {
            Text(text = "Main")
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "add")
            }
        },
        actions = {
            Button(
                onClick = {}
            ) {
                Text(text = "Btn")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.Blue
        )
    )
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {}
    ) {
        Icon(Icons.Default.Menu, contentDescription = "Menu")
    }
}

@Composable
fun MyBottomBar() {

    BottomAppBar(
        containerColor = Color.Red,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            }
            IconButton(
                onClick = {}
            ) {
                Icon(Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyScaffold() {
    ComposeStudyTheme {
        MyScaffold()
    }
}
