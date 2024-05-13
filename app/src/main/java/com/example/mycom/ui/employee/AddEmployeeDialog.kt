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

@Composable
fun AddEmployeeDialog (
    state: EmployeeState,
    onEvent: (EmployeeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent black color
            .clickable {  onEvent(EmployeeEvent.HideDialog) }, // Dismiss the dialog on background click
        contentAlignment = Alignment.Center
    ) {
        AlertDialog(
            modifier = Modifier,
            onDismissRequest = {
                onEvent(EmployeeEvent.HideDialog)
            },
            title = { Text(text = "Add Employee") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextField(
                        value = state.empName,
                        onValueChange = {
                            onEvent(EmployeeEvent.SetName(it))
                        },
                        placeholder = {
                            Text(text = "Name")
                        }
                    )

                    TextField(
                        value = state.email,
                        onValueChange = {
                            onEvent(EmployeeEvent.SetEmail(it))
                        },
                        placeholder = {
                            Text(text = "Email")
                        }
                    )


                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onEvent(EmployeeEvent.SaveEmployee)
                    }
                ) {
                    Text(text = "Save")
                }
            }
        )
    }

}
