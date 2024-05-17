package com.example.managementsystem.ManagementModule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.mycom.ui.status.TimePickerEvent
import com.example.mycom.ui.status.TimeRangeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowRulesScreen(
    state: TimeRangeState,
    onEvent: (TimePickerEvent) -> Unit
) {
    /*var startHourString by remember {
        mutableStateOf(state.timeNow.last().startHour.toString().padStart(2,'0'))
    }
    var endHourString by remember {
        mutableStateOf(state.timeNow.last().endHour.toString().padStart(2,'0'))
    }
    var startMinuteString by remember {
        mutableStateOf(state.timeNow.last().startMinute.toString().padStart(2,'0'))
    }
    var endMinuteString by remember {
        mutableStateOf(state.timeNow.last().endMinute.toString().padStart(2,'0'))
    }
    var startTime by remember {
        mutableStateOf("$startHourString:$startMinuteString${state.timeNow.last().startAmPm}")
    }
    var endTime by remember {
        mutableStateOf("$endHourString:$endMinuteString${state.timeNow.last().endAmPm}")
    }*/

    var startTime = "1:00am"
    var endTime = "10:00pm"

    var progress by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Text("Current time range: ")
        }
        Row {
            Text("$startTime-$endTime")
        }
        Row {
            Button(onClick = {
                onEvent(TimePickerEvent.ShowStartTimeDialog)
            }
            ) {
                Text("Set Start Time")
            }
        }
        Row {
            Button(onClick = {
                onEvent(TimePickerEvent.ShowEndTimeDialog)
            }) {
                Text("Set End Time")
            }
        }
    }

    if (state.isSettingStartTime) {
        EditTime(state = state, onEvent = onEvent)
    }
    if(state.isSettingEndTime) {
        EditTime(state = state, onEvent = onEvent)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTime(
    state: TimeRangeState,
    onEvent: (TimePickerEvent) -> Unit
) {
    val timePickerState = rememberTimePickerState()
    TimePickerDialog(
        onDismissRequest = {
            if (state.isSettingStartTime){onEvent(TimePickerEvent.HideStartTimeDialog)}
            if (state.isSettingEndTime){onEvent(TimePickerEvent.HideEndTimeDialog)}
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (state.isSettingStartTime) {
                        onEvent(TimePickerEvent.SetStartHour(timePickerState.hour))
                        onEvent(TimePickerEvent.SetStartMinute(timePickerState.minute))
                        when {
                            state.startHour == 0 -> {
                                onEvent(TimePickerEvent.SetStartHour(12))
                                onEvent(TimePickerEvent.SetStartAmPm("AM"))
                        }
                            state.startHour == 12 -> onEvent(TimePickerEvent.SetStartAmPm("PM"))
                            state.startHour > 12 -> {
                                onEvent(TimePickerEvent.SetStartHour(state.startHour - 12))
                                onEvent(TimePickerEvent.SetStartAmPm("PM"))
                            }
                            else -> onEvent(TimePickerEvent.SetStartAmPm("AM"))
                        }
                        onEvent(TimePickerEvent.SaveStartTime)
                        onEvent(TimePickerEvent.HideStartTimeDialog)
                    }

                    if (state.isSettingEndTime) {
                        onEvent(TimePickerEvent.SetEndHour(timePickerState.hour))
                        onEvent(TimePickerEvent.SetEndMinute(timePickerState.minute))
                        when {
                            state.startHour == 0 -> {
                                onEvent(TimePickerEvent.SetEndHour(12))
                                onEvent(TimePickerEvent.SetEndAmPm("AM"))
                            }
                            state.startHour == 12 -> onEvent(TimePickerEvent.SetEndAmPm("PM"))
                            state.startHour > 12 -> {
                                onEvent(TimePickerEvent.SetEndHour(state.endHour - 12))
                                onEvent(TimePickerEvent.SetEndAmPm("PM"))
                            }
                            else -> onEvent(TimePickerEvent.SetEndAmPm("AM"))
                        }
                        onEvent(TimePickerEvent.HideEndTimeDialog)
                    }
                }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    if (state.isSettingStartTime){onEvent(TimePickerEvent.HideStartTimeDialog)}
                    if (state.isSettingEndTime){onEvent(TimePickerEvent.HideEndTimeDialog)}
                }
            ) { Text("Cancel") }
        }
    )
    {
        TimePicker(
            state = timePickerState
        )
    }
}

@Composable
fun TimePickerDialog(
    title: String = "Select Time",
    onDismissRequest: () -> Unit,
    confirmButton: @Composable (() -> Unit),
    dismissButton: @Composable (() -> Unit)? = null,
    containerColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = containerColor
                ),
            color = containerColor
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.labelMedium
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    dismissButton?.invoke()
                    confirmButton()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RulesModifyPreview() {
}