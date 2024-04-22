package com.example.mycom.ui.theme.Employee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Employee(val name: String, val id: String)

val riceColor = Color(0xFFF5F5DC) // Define rice color here

@Composable
fun EmployeeListScreen(
    employees: List<Employee>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(employees) { employee ->
            EmployeeListItem(employee = employee)
        }
    }
}

@Composable
fun EmployeeListItem(employee: Employee) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .background(riceColor, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            , // Use background() to set background color
    ) {
        Column {
            Row {
                Text(text = employee.name)
            }
            Row {
                Text(text = employee.id)
            }
        }
    }
    Spacer(modifier = Modifier.padding(4.dp))
}

@Preview(
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
