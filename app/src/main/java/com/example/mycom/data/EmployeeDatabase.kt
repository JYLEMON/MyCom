package com.example.mycom.data

import androidx.room.Database
import com.example.mycom.ui.employee.EmployeeDao

@Database(
    entities = [Employee::class],
    version = 1
)
abstract class EmployeeDatabase {

    abstract val dao: EmployeeDao
}