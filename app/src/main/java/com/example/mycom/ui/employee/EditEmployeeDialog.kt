// EditEmployeeDialog.kt

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mycom.data.Employee
import com.example.mycom.ui.employee.EmployeeEvent
import com.example.mycom.ui.employee.EmployeeState

@Composable
fun ShowEditDialog(
    state: EmployeeState,
    onEvent: (EmployeeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable {
                onEvent(EmployeeEvent.HideDetailDialog)
                onEvent(EmployeeEvent.HideEditDialog)
            },
        contentAlignment = Alignment.Center
    ) {
        AlertDialog(
            modifier = Modifier,
            onDismissRequest = {
                onEvent(EmployeeEvent.HideDetailDialog)
                onEvent(EmployeeEvent.HideEditDialog)
            },
            title = { Text(text = "Edit Employee") },
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

                    TextField(
                        value = state.password,
                        onValueChange = {
                            onEvent(EmployeeEvent.SetPassword(it))
                        },
                        placeholder = {
                            Text(text = "Password")
                        }
                    )

                    TextField(
                        value = state.salary.toString(),
                        onValueChange = { newValue ->
                            val parsedValue = newValue.toDoubleOrNull() ?: state.salary
                            onEvent(EmployeeEvent.SetSalary(parsedValue))
                        },
                        placeholder = {
                            Text(text = "Salary")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        visualTransformation = VisualTransformation.None
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onEvent(EmployeeEvent.SaveEmployee)
                        onEvent(EmployeeEvent.HideDetailDialog)
                        onEvent(EmployeeEvent.HideEditDialog)
                    }
                ) {
                    Text(text = "Save")
                }
            }
        )
    }
}
