package com.example.mycom

import EmployeeAddScreen
import EmployeeListScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.mycom.data.Employee
import com.example.mycom.ui.EmployeeAddScreen
import com.example.mycom.ui.EmployeeListScreen
import com.example.mycom.ui.EmployeeViewModel
import com.example.mycom.ui.theme.Employee.EmployeeViewModel

enum class EmployeeScreen(val titleResId: Int) {
    List(titleResId = R.string.EmployeeList),
    Add(titleResId = R.string.EmployeeAdd)
}

@Composable
fun EmployeeScreen(
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val viewModel = EmployeeViewModel(context) // Use ViewModel for data management

    val currentScreen by remember {
        derivedStateOf {
            navController.currentBackStackEntry?.destination?.route ?: EmployeeScreen.List.name
        }
    }

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = EmployeeScreen.List.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = EmployeeScreen.List.name) {
                EmployeeListScreen(
                    employees = viewModel.employees.collectAsState().value, // Use data from ViewModel
                    onNextButtonPress = {
                        navController.navigate(EmployeeScreen.Add.name)
                    }
                )
            }
            composable(route = EmployeeScreen.Add.name) {
                EmployeeAddScreen(
                    onAddButtonClicked = { name: String, id: String, email: String ->
                        viewModel.addEmployee(name, id, email) // Add employee via ViewModel
                    },
                )
            }
        }
    }
}
