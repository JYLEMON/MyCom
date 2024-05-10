package com.example.mycom.ui.employee

import android.content.ClipData.Item
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycom.data.Employee

@Composable
fun EmployeeScreenTest(
    state: EmployeeState,
    onEvent: (EmployeeEvent) -> Unit
) {
    Scaffold { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(state.employee) { Employee ->
                Row (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column (
                        modifier = Modifier.weight(1f)
                    ){
                        Text(text = "${Employee.empName}",
                            fontSize = 20.sp
                        )
                        Text(text = "${Employee.email}", fontSize = 12.sp)
                    }
                    IconButton(onClick = {
                        onEvent(EmployeeEvent.DeleteEmployee(Employee))
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