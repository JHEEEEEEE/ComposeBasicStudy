package com.effort.composestudy.basiclayout.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.effort.composestudy.ui.theme.ComposeOnlineStudyTheme

// LazyColumn : https://developer.android.com/develop/ui/compose/lists?hl=ko

class LazyColumnActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOnlineStudyTheme {
                MyLazyColumnEx()
            }
        }
    }
}

 @Composable
fun MyLazyColumnEx() {

    val textList = listOf(
        "A", "B", "C", "A", "B", "C","A", "B", "C", "A", "B", "C","A", "B", "C", "A", "B", "C","A", "B", "C", "A", "B", "C","A", "B", "C", "A", "B", "C","A", "B", "C", "A", "B", "C","A", "B", "C", "A", "B", "C",
    )

     LazyColumn {
         items(textList) { item ->
             Text(
                 text = item,
                 fontSize = 60.sp,
                 modifier = Modifier.fillMaxWidth()
             )
         }
     }
}

@Preview
@Composable
fun PreviewMyLazyColumnEx() {
    ComposeOnlineStudyTheme {
        MyLazyColumnEx()
    }
}