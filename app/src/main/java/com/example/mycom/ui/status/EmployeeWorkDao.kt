package com.example.managementsystem.ManagementModule

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.managementsystem.Data.Work
import com.example.mycom.EmployeeWorkData.EmployeeWork
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeWorkDao {

    @Upsert
    suspend fun upsertWork(employeeWork: EmployeeWork)

    @Delete
    suspend fun deleteWork(employeeWork: EmployeeWork)

    @Update
    suspend fun updateWork(employeeWork: EmployeeWork)

    @Query("SELECT * FROM EmployeeWork ORDER BY empId ASC")
    fun getEmployeeWorkListOrderById(): Flow<List<EmployeeWork>>
}