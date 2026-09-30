package com.example.librerias

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppTheme(content:@Composable ()->Unit){
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(primary = Color.Black),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(size = 0.dp),
            medium = AbsoluteCutCornerShape(size = 0.dp),
                    large = AbsoluteCutCornerShape(size = 0.dp)
        )
    ){
        content()
    }
}

@Composable
fun getColorTheme(): DarkModeColors{
    val isDarkMode = false

    val Purple = Color(0xff6a66ff)
    val ColorExpenseItem = if(isDarkMode) Color(0xff090808) else Color(0xfff1f1f1)
    val BackgroundColor = if(isDarkMode) Color(0xff1e1c1c) else Color.White
    val TextColor = if(isDarkMode) Color.White else Color.Black
    val IconColor = if(isDarkMode) Purple else Color.Black
    val ColorArrowRound = if(isDarkMode) Purple else Color.Gray.copy(alpha = 0.2f)
    return DarkModeColors(
        purple = Purple,
        colorExpenseItem = ColorExpenseItem,
        backgroundColor = BackgroundColor,
        textColor = TextColor,
        iconColor = IconColor,
        colorArrowRound = ColorArrowRound

    )
}

data class DarkModeColors(
    val purple : Color,
    val colorExpenseItem : Color,
    val backgroundColor : Color,
    val textColor : Color,
    val iconColor : Color,
    val colorArrowRound: Color
)