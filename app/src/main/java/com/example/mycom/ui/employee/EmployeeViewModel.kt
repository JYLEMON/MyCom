package com.example.mycom.ui.employee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycom.data.Employee
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val dao: EmployeeDao
): ViewModel() {

    private val _sortType = MutableStateFlow(SortType.EMP_NAME)
    private val _employees = _sortType
        .flatMapLatest { sortType ->
            when(sortType) {
                SortType.EMP_NAME -> dao.getEmployeeOrderedByName()
            }
        }
    private val _state = MutableStateFlow(EmployeeState())
    val state = combine(_state, _sortType, _employees) { state, sortType, employees ->
        state.copy(
            employee = employees,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), EmployeeState())

    fun onEvent(event: EmployeeEvent) {
        when(event) {
            is EmployeeEvent.DeleteEmployee -> {
                viewModelScope.launch {
                    dao.deleteEmployee(event.employee)
                }
            }
            EmployeeEvent.HideDialog -> {
                _state.update {it.copy(
                    isAddingEmployee = false
                ) }
            }

            EmployeeEvent.SaveEmployee -> {
                val empName = state.value.empName
                val email = state.value.email

                if(empName.isBlank() || email.isBlank()) {
                    return
                }

                val employee = Employee(
                    empName = empName,
                    email = email
                )
                viewModelScope.launch {
                    dao.upsertEmployee(employee)
                }
                _state.update { it.copy(
                    isAddingEmployee = false,
                    empName = "",
                    email = ""
                ) }
            }
            is EmployeeEvent.SetEmail -> {
                _state.update { it.copy(
                    email = event.email
                ) }
            }
            is EmployeeEvent.SetName -> {
                _state.update { it.copy(
                    empName = event.empName
                ) }
            }
            EmployeeEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingEmployee = true
                ) }
            }
            is EmployeeEvent.SortEmployee ->{
                _sortType.value = event.sortType
            }
        }
    }
}