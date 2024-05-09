package com.example.mycom

import EmployeeAddScreen
import EmployeeDetailScreen
import EmployeeDetails
import EmployeeListScreen
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.mycom.EmployeeScreen.List
import com.example.mycom.EmployeeScreen.Add
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
                        onEditClick = {} // Provide a dummy implementation
                    )
                }
            }

        }
    }
}


enum class EmployeeScreen(val titleResId: Int) {
    List(titleResId = R.string.EmployeeList),
    Add(titleResId = R.string.EmployeeAdd),
    Detail(titleResId = R.string.EmployeeDetail)
}