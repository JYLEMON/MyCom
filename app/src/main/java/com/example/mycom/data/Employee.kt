package com.example.mycom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee (
    val empName: String,
    val email: String,
    val password: String,
    val salary: String,
    @PrimaryKey(autoGenerate = true)
    val empId: Int = 0
)