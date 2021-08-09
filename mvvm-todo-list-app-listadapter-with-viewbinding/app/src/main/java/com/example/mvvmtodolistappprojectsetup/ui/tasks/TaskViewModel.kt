package com.example.mvvmtodolistappprojectsetup.ui.tasks

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mvvmtodolistappprojectsetup.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskDao: TaskDao
) : ViewModel(), LifecycleObserver{

    val tasks = taskDao.getTasks().asLiveData()

}