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
fun LoginScreen (
    onFirstButtonClicked : () -> Unit = {} ,
    onSecondButtonClicked : () -> Unit = {},
    modifier: Modifier = Modifier
    ){
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

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
                    Text(text = "USER LOGIN", textAlign = TextAlign.Center, fontSize = 30.sp, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(20.dp))
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = id,
                    label = { Text(text = "User ID")},
                    onValueChange = { id = it },
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    label = { Text(text = "Email")},
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    label = { Text(text = "Password")},
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(30.dp))
                    Button(onClick =  onFirstButtonClicked , colors = ButtonDefaults.buttonColors(Color(0xFFBB86FC)),modifier = Modifier.fillMaxWidth()) {
                        Text(text = "LOGIN")

                    }
                Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = onSecondButtonClicked,colors = ButtonDefaults.buttonColors(Color(0xFFBB86FC)), modifier = Modifier.fillMaxWidth()) {
                        Text(text = "SIGN UP")


                    }
                Spacer(modifier = Modifier.height(10.dp))


            }

        }


    }
}

@Preview
@Composable
fun LoginPreview() {
    MyComTheme {
        LoginScreen(modifier = Modifier.fillMaxSize())
    }
}