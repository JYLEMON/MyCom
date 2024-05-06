// EmployeeData.kt
package com.example.mycom.data

class EmployeeData {
    data class Employee(
        val name: String,
        val id: String
    )

    val allEmployees: Set<Employee> =
        setOf(
            Employee("John", "E001"),
            Employee("Alice", "E002"),
            Employee("Bob", "E003"),
            Employee("Ryan", "E004"),
            Employee("Eason", "E005"),
            Employee("Brandon", "E006"),
            Employee("Jonathan", "E007"),
            Employee("Elise", "E008"),
            Employee("Alex", "E009"),
            Employee("Brayan", "E010"),
            Employee("Steven", "E011"),
            // Add more employees as needed
        )
}
