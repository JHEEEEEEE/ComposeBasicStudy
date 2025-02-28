package com.effort.composeonlinestudy.practice.graph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme

class GraphActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeOnlineStudyTheme {
                GraphAppMain()
            }
        }
    }
}

@Composable
fun GraphAppMain() {

    val navItems = listOf(
        NavigationItem("그래프 1", Icons.Default.AddCircle, "tab1"),
        NavigationItem("그래프 2", Icons.Default.AddCircle, "tab2"),
        NavigationItem("그래프 3", Icons.Default.AddCircle, "tab3")
    )

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Blue,
                contentColor = Color.White
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    navItems.forEach { nav ->

                        //현재 route
                        val currentRoute =
                            navController.currentBackStackEntryAsState().value?.destination?.route

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable {
                                navController.navigate(nav.route)
                            }
                        ) {
                            val isCurrentRoute = nav.route == currentRoute

                            Icon(
                                imageVector = nav.icon,
                                contentDescription = nav.name,
                                tint = if (isCurrentRoute) Color.Red else Color.Black
                            )
                            Text(
                                text = nav.name,
                                color = if (isCurrentRoute) Color.Red else Color.Black
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = navItems.first().route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("tab1") {
                Graph1()
            }
            composable("tab2") {
                Graph2()
            }
            composable("tab3") {
                Graph3()
            }
        }
    }
}

@Preview
@Composable
fun PreviewGraph() {
    ComposeOnlineStudyTheme {
        GraphAppMain()
    }
}