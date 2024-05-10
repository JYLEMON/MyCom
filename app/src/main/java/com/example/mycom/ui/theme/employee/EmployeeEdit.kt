import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmployeeEditScreen(
    initialName: String,
    initialEmail: String,
    onEmployeeUpdated: (String, String) -> Unit,
) {
    var name by remember { mutableStateOf(initialName) }
    var email by remember { mutableStateOf(initialEmail) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = "Name:",
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = "Email:",
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.weight(1f)
            )
        }
        Button(
            onClick = {
                // Update the employee details and notify the changes back
                onEmployeeUpdated(name, email)
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Update Employee")
        }
    }
}

@Preview
@Composable
fun EmployeeEditPreview() {
    EmployeeEditScreen(
        initialName = "John Doe",
        initialEmail = "john@example.com",
        onEmployeeUpdated = { _, _ -> /* Dummy lambda for preview */ }
    )
}
