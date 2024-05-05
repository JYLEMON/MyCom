package com.example.mycom

import Employee
import EmployeeAddScreen
import EmployeeListScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.mycom.EmployeeScreen.List
import com.example.mycom.EmployeeScreen.Add

@Composable
fun EmployeeScreen(
    navController: NavController = rememberNavController()
) {
    val employees = listOf(
        Employee("John", "S001"),
        Employee("Alice", "S002"),
        // Add more employees as needed
    )

    val backStackEntry = navController.currentBackStackEntryAsState().value
    val currentScreen = EmployeeScreen.valueOf(
        backStackEntry?.destination?.route ?: List.name
    )
    Scaffold { innerPadding ->
        NavHost(
            navController = navController as NavHostController,
            startDestination = List.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = List.name) {
                EmployeeListScreen(
                    employees = employees, // Pass the list of employees
                    onNextButtonPress = {
                        navController.navigate(Add.name)
                    }
                )
            }
            composable(route = Add.name) {
                EmployeeAddScreen()// Composable for adding an employee
            }
        }
    }
}

enum class EmployeeScreen(val titleResId: Int) {
    List(titleResId = R.string.EmployeeList),
    Add(titleResId = R.string.EmployeeAdd)
}
