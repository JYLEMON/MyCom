package com.example.myapplication.DatabaseApproval

import com.example.myapplication.Database.Approval
import com.example.mycom.data.Employee


data class ApprovalState(
    val approval: List<Approval> = emptyList(),
    val selectedApproval: Approval? = null,
    val staffid : String ="",
    val name : String ="",
    val apptime : String ="",
    val appreason : String ="",
    val appdate : String ="",
    val leaveandlate : String ="",
    val stateinfo : String ="",
    val deleteApproval: Approval? = null,
    val isAddingApproval: Boolean =false,
    val approvalSortType: ApprovalSortType = ApprovalSortType.Staff_Approval

)
