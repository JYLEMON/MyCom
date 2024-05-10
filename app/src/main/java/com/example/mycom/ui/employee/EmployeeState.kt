package com.example.mycom.ui.employee

import com.example.mycom.data.Employee

data class EmployeeState (
    val employee: List<Employee> = emptyList(),
    val empName: String = "",
    val email: String = "",
    val isAddingEmployee: Boolean = false,
    val sortType: SortType = SortType.EMP_NAME
)
