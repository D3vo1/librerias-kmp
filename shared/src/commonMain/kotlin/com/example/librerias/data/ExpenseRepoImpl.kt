package com.example.librerias.data

import com.example.librerias.domain.ExpenseRepository
import com.example.librerias.model.Expense
import com.example.librerias.model.ExpenseCategory

class ExpenseRepoImpl: ExpenseRepository {
    override fun getAllExpenses(): List<Expense> {
          return ExpenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
        ExpenseManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        ExpenseManager.editExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return ExpenseManager.getCategories()
    }
}