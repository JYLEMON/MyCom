package com.example.mycom.ui.employee

import com.example.mycom.data.Employee

sealed interface EmployeeEvent {
    object SaveEmployee: EmployeeEvent
    data class SetName(val empName: String): EmployeeEvent
    data class SetEmail(val email: String): EmployeeEvent
    data class ShowDetail(val employee: Employee): EmployeeEvent
    object  ShowDialog: EmployeeEvent
    object HideDialog: EmployeeEvent
    data class SortEmployee(val sortType: SortType): EmployeeEvent
    data class DeleteEmployee(val employee: Employee): EmployeeEvent
}