package com.example.mycom.data

object Manager {
    data class Manager (
        val name: String,
        val email: String,
        val password: String,
        val salary: String,
        val id: String
    )

    val manager = Manager(
        name = "Manager 1",
        id = "M001",
        email = "manager@gmail.com",
        password = "000000",
        salary = "3000"
    )
}