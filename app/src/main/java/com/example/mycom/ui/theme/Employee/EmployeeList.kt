import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycom.data.EmployeeData.Employee

@Composable
fun EmployeeListScreen(
    employees: List<Employee>,
    onNextButtonPress: () -> Unit,
    onEmployeeSelected: (Employee) -> Unit,
    onDeleteEmployee: (Employee) -> Unit,
    modifier: Modifier = Modifier
) {
    var employeeToDelete by remember { mutableStateOf<Employee?>(null) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            items(employees) { employee ->
                EmployeeListItem(
                    employee = employee,
                    onEmployeeSelected = onEmployeeSelected,
                    onDeleteEmployee = { employeeToDelete = employee }
                )
            }
        }
        FloatingActionButton(
            onClick = onNextButtonPress,
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

        // Background overlay
        if (employeeToDelete != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)) // Semi-transparent black color
                    .clickable { employeeToDelete = null }, // Dismiss the dialog on background click
                contentAlignment = Alignment.Center
            ) {
                // Delete confirmation dialog
                AlertDialog(
                    onDismissRequest = { employeeToDelete = null },
                    title = { Text(text = "Confirm Deletion") },
                    text = { Text(text = "Are you sure you want to delete ${employeeToDelete?.name}?") },
                    confirmButton = {
                        Button(
                            onClick = {
                                onDeleteEmployee(employeeToDelete!!)
                                employeeToDelete = null
                            }
                        ) {
                            Text(text = "Confirm")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { employeeToDelete = null }
                        ) {
                            Text(text = "Cancel")
                        }
                    }
                )
            }
        }
    }
}
@Composable
fun EmployeeListItem(
    employee: Employee,
    onEmployeeSelected: (Employee) -> Unit,
    onDeleteEmployee: () -> Unit // Callback for delete action
) {
    Spacer(modifier = Modifier.padding(4.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(56.dp)
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Transparent,
            onClick = { onEmployeeSelected(employee) }
            // Invoke the callback when card is clicked
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = employee.name)
                    Text(text = employee.id.toString()) // Convert id to string for display
                }
                IconButton(
                    onClick = onDeleteEmployee,
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete Employee"
                    )
                }
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
    val employees = com.example.mycom.data.EmployeeData.allEmployees.toList()

    EmployeeListScreen(
        employees = employees,
        onNextButtonPress = {},
        onEmployeeSelected = {},
        onDeleteEmployee = {}
    )
}
