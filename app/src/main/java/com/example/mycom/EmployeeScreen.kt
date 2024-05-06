package com.example.mycom

import EmployeeAddScreen
import EmployeeDetailScreen
import EmployeeDetails
import EmployeeListScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

    val employees = EmployeeData.allEmployees.toList()

    var selectedEmployee by remember { mutableStateOf<EmployeeData.Employee?>(null) }

    Scaffold { innerPadding ->
        NavHost(
            navController = navController as NavHostController,
            startDestination = List.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = List.name) {
                EmployeeListScreen(
                    employees = employees,
                    onNextButtonPress = {
                        navController.navigate(Add.name)
                    },
                    onEmployeeSelected = { employee ->
                        selectedEmployee = employee // Set the selected employee
                        navController.navigate(EmployeeScreen.Detail.name) // Navigate to details screen
                    }
                )
            }
            composable(route = Add.name) {
                EmployeeAddScreen { name, id, email ->
                    EmployeeData.addEmployee(name, id, email)
                    navController.popBackStack() // Assuming you want to go back after adding an employee
                }
            }

            composable(route = EmployeeScreen.Detail.name) { // Define the Detail route
                selectedEmployee?.let { employee ->
                    EmployeeDetailScreen(employeeDetails = EmployeeDetails(employee.name, employee.id))
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