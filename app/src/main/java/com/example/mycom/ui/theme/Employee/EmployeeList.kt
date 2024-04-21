package com.example.mycom.ui.theme.Employee

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EmployeeListScreen(
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
    ){

       Row {
           Box(modifier = modifier){
               Text(text = "Test")
           }
       }
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true
)
@Composable
fun EmployeeListPreview() {
    EmployeeListScreen()
}