// EmployeeData.kt
package com.example.mycom.data

class EmployeeData {
    data class Employee(
        val name: String,
        val id: String
    )

    val allEmployees: Set<Employee> =
        setOf(
            Employee("John", "JD001"),
            Employee("Alice", "AS002"),
            Employee("Bob", "BJ003"),
            // Add more employees as needed
        )
}
