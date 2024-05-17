package com.example.managementsystem.ManagementModule

import com.example.managementsystem.Data.Work
import com.example.mycom.ui.ManagementModule.WorkSortType

sealed interface WorkEvent {
    object SaveWork:WorkEvent
    data class SetTitle(val title: String): WorkEvent
    data class SetDescription(val description: String): WorkEvent
    data class SetEmail(val email:String): WorkEvent
    object ShowDialog: WorkEvent
    object HideDialog: WorkEvent
    data class SortWork(val sortType: WorkSortType): WorkEvent
    data class DeleteWork(val work: Work): WorkEvent
    data class UpdateWork(val work: Work): WorkEvent
}