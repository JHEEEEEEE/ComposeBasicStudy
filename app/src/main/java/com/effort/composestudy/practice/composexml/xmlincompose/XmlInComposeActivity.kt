package com.effort.composestudy.practice.composexml.xmlincompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.effort.composestudy.R
import com.effort.composestudy.ui.theme.ComposeStudyTheme

class XmlInComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                XmlInCompose()
            }
        }
    }
}

@Composable
fun XmlInCompose() {

    Column {

        Text(text = "여기는 Compose 1", fontSize = 30.sp)

        // XML
        AndroidView(factory = { context ->

            val view = LayoutInflater.from(context).inflate(R.layout.xmlincompose, null, false)

            view.findViewById<View?>(R.id.temp_text).setOnClickListener {
                Toast.makeText(context, "이것은 Toast", Toast.LENGTH_LONG).show()
            }

            view
        })

        Text(text = "여기는 Compose 2", fontSize = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeStudyTheme {
        XmlInCompose()
    }
}