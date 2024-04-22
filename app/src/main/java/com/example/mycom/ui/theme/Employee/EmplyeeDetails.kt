import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class EmployeeDetails(val name: String, val id: String)

@Composable
fun EmployeeDetailScreen(
    employeeDetails: EmployeeDetails,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        Text(text = "Name: ${employeeDetails.name}")
        Spacer(modifier = Modifier.height(8.dp)) // Add vertical space between name and id
        Text(text = "ID: ${employeeDetails.id}")
        // Add more Text composables for additional employee details if needed
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EmployeeDetailPreview() {
    val employeeDetails = EmployeeDetails("John Doe", "001")
    EmployeeDetailScreen(employeeDetails = employeeDetails)
}
