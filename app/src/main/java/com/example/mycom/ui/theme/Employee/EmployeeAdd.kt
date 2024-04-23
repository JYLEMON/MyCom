import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmployeeAddScreen() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = "Name:")
            Spacer(modifier = Modifier.width(16.dp))
            // Input field for employee name
            OutlinedTextField(
                value = "", // Initial value of the input field
                onValueChange = { /* Handle value change */ },
                modifier = Modifier.weight(1f) // Take up remaining space
            )
        }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = "ID:       ")
            Spacer(modifier = Modifier.width(16.dp))
            // Input field for employee ID
            OutlinedTextField(
                value = "", // Initial value of the input field
                onValueChange = { /* Handle value change */ },
                modifier = Modifier.weight(1f) // Take up remaining space
            )
        }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = "Email:")
            Spacer(modifier = Modifier.width(16.dp))
            // Input field for employee ID
            OutlinedTextField(
                value = "", // Initial value of the input field
                onValueChange = { /* Handle value change */ },
                modifier = Modifier.weight(1f) // Take up remaining space
            )
        }
        // Button for add the employee
        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Add Employee")
        }
        // Add a button to add the employee here
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EmployeeAddPreview() {
    EmployeeAddScreen()
}
