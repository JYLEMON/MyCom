package com.example.mycom.ui.employee

import com.example.mycom.data.Employee

sealed interface EmployeeEvent {
    object SaveEmployee: EmployeeEvent
    data class SetName(val empName: String): EmployeeEvent
    data class SetEmail(val email: String): EmployeeEvent
    data class SetPassword(val password: String): EmployeeEvent
    data class SetSalary(val salary: Double): EmployeeEvent
    object  ShowDialog: EmployeeEvent
    object HideDialog: EmployeeEvent
    object ShowDeleteDialog: EmployeeEvent
    object HideDeleteDialog: EmployeeEvent
    data class ShowDetailDialog(val employee: Employee): EmployeeEvent
    object HideDetailDialog: EmployeeEvent
    data class ShowEditDialog(val employee: Employee): EmployeeEvent
    object HideEditDialog: EmployeeEvent
    data class SortEmployee(val sortType: SortType): EmployeeEvent
    data class DeleteEmployee(val employee: Employee): EmployeeEvent

}