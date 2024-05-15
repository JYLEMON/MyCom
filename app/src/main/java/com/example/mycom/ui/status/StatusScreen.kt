import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatusScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ID and Name card and Attendance Status card placed in the same line
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // ID and Name card
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp),
                shape = RoundedCornerShape(8.dp),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "ID: ",
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Name: ",
                    )
                }
            }

            // Attendance Status card
            Card(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp),
                shape = RoundedCornerShape(8.dp),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "WORKING STATUS",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Present, Late, Absent",
                    )
                }
            }
        }

        // Divider
        Divider(modifier = Modifier.padding(vertical = 8.dp))

        // Application Status card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "APPLICATION STATUS",
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Pending, Approved, Rejected",
                )
            }
        }

        // Divider
        Divider(modifier = Modifier.padding(vertical = 8.dp))

        // Work Accepted card
        Card(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Transparent,
                onClick = { "" }
                // Invoke the callback when card is clicked
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally, // Align text to the center horizontally
                    verticalArrangement = Arrangement.Center // Align text to the center vertically
                ) {
                    Text(
                        text = "WORKSPACE",
                        textAlign = TextAlign.Center // Center-align the text
                    )

                }
            }
        }

        Row {
            Text(text = "Recent Work Accepted")
        }

        LazyColumn {
            items(3) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Work Title $index",
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = "Description $index",
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun StatusScreenPreview(){
    StatusScreen()
}
