package com.example.librerias.Previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.librerias.model.Expense
import com.example.librerias.model.ExpenseCategory
import com.example.librerias.ui.ExpenseItem

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExpenseItemPreview(){
    Box(modifier = Modifier.padding(all=8.dp)){
        ExpenseItem(
            onExpenseClick = {},
            expense = Expense(
                id = 1L,
                amount = 70.0,
                category = ExpenseCategory.PARTY,
                description = "Fin de semana"
            )
        )
    }
}
