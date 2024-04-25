package com.example.mycom

import Employee
import EmployeeAddScreen
import EmployeeListScreen
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    navController: NavHostController = rememberNavController()
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
                    employees = employees,
                    onNextButtonPress = {
                        navController.navigate(Add.name)
                    }
                )
            }
            composable(route = Add.name) {
                val context = LocalContext.current
                EmployeeAddScreen(
                    onAddButtonClicked = { name: String, id: String, email: String ->
                        addEmployee(context, name = name, id = id, email= email)
                    },
                )
            }
        }
    }
}

private fun addEmployee(context: Context, name: String, id: String, email: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type =  "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "EMPLOYEE DETAIL")
        val sharedText = "Name: $name\\nID: S001\\nEmail: john@example.com" // Using the passed name parameter
        putExtra(Intent.EXTRA_TEXT, sharedText)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            "Share via"
        )
    )
}


enum class EmployeeScreen(val titleResId: Int) {
    List(titleResId = R.string.EmployeeList),
    Add(titleResId = R.string.EmployeeAdd)
}
