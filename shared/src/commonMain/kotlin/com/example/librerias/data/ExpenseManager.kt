package com.example.librerias.data

import com.example.librerias.model.Expense
import com.example.librerias.model.ExpenseCategory

object ExpenseManager{
    private var currentId = 1L
    val fakeExpenseList = mutableListOf<Expense>()

    fun addNewExpense(expense: Expense){
        fakeExpenseList.add(expense.copy(id = currentId++))
    }
    fun editExpense(expense: Expense){
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }
    fun getCategories():List<ExpenseCategory>{
        return listOf(
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACKS,
            ExpenseCategory.GROCERIES,
            ExpenseCategory.OTHER,
            ExpenseCategory.CAR,
            ExpenseCategory.COFFEE,
            ExpenseCategory.HOUSE
        )
    }
    fun deleteExpense(expense: Expense){
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        fakeExpenseList.removeAt(index)
//        fakeExpenseList.removeAll { it.id == expense.id }
    }
}

