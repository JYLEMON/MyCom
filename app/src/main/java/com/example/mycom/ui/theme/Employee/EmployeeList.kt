import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Employee(val name: String, val id: String)

val boxColor = Color(0xFFF5F5DC) // Define rice color here

@Composable
fun EmployeeListScreen(
    employees: List<Employee>,
    onNextButtonPress: () -> Unit, // Added onNextButtonPress parameter
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            items(employees) { employee ->
                EmployeeListItem(employee = employee)
            }
        }
        FloatingActionButton(
            onClick = onNextButtonPress, // Changed onClick parameter
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
    }
}

@Composable
fun EmployeeListItem(employee: Employee) {
    Spacer(modifier = Modifier.padding(4.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(boxColor, shape = RoundedCornerShape(8.dp)) // Set background color
            .padding(8.dp)
    ) {
        Column {
            Row {
                Text(text = employee.name)
            }
            Row {
                Text(text = employee.id)
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
    val employees = listOf(
        Employee("John", "S001"),
        Employee("Alice", "S002"),
        // Add more employees as needed
    )

    EmployeeListScreen(
        employees = employees,
        onNextButtonPress = {}
    )
}
