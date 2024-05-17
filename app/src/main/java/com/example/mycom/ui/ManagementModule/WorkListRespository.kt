package com.example.mycom.ui.ManagementModule

import com.example.managementsystem.Data.Work
import kotlinx.coroutines.flow.Flow

interface WorkListRespository {
    fun getWorkListStream(): Flow<List<Work>>

}