package com.example.mycom.ui.employee

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mycom.data.Employee

@Composable
fun ShowDetailDialog(
    state: EmployeeState,
    onEvent: (EmployeeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedEmployee = state.selectedEmployee ?: return // Return early if selectedEmployee is null

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable(onClick = { onEvent(EmployeeEvent.HideDetailDialog) }),
        contentAlignment = Alignment.Center
    ) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = { onEvent(EmployeeEvent.HideDetailDialog) },
            title = { Text(text = "Employee Details") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "ID: ${selectedEmployee.empId}")
                    Text(text = "Name: ${selectedEmployee.empName}")
                    Text(text = "Email: ${selectedEmployee.email}")
                    Text(text = "Password: ${selectedEmployee.password}")
                    Text(text = "Salary: ${selectedEmployee.salary}")
                }
            },
            confirmButton = {
                Button(
                    onClick = { onEvent(EmployeeEvent.HideDetailDialog) }
                ) {
                    Text(text = "Close")
                }
            }
        )
    }
}


