// EmployeeData.kt
package com.example.mycom.data

object EmployeeData {
    data class Employee(
        val name: String,
        val id: String,
        val email: String
    )

    val allEmployees: MutableSet<Employee> =
        mutableSetOf(
            Employee("John", "E001", "john@gmail.com"),
            Employee("Alice", "E002", "alice@gmail.com"),
            Employee("Bob", "E003", "bob@gmail.com"),
            Employee("Ryan", "E004", "ryan@gmail.com"),
            Employee("Eason", "E005", "eason@gmail.com"),
            Employee("Brandon", "E006", "brandon@gmail.com"),
            Employee("Jonathan", "E007", "jonathan@gmail.com"),
            Employee("Elise", "E008", "elise@gmail.com"),
            Employee("Alex", "E009", "alex@gmail.com"),
            Employee("Brayan", "E010", "brayan@gmail.com"),
            Employee("Steven", "E011", "steven@gmail.com"),
            // Add more employees as needed
        )

    fun addEmployee(name: String, id: String, email: String): Employee {
        val newEmployee = Employee(name, id, email)
        allEmployees.add(newEmployee)
        return newEmployee
    }
}
