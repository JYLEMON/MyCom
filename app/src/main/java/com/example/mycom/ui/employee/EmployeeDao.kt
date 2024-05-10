package com.example.mycom.ui.employee

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.mycom.data.Employee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Upsert
    suspend fun upsertEmployee(employee: Employee)

    @Delete
    suspend fun deleteEmployee(employee: Employee)

    @Query("SELECT * FROM Employee ORDER BY empName ASC")
    fun getEmployeeOrderedByName(): Flow<List<Employee>>
}