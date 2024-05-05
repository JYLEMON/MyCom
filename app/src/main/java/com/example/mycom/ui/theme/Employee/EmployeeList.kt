package com.example.mycom.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycom.data.Employee
import com.example.mycom.ui.theme.Employee.EmployeeViewModel

@Composable
fun EmployeeListScreen(
    employees: List<Employee> = emptyList(), // Use empty list as default
    viewModel: EmployeeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val employeesState by viewModel.employees.collectAsState()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            items(employeesState) { employee ->
                EmployeeListItem(employee = employee)
            }
        }
        FloatingActionButton(
            onClick = {
                viewModel.onAddEmployeeClick() // Use exposed function from ViewModel
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .clip(CircleShape)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add Employee",
            )
        }
    }
}

@Composable
fun EmployeeListItem(employee: Employee) {
    Spacer(modifier = Modifier.padding(4.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp)) // Set background color
            .padding(8.dp)
    ) {
        Column {
            Row {
                Text(text = "Name: ${employee.name}")
            }
            Row {
                Text(text = "ID: ${employee.id}")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EmployeeListPreview() {
    EmployeeListScreen(
        employees = listOf(
            Employee("John", "S001", "john@example.com"),
            Employee("Alice", "S002", "alice@example.com")
        )
    )
}
