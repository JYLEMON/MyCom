package com.example.mycom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee (
    val empName: String,
    val email: String,
    @PrimaryKey(autoGenerate = true)
    val empId: Int = 0
) {
    // Custom getter for empId
    val formattedEmpId: String
        get() = "E${empId.toString().padStart(3, '0')}"
}