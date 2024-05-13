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

@Composable
fun DeleteEmployeeDialog (
    state: EmployeeState,
    onEvent: (EmployeeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent black color
            .clickable { onEvent(EmployeeEvent.HideDeleteDialog) }, // Dismiss the dialog on background click
        contentAlignment = Alignment.Center
    ) {
        AlertDialog(
            modifier = Modifier,
            onDismissRequest = {
                onEvent(EmployeeEvent.HideDeleteDialog)
            },
            title = { Text(text = "Delete Employee") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Are you sure you want to delete this employee?")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onEvent(EmployeeEvent.DeleteEmployee(state.selectedEmployee ?: return@Button))
                    }
                ) {
                    Text(text = "Delete")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        onEvent(EmployeeEvent.HideDeleteDialog)
                    }
                ) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}