@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.otherScreen.Homepage
import com.example.myapplication.ui.theme.otherScreen.LoginScreen
import com.example.myapplication.ui.theme.otherScreen.ProfileScreen
import com.example.myapplication.ui.theme.otherScreen.RegisterScreen
import com.example.mycom.R

enum class MainScreen(@StringRes val title: Int) {
    Login(title = R.string.login),
    Home(title = R.string.home),
    StaffProfile(title = R.string.profile),
    Register(title = R.string.register ),
    StaffApproval(title = R.string.staff)
}




@Composable
fun app(navController: NavHostController = rememberNavController()){
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = MainScreen.valueOf(
        backStackEntry?.destination?.route ?: MainScreen.Login.name
    )
    Scaffold (topBar = {

    }){ innerPadding ->
    NavHost(
        navController = navController,
        startDestination = MainScreen.Login.name,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)){
        composable(route = MainScreen.Login.name){
                LoginScreen(
                    onFirstButtonClicked = {
                        navController.navigate(MainScreen.Home.name)
                    },
                    onSecondButtonClicked = {
                        navController.navigate(MainScreen.Register.name)

                    })
    }
        composable(route = MainScreen.Home.name){
          Homepage(
              onClickButton1 = {

              },
              onClickButton2 = {
                  navController.navigate(MainScreen.StaffProfile.name)
              }
          )
        }
        composable(route = MainScreen.StaffProfile.name) {
            ProfileScreen(
                name = "liangyouxian",
                email = "liangyouxian1@gmail.com",
                salary = "2000.50",
                work = "10",
                notification = "Work/Staff Approval:",
                textbotton1 = "Approval Leave & Late",
                onClickButton1 = {

                },
                onClickButton2 = {},
                onClickButton3 = {
                    navController.navigate(MainScreen.Login.name)
                })
        }
            composable(route = MainScreen.Register.name) {
                RegisterScreen(
                    onClickButton1 = {
                        navController.navigate(MainScreen.Home.name)
                },
                    onClickButton2 = {
                        navController.navigate(MainScreen.Login.name)
                    }
                )

        }

    }
    }
}

