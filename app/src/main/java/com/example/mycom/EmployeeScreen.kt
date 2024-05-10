package com.example.mycom

import com.example.mycom.ui.employee.EmployeeAddScreen
import com.example.mycom.ui.employee.EmployeeDetailScreen
import com.example.mycom.ui.employee.EmployeeDetails
import com.example.mycom.ui.employee.EmployeeEditScreen
import com.example.mycom.ui.employee.EmployeeListScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.mycom.data.EmployeeData

@Composable
fun EmployeeScreen(
    navController: NavController = rememberNavController()
) {
    // List of employees
    val employees = remember { mutableStateListOf(*EmployeeData.allEmployees.toTypedArray()) }

    // Selected employee
    var selectedEmployee by remember { mutableStateOf<EmployeeData.Employee?>(null) }

    // Function to delete an employee
    val onDeleteEmployee: (EmployeeData.Employee) -> Unit = { employee ->
        employees.remove(employee)
    }

    Scaffold { innerPadding ->
        NavHost(
            navController = navController as NavHostController,
            startDestination = EmployeeScreen.List.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = EmployeeScreen.List.name) {
                EmployeeListScreen(
                    employees = employees,
                    onNextButtonPress = {
                        navController.navigate(EmployeeScreen.Add.name)
                    },
                    onEmployeeSelected = { employee ->
                        selectedEmployee = employee // Set the selected employee
                        navController.navigate(EmployeeScreen.Detail.name) // Navigate to details screen
                    },
                    onDeleteEmployee = onDeleteEmployee // Pass onDeleteEmployee callback
                )
            }
            composable(route = EmployeeScreen.Add.name) {
                EmployeeAddScreen { name, id, email ->
                    val newEmployee = EmployeeData.Employee(name, id, email)
                    employees.add(newEmployee)
                    navController.popBackStack() // Assuming you want to go back after adding an employee
                }
            }

            composable(route = EmployeeScreen.Detail.name) { // Define the Detail route
                selectedEmployee?.let { employee ->
                    EmployeeDetailScreen(
                        employeeDetails = EmployeeDetails(
                            name = employee.name,
                            id = employee.id,
                            email = employee.email
                        ),
                        onEditClick = {
                            // Navigate to edit screen
                            navController.navigate(EmployeeScreen.Edit.name)
                        },
                        onEmployeeDetailsChange = { /* Do nothing for now */ }
                    )
                }
            }

            composable(route = EmployeeScreen.Edit.name) { // Define the Edit route
                selectedEmployee?.let { employee ->
                    // Pass initial employee details to the Edit screen
                    EmployeeEditScreen(
                        initialName = employee.name,
                        initialEmail = employee.email
                    ) { updatedName, updatedEmail ->
                        // Update the employee details
                        val updatedEmployee = EmployeeData.Employee(
                            name = updatedName,
                            id = employee.id,
                            email = updatedEmail
                        )
                        // Find the index of the selected employee in the list
                        val index = employees.indexOfFirst { it.id == employee.id }
                        if (index != -1) {
                            // Update the employee in the list
                            employees[index] = updatedEmployee
                        }
                        // Navigate back to the detail screen
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}


enum class EmployeeScreen(val titleResId: Int) {
    List(titleResId = R.string.EmployeeList),
    Add(titleResId = R.string.EmployeeAdd),
    Detail(titleResId = R.string.EmployeeDetail),
    Edit(titleResId = R.string.EmployeeEdit)
}