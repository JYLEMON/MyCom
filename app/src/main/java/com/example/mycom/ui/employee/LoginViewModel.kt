package com.example.mycom.ui.employee

import android.app.Application
import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycom.data.EmployeeDatabase
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: EmployeeRepository
    val snackbarHostState = SnackbarHostState()

    init {
        val employeeDao = EmployeeDatabase.getDatabase(application).dao
        repository = EmployeeRepository(employeeDao)
    }

    fun login(id: String, password: String, onSuccess: () -> Unit, onFailure: () -> Unit) {
        viewModelScope.launch {
            val employee = repository.authenticate(id, password)
            if (employee != null) {
                onSuccess()
            } else {
                onFailure()
            }
        }
    }
}