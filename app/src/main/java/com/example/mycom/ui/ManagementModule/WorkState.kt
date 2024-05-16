package com.example.managementsystem.ManagementModule

import com.example.managementsystem.Data.Work
import com.example.mycom.ui.ManagementModule.WorkSortType

data class WorkState(
    val workList: List<Work> = emptyList(),
    val workTitle: String = "",
    val workDescription: String = "",
    val handlerEmail: String = "",
    val workID: String = "",
    val count: Int = 0,
    val isAddingWork: Boolean = false,
    val sortType: WorkSortType = WorkSortType.WORK_TITLE
)
