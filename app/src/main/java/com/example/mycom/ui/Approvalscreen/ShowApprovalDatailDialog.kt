import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.Database.Approval

@Composable
fun DetailDialog(
    approval: Approval,
    onDismissRequest: () -> Unit,
    onApprove: () -> Unit,
    onReject: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = "审批详情") },
        text = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "员工ID: ${approval.staffid}")
                Text(text = "理由: ${approval.appreason}")
                Text(text = "状态: ${approval.stateinfo}")
                Text(text = "日期: ${approval.appdate}")
                Text(text = "时间: ${approval.apptime}")
                Text(text = "请假/迟到: ${approval.leaveandlate}")
            }
        },
        confirmButton = {
            Button(onClick = onApprove) {
                Text("批准")
            }
        },
        dismissButton = {
            Button(onClick = onReject) {
                Text("驳回")
            }
        }
    )
}
