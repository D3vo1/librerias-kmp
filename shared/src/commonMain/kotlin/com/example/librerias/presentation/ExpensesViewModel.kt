package com.example.librerias.presentation

import com.example.librerias.domain.ExpenseRepository
import com.example.librerias.model.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class ExpensesViewModel(private val repo: ExpenseRepository): ViewModel() {
    data class ExpensesUIState(
        val expense: List<Expense> = emptyList(),
        val total : Double = 0.0
    )

    private val _uiState = MutableStateFlow(ExpensesUIState())

   val uiState = _uiState
    private val allExpenses = repo.getAllExpenses()

    private fun getAllExpenses(){
        viewModelScope.launch {
            _uiState.update {
                state -> state.copy(
                    expense = allExpenses,
                    total = allExpenses.sumOf { it.amount }
                )
            }
        }
    }

}