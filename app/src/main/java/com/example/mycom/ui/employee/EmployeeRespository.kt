package com.example.mycom.ui.employee

import com.example.mycom.data.Employee

class EmployeeRepository(
    private val dao: EmployeeDao
) {
    suspend fun authenticate(id: String, password: String): Employee? {
        return dao.login(id, password)
    }
}