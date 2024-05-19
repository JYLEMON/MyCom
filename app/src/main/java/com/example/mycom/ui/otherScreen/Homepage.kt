package com.example.myapplication.ui.theme.otherScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycom.ui.theme.MyComTheme
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlinx.coroutines.delay

@Composable
fun Homepage(
    onClickButton1: () -> Unit = {},
    onClickButton2: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Box(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()) {
        Column(modifier = Modifier
            .padding(25.dp)
            .fillMaxSize()) {
            Text(text = "Liang You Xian", fontSize = 35.sp)
            Text(text = "E001", fontSize = 25.sp)
            Spacer(modifier = Modifier.height(20.dp))

            Divider(Modifier.padding(bottom = 32.dp))

            // Adding RealTimeClock and RealDate
            Column(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            RealDate()
                            Spacer(modifier = Modifier.width(8.dp))
                            RealTimeClock()
                        }
                    }
                }
            }



            Spacer(modifier = Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = onClickButton1,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .height(120.dp)
                        .aspectRatio(1f)
                ) {
                    Text(text = "Punch In/Punch Out")
                }
                Button(
                    onClick = onClickButton2,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .height(120.dp)
                        .aspectRatio(1f)
                ) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Profile")
                }
            }
        }
    }
}

// RealTimeClock composable
@Composable
fun RealTimeClock() {
    var currentTime by remember { mutableStateOf(LocalTime.now()) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000) // Update every second
            currentTime = LocalTime.now()
        }
    }
    val formatter = DateTimeFormatter.ofPattern("hh:mm a")
    val formattedTime = currentTime.format(formatter)
    Text(
        text = formattedTime,
        fontSize = 25.sp,
        style = TextStyle(color = Color.DarkGray),
        modifier = Modifier.padding(8.dp)
    )
}

// RealDate composable
@Composable
fun RealDate() {
    var currentDate by remember { mutableStateOf(Date()) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000) // Update every second
            currentDate = Date()
        }
    }
    val pattern = "dd/MM/yyyy"
    val dateFormat = SimpleDateFormat(pattern)
    val formattedDate = dateFormat.format(currentDate)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = formattedDate,
            fontSize = 25.sp,
            style = TextStyle(color = Color.DarkGray),
            modifier = Modifier.padding(8.dp)
        )
        Icon(imageVector = Icons.Default.DateRange, contentDescription = "Date")
    }
}

@Preview
@Composable
fun HomePreview() {
    MyComTheme {
        Homepage()
    }
}
