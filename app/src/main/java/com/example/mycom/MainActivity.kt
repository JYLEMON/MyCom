package com.example.mycom


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.managementsystem.Data.WorkDatabase
import com.example.managementsystem.ManagementModule.WorkViewModel
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

    private val workdb by lazy {
        Room.databaseBuilder(
            applicationContext,
            WorkDatabase::class.java,
            "workList.db"
        ).build()
    }

    private val workViewModel by viewModels<WorkViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <U : ViewModel> create (modelClass: Class<U>): U {
                    return WorkViewModel(workdb.dao) as U
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
                val workState by workViewModel.state.collectAsState()
                //EmployeeScreenTest(state = state, onEvent = viewModel::onEvent)
                //StatusNavigationHost(workListState = workState)
                EmployeeScreenTest(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}