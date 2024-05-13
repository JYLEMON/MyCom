package com.example.mycom.ui.employee

import android.content.ClipData.Item
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycom.data.Employee

@Composable
fun EmployeeScreenTest(
    state: EmployeeState,
    onEvent: (EmployeeEvent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(EmployeeEvent.ShowDialog)
                },
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Employee"
                )
            }
        },

        ) { padding ->
        if (state.isAddingEmployee) {
            AddEmployeeDialog(state = state, onEvent = onEvent)
        }

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.employee) { employee ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Transparent,
                        onClick = {  onEvent(EmployeeEvent.ShowDetail(employee)) }
                        // Invoke the callback when card is clicked
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "${employee.empId}",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "${employee.empName}",
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "${employee.email}",
                                    fontSize = 12.sp
                                )
                            }
                            IconButton(onClick = {
                                onEvent(EmployeeEvent.ShowDeleteDialog)
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Delete Employee"
                                )
                            }
                        }
                    }
                }
            }
        }

        if (state.isDeletingEmployee) {
            DeleteEmployeeDialog(state = state, onEvent = onEvent)
        }
    }
}
@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun EmployeeTestPreview() {
    EmployeeScreenTest(state = EmployeeState()) {

    }
}