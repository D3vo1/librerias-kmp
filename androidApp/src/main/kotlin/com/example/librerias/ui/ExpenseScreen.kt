package com.example.librerias.ui
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import  androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.librerias.getColorTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import  androidx.compose.foundation.clickable
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.librerias.data.ExpenseManager
import com.example.librerias.model.Expense
import com.example.librerias.model.ExpenseCategory

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpenseScreen(onExpenseClick:(expense:Expense)->Unit){
    val colors = getColorTheme()
    LazyColumn(modifier = Modifier
        .padding(horizontal =16.dp, vertical = 16.dp ),
        verticalArrangement = Arrangement.spacedBy(8.dp) //Maneja el espacio de la barra superio (DASHBORD)
        ) {
            stickyHeader {
                Column(modifier = Modifier.background(colors.backgroundColor)) {
                    ExpenseTotalHeader(total= 12520.3)
                }
            }
        items(ExpenseManager.fakeExpenseList){
            expense -> ExpenseItem(expense = expense, onExpenseClick = onExpenseClick)
        }

    }
}
@Composable
fun ExpenseTotalHeader(total: Double){
    Card(shape = RoundedCornerShape(30),colors = CardDefaults.cardColors(containerColor = Color.Black),elevation = CardDefaults.cardElevation(5.dp)){
        Box(modifier = Modifier.fillMaxWidth()
            .height(130.dp)
            .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "$$total",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
                )
            Text(text = "MXN", modifier=Modifier.align(Alignment.CenterEnd),color = Color.Gray)
        }
    }
}
@Composable
fun AllExpenseHeader(){
    val colors = getColorTheme()

    Row(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "All Expenses",
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = colors.textColor
        )
        Button(shape= RoundedCornerShape(50),
            onClick = {

            },
            enabled = false
        ){
            Text("View")
        }
    }
}

@Composable
fun ExpenseItem(expense:Expense,
                 onExpenseClick:(expense:Expense) -> Unit ){
        val colors = getColorTheme()
        Card(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 2.dp)
            .clickable{onExpenseClick(expense)}
            .background(colors.backgroundColor),
            shape = RoundedCornerShape(30)
        ){
            Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Surface(modifier = Modifier.size(50.dp),
                    shape = RoundedCornerShape(35),
                    color = colors.purple
                ) {
                    Image(modifier = Modifier.padding(10.dp),
                        imageVector = expense.icon,
                        colorFilter = ColorFilter.tint(Color.White),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }
                Column(modifier = Modifier.weight(1f)
                    .padding(start = 8.dp))
                {
                    Text(text = expense.category.name,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = colors.textColor
                        )
                    Text(expense.description,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.Gray)
                }
                Text(text = "$${expense.amount}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = colors.textColor)
            }
        }
}

@Preview(showBackground = true)
@Composable
fun ExpenseItemPreview(){
    Box(modifier = Modifier.padding(8.dp)){
        ExpenseItem(
            onExpenseClick = {},
            expense = Expense(
                id = 1L,
                amount = 70.0,
                category = ExpenseCategory.PARTY,
                "Fin de semana"
            )
        )
    }
}