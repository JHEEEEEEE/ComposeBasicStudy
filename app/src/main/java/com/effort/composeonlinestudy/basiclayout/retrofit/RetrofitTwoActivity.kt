package com.effort.composeonlinestudy.basiclayout.retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.effort.composeonlinestudy.ui.theme.ComposeOnlineStudyTheme
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class RetrofitTwoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeOnlineStudyTheme {
                InsertInputData()
            }
        }
    }
}

@Composable
fun InsertInputData() {

    // 입력하는 숫자
    var inputNumber by remember { mutableStateOf("") }

    // 받아온 데이터
    var post by remember {
        mutableStateOf<PostTwo?>(null)
    }

    // API 통신하는 부분
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = inputNumber,
            onValueChange = { inputNumber = it },
            label = { Text(text = "숫자 값을 입력하세요") }
        )

        Button(
            onClick = {
                val number = inputNumber.toIntOrNull()
                if (number != null) {
                    coroutineScope.launch {
                        post = getPostData(number)
                    }
                }
            }
        ) {
            Text(text = "데이터 받아오기")
        }

        post?.let {
            Text(text = "UserId : " + it.userId)
            Text(text = "ID : " + it.id)
            Text(text = "Title : " + it.title)
            Text(text = "Body : " + it.body)
        }
    }
}

private suspend fun getPostData(number: Int): PostTwo? {

    val retrofitInstanceTwo = RetrofitInstanceTwo.getInstance().create(MyApiTwo::class.java)
    val response = retrofitInstanceTwo.getPostNumber(number)
    return if (response.isSuccessful) response.body() else null
}

data class PostTwo(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)

object RetrofitInstanceTwo {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance(): Retrofit {
        return client
    }
}

interface MyApiTwo {
    @GET("posts/1")
    suspend fun getPostTwo(): Response<PostTwo>

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number: Int
    ): Response<PostTwo>
}
