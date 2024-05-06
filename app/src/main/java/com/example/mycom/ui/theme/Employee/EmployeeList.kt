
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                EmployeeListItem(employee = employee, onEmployeeSelected)
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
    }
}

@Composable
fun EmployeeListItem(employee: Employee, onEmployeeSelected: (Employee) -> Unit) {
    Spacer(modifier = Modifier.padding(4.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(56.dp),
        shape = RoundedCornerShape(8.dp),

        ) {
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = Color.Transparent,
            onClick = { onEmployeeSelected(employee) }
            // Invoke the callback when card is clicked
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Row {
                    Text(text = employee.name)
                }
                Row {
                    Text(text = employee.id.toString()) // Convert id to string for display
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
        onEmployeeSelected = {}
    )
}