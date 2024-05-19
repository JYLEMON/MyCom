package com.example.mycom.EmployeeWorkData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmployeeWork (
    @PrimaryKey(autoGenerate = true)
    val empWork: Int = 0,
    val empId: String = "",
    val workID: String = "",
    @PrimaryKey(autoGenerate = true)
    val count: Int = 0
)