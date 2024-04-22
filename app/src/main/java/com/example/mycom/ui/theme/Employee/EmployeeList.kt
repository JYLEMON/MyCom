package com.example.mycom.ui.theme.Employee

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

data class Employee(val name: String, val id: String)

@Composable
fun EmployeeListScreen(
    employees: List<Employee>,
    modifier: Modifier = Modifier
){
    LazyColumn (
        modifier = modifier
    ){
        items(employees) { employee ->
            EmployeeListItem(employee = employee)
        }
    }
}

@Composable
fun EmployeeListItem(employee: Employee) {
    Row {
        Text(text = employee.name)
        Text(text = employee.id)
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EmployeeListPreview() {
    val employees = listOf(
        Employee("John", "S001"),
        Employee("Test", "S002")
    )
    EmployeeListScreen(employees = employees)
}
