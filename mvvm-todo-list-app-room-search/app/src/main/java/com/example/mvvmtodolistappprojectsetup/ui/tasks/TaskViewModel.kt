package com.example.mvvmtodolistappprojectsetup.ui.tasks

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mvvmtodolistappprojectsetup.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskDao: TaskDao
) : ViewModel(), LifecycleObserver{
    val searchQuery = MutableStateFlow("")

    private val tasksFlow = searchQuery.flatMapLatest {
        taskDao.getTasks(it)
    }

//    val tasks = taskDao.getTasks("bia").asLiveData()
    val tasks = tasksFlow.asLiveData()

}