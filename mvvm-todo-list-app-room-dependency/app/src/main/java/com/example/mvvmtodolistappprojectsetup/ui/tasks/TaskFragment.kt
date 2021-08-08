package com.example.mvvmtodolistappprojectsetup.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvmtodolistappprojectsetup.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskFragment : Fragment(R.layout.fragment_tasks) {

    private val viewModel: TaskViewModel by viewModels()
}