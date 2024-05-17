package com.example.myapplication.ui.theme.otherScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycom.R
import com.example.mycom.ui.theme.MyComTheme

@Composable
fun RegisterScreen(
    onClickButton1 : () -> Unit ={},
    onClickButton2 : () -> Unit ={},
    modifier : Modifier = Modifier){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)){
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, end = 25.dp, start = 25.dp, bottom = 50.dp)
            .background(
                Color.LightGray
            )) {
            Column (modifier = Modifier.padding(top = 50.dp, end = 25.dp, start = 25.dp, bottom = 50.dp)){
                Image(
                    painter = painterResource(R.drawable.images),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(top = 25.dp)
                )
                Text(text = "STAFF REGISTER", textAlign = TextAlign.Center, fontSize = 30.sp, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = name,
                    label = { Text(text = "User Name") },
                    onValueChange = { name = it },
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    label = { Text(text = "Email") },
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    label = { Text(text = "Password") },
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    label = { Text(text = "Confirm Password") },
                    value = confirmpassword,
                    onValueChange = { confirmpassword = it },
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick =  onClickButton1 , colors = ButtonDefaults.buttonColors(Color(0xFFBB86FC)),modifier = Modifier.fillMaxWidth()) {

                        Text(text = "REGISTER")
                    }
                Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = onClickButton2,colors = ButtonDefaults.buttonColors(Color(0xFFBB86FC)), modifier = Modifier.fillMaxWidth()) {
                        Text(text = "BACK TO LOGIN")


                    }

            }

        }


    }
}

@Preview
@Composable
fun RegisterPreview() {
    MyComTheme {
        RegisterScreen()
    }
}