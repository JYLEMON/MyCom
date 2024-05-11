package com.example.mycom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.mycom.data.EmployeeData
import com.example.mycom.data.EmployeeDatabase
import com.example.mycom.ui.employee.EmployeeScreenTest
import com.example.mycom.ui.employee.EmployeeViewModel
import com.example.mycom.ui.theme.MyComTheme

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            EmployeeDatabase::class.java,
            "employee.db"
        ).build()
    }
    private val viewModel by viewModels<EmployeeViewModel>(
        factoryProducer = {
            object  : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return EmployeeViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MyComTheme {
                // A surface container using the 'background' color from the theme
                val state by viewModel.state.collectAsState()
                EmployeeScreenTest(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}