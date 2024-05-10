package com.example.mycom.ui.employee

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycom.ui.employee.EmployeeEditScreen

data class EmployeeDetails(val name: String, val id: String, val email: String)

@Composable
fun EmployeeDetailScreen(
    employeeDetails: EmployeeDetails,
    onEditClick: () -> Unit, // Callback for handling edit button click
    onEmployeeDetailsChange: (EmployeeDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    // State to track whether edit mode is active
    var isEditMode by remember { mutableStateOf(false) }

    if (isEditMode) {
        // Show edit screen
        EmployeeEditScreen(
            initialName = employeeDetails.name,
            initialEmail = employeeDetails.email
        ) { updatedName, updatedEmail ->
            // Update employee details and notify changes back
            val updatedDetails = employeeDetails.copy(name = updatedName, email = updatedEmail)
            onEmployeeDetailsChange(updatedDetails)
            // Exit edit mode
            isEditMode = false
        }
    } else {
        Box(modifier = modifier
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .fillMaxSize()
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = "Name:",
                        modifier = Modifier.padding(end = 8.dp),
                        fontSize = 18.sp // Increase font size
                    )
                    Card(
                        modifier = Modifier.fillMaxWidth(), // Make the card fill the width

                    ) {
                        Text(
                            text = "${employeeDetails.name}",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 18.sp // Increase font size
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = "ID:",
                        modifier = Modifier.padding(end = 8.dp),
                        fontSize = 18.sp // Increase font size
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(), // Make the card fill the width

                    ) {
                        Text(
                            text = "${employeeDetails.id}",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 18.sp // Increase font size
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = "Email: ",
                        modifier = Modifier.padding(end = 8.dp),
                        fontSize = 18.sp // Increase font size
                    )
                    Card(
                        modifier = Modifier.fillMaxWidth(), // Make the card fill the width

                    ) {
                        Text(
                            text = "${employeeDetails.email}",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 18.sp // Increase font size
                        )
                    }
                }
            }

            FloatingActionButton(
                onClick = onEditClick,
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit, // Use the Edit icon
                    contentDescription = "Edit"
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EmployeeDetailPreview() {
    val employeeDetails = EmployeeDetails("John Doe", "E001", "john@gmail.com")
    EmployeeDetailScreen(
        employeeDetails = employeeDetails,
        onEditClick = {}, // Dummy implementation
        onEmployeeDetailsChange = {} // Dummy implementation
    )
}
