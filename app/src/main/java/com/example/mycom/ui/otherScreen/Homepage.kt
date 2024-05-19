package com.example.myapplication.ui.theme.otherScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycom.R
import com.example.mycom.ui.theme.MyComTheme
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date
import androidx.compose.foundation.layout.Column as Column
import kotlinx.coroutines.delay as delay

@Composable
fun Homepage (onClickButton1 : () -> Unit ={},
              onClickButton2 : () -> Unit ={},
              modifier: Modifier = Modifier){
    Box(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()) {
        Box(modifier = Modifier
            .padding(start = 25.dp, end = 25.dp, top = 30.dp, bottom = 30.dp)
            .fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "Home Page", fontSize = 20.sp)
                Text(text = "Liang You Xian", fontSize = 35.sp)
                Spacer(modifier = Modifier.height(300.dp))
                    Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize()) {
                        Text(text = "Next Trip", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        Box() {
                            Column(modifier = Modifier.background(Color.LightGray)) {
                                Row {
                                    Text(text = "Punch In", fontSize = 20.sp)
                                    Spacer(modifier = Modifier.width(160.dp))
                                    Text(text = "Punch Out", fontSize = 20.sp)
                                }
                                Row() {
                                    Text(
                                        text = "[jm]",
                                        fontSize = 35.sp,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.fillMaxWidth(0.25f)
                                    )
                                    Image(
                                        painter = painterResource(R.drawable.images),
                                        contentDescription = "Logo",
                                        modifier = Modifier
                                            .height(46.dp)
                                            .fillMaxSize(0.66f)

                                    )
                                    Text(
                                        text = "[jm]",
                                        fontSize = 35.sp,
                                        textAlign = TextAlign.End,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                                Box() {
                                    Row(
                                        modifier = Modifier
                                            .background(Color.DarkGray)
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = "8:30 am",
                                            fontSize = 18.sp,
                                            textAlign = TextAlign.Start,
                                            modifier = Modifier.fillMaxWidth(0.5f)
                                        )
                                        Text(
                                            text = "6:30 am",
                                            fontSize = 18.sp,
                                            textAlign = TextAlign.End,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                    }
                                }

                            }


                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row() {
                            Button(
                                onClick = onClickButton1,
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .height(120.dp)
                                    .aspectRatio(1f)
                            ) {
                                Text(text = "Punch In/Punch Out")
                            }
                            Button(
                                onClick = onClickButton2,
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier
                                    .padding(start = 90.dp)
                                    .height(120.dp)
                                    .aspectRatio(1f)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.images),
                                    contentDescription = "Profile"
                                )
                            }
                        }
                        BottomAppBar(
                            actions = {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        Icons.Outlined.DateRange,
                                        contentDescription = "Rule Set"
                                    )
                                }
                            }
                        )

                }
            }
        }
    }
}


//clock
@Composable
fun RealTimeClock(): String {
    var currentTime by remember { mutableStateOf(LocalTime.now()) }
    LaunchedEffect(Unit) {
            while (true) {
                delay(1000) // Update every second
                val currentTime = LocalTime.now()
            }

        }
    val formatter = DateTimeFormatter.ofPattern("hh:mm a")
    val formattedTime = currentTime.format(formatter)
    Text(
        text = "$formattedTime",
        fontSize = 50.sp,
        style = TextStyle(color = Color.DarkGray)
    )

    return formattedTime

    }
//date
@Composable
fun RealDate(): String {
    var currentDate by remember { mutableStateOf(Date()) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000) // Update every second
            val currentDate = Date()
        }

    }
    val patternt = "dd/MM/yyyy"
    val dateFormat = SimpleDateFormat(patternt)
    val formattedData = dateFormat.format(currentDate)
    Text(
        text = "$formattedData",
        fontSize = 50.sp,
        style = TextStyle(color = Color.DarkGray)
    )
    return formattedData



}





@Preview
@Composable
fun HomePreview() {
    MyComTheme {
            Homepage()
        }
    }
