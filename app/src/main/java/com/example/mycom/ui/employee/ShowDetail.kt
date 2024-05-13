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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mycom.data.Employee

@Composable
fun ShowDetail(
    employee: Employee,
    onClose: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent black color
            .clickable(onClick = onClose), // Close the dialog on background click
        contentAlignment = Alignment.Center
    ) {
        AlertDialog(
            modifier = Modifier,
            onDismissRequest = onClose,
            title = { Text(text = "Employee Details") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Name: ${employee.empName}")
                    Text(text = "Email: ${employee.email}")

                    // Add more details as needed
                }
            },
            confirmButton = {
                // Add a button to close the dialog
                Button(
                    onClick = onClose
                ) {
                    Text(text = "Close")
                }
            }
        )
    }
}
