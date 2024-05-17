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
            is EmployeeEvent.ShowEditDialog -> {
                _state.update { it.copy(isEditingEmployee = true) }
            }
            is EmployeeEvent.HideEditDialog -> {
                _state.update { it.copy(isEditingEmployee = false) }
            }

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



            EmployeeEvent.HideDeleteDialog -> {
                _state.update { it.copy(
                    isDeletingEmployee = false
                ) }
            }

            EmployeeEvent.SaveEmployee -> {
                val empName = state.value.empName
                val email = state.value.email
                val password = state.value.password
                val salary = state.value.salary

                if(empName.isBlank() || email.isBlank() || password.isBlank()) {
                    return
                }

                val employee = Employee(
                    empName = empName,
                    email = email,
                    password = password,
                    salary = salary.toString()
                )
                viewModelScope.launch {
                    dao.upsertEmployee(employee)
                }
                _state.update { it.copy(
                    isAddingEmployee = false,
                    empName = "",
                    email = "",
                    password = "",
                    salary = 2500.00,
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
            is EmployeeEvent.SetPassword -> {
                _state.update { it.copy(
                    password = event.password
                ) }
            }
            is EmployeeEvent.SetSalary -> {
                _state.update { it.copy(
                    salary = event.salary
                ) }
            }
            EmployeeEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingEmployee = true
                ) }
            }

            EmployeeEvent.ShowDeleteDialog -> {
                _state.update { it.copy(
                    isDeletingEmployee = true
                ) }
            }

            is EmployeeEvent.SortEmployee ->{
                _sortType.value = event.sortType
            }

            is EmployeeEvent.ShowDetailDialog -> {
                _state.update { it.copy(
                    isShowingDetail = true,
                    selectedEmployee = event.employee
                ) }
            }

            is EmployeeEvent.HideDetailDialog -> {
                _state.update { it.copy(
                    isShowingDetail = false,
                ) }
            }
        }
    }
}