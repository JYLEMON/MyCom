package com.example.managementsystem.ManagementModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.managementsystem.Data.Work
import com.example.mycom.ui.ManagementModule.WorkSortType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WorkViewModel(
    private val dao: WorkDao
): ViewModel() {

    private val _sortType = MutableStateFlow(WorkSortType.WORK_TITLE)
    private val _workList = _sortType
        .flatMapLatest { sortType ->
            when(sortType) {
                WorkSortType.WORK_TITLE -> dao.getWorkListOrderByTitle()
            }
        }
    private val _state = MutableStateFlow(WorkState())
    val state = combine(_state, _sortType, _workList) { state, sortType, workList ->
        state.copy(
            workList = workList,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), WorkState())

    fun onEvent(event: WorkEvent) {
        when(event) {
            is WorkEvent.DeleteWork -> {
                viewModelScope.launch {
                    dao.deleteWork(event.work)
                }
            }
            WorkEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingWork = false
                ) }
            }

            WorkEvent.SaveWork -> {
                val workTitle = state.value.workTitle
                val workDescription = state.value.workDescription
                val handlerEmail = state.value.handlerEmail

                if(workTitle.isBlank() || workDescription.isBlank()) {
                    return
                }

                val work = Work(
                    workTitle = workTitle,
                    workDescription = workDescription,
                    contactEmail = handlerEmail
                )
                viewModelScope.launch {
                    dao.upsertWork(work)
                }
                _state.update { it.copy(
                    isAddingWork = false,
                    workTitle = "",
                    workDescription = "",
                    handlerEmail = ""
                ) }
            }

            is WorkEvent.SetTitle -> {
                _state.update { it.copy(
                    workTitle = event.title
                ) }
            }
            is WorkEvent.SetDescription -> {
                _state.update { it.copy(
                    workDescription = event.description
                ) }
            }
            WorkEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingWork = true
                ) }
            }
            is WorkEvent.SortWork -> {
                _sortType.value = event.sortType
            }
        }
    }
}