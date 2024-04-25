import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmployeeAddScreen(
    onAddButtonClicked: (String, String, String) -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = "Name:")
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = "ID:")
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = "Email:")
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.weight(1f)
            )
        }
        Button(
            onClick = {
                onAddButtonClicked(name, id, email)
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Add Employee")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EmployeeAddPreview() {
    EmployeeAddScreen(
        onAddButtonClicked = { name: String, id: String, email: String -> },
    )
}
