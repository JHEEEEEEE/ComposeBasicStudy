package com.effort.composeonlinestudy.ui.theme

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.effort.composeonlinestudy.R


// font
val bmFont1 = FontFamily(Font(resId = R.font.bmdohyun))
val bmFont2 = FontFamily(Font(resId = R.font.bmjua))

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.ExtraBold,
    ),

    titleMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    ),

    titleSmall = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.SemiBold,
    ),

    bodyLarge = TextStyle(
        fontFamily = bmFont1,
        fontWeight = FontWeight.Normal,
        fontSize = 50.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.5.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = bmFont2,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 25.sp,
        letterSpacing = 0.5.sp
    )
)
