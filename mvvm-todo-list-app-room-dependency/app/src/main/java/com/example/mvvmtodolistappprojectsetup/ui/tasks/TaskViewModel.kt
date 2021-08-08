package com.example.mvvmtodolistappprojectsetup.ui.tasks

import androidx.lifecycle.ViewModel
import com.example.mvvmtodolistappprojectsetup.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskDao: TaskDao
) : ViewModel(){
}