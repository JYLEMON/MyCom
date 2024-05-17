package com.example.myapplication.ui.theme.otherScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import com.example.mycom.ui.theme.MyComTheme


@Composable
fun ProfileScreen(name:String,
                  email: String,
                  salary: String,
                  work: String,
                  notification: String,
                  textbotton1: String,
                  onClickButton1 : () -> Unit ={},
                  onClickButton2 : () -> Unit ={},
                  onClickButton3 : () -> Unit ={},
                  onClickButton4 : () -> Unit ={},
                  onEditClick : () -> Unit ={},
                  modifier: Modifier = Modifier){
    var name : String = "liangyouxian"
    var email : String = "liangyouxian1@gmail.com"
    var salary : String = "2000.50"
    var work : String = "10"
    var notivication : String = "Work/Staff Approval:"
    var textbotton1 : String = "Approval Leave & Late"
    Box (modifier = Modifier
        .background(color = Color.Gray)
        .fillMaxSize()){
    Column (modifier = Modifier
        .padding(top = 25.dp, end = 25.dp, start = 25.dp, bottom = 25.dp)
        .fillMaxSize()
        .background(Color.LightGray)) {
        Column (modifier = Modifier
            .padding(top = 25.dp, end = 25.dp, start = 25.dp, bottom = 25.dp)
        ){
        Card() {
            Column {
                Text(text = "$name", fontSize = 50.sp, modifier = Modifier.fillMaxWidth())
                Text(text = "$email", modifier = Modifier.fillMaxWidth())
            }

            Text(text = "Your Salary:", fontSize = 20.sp)
            Card(
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    //.background(color = Color.White)
                    .fillMaxWidth()
            ) {
                Row {
                    Text(
                        text = "RM",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "$salary",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
            Text(text = "$notivication", fontSize = 20.sp)
            Card(
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClickButton1() }
            ) {
                Row {

                    Text(
                        text = "$work",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Text(text = "$notivication", fontSize = 20.sp)
            Card(
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClickButton1() }
            ) {
                Row {

                    Text(
                        text = "$work",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

        }
            Button(onClick = onClickButton2, Modifier.fillMaxWidth()) { Text(text = "$textbotton1") }
            Button(onClick = onClickButton3, Modifier.fillMaxWidth()) { Text(text = "Logout") }

    }

    }
        FloatingActionButton(
            onClick = onEditClick,
            shape = CircleShape,
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(16.dp)


        ) {
            Icon(
                imageVector = Icons.Filled.Edit, // Use the Edit icon
                contentDescription = "Edit"
            )
        }
}
}

@Preview
@Composable
fun profilePreview() {
    MyComTheme {
        ProfileScreen(name = "shit", email ="liangyouxian1@gmail.com" , salary = "2000.50", work = "10", notification ="Work/Staff Approval:" , textbotton1 = "Approval Leave & Late")
    }
}