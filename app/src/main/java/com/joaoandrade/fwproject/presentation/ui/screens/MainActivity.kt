package com.joaoandrade.fwproject.presentation.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.joaoandrade.fwproject.data.database.TaskDatabase
import com.joaoandrade.fwproject.data.repository.TaskRepository
import com.joaoandrade.fwproject.presentation.ui.components.TaskInput
import com.joaoandrade.fwproject.presentation.ui.components.TaskList
import com.joaoandrade.fwproject.presentation.ui.viewmodel.TaskViewModel
import com.joaoandrade.fwproject.presentation.ui.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskListApp()
        }

        val database = TaskDatabase.getDatabase(this)
        val taskDao = database.taskDao()
        val repository = TaskRepository(taskDao)
        taskViewModel =
            ViewModelProvider(this, TaskViewModelFactory(repository)).get(TaskViewModel::class.java)
    }

    @Composable
    fun TaskListApp() {
        val tasks by taskViewModel.allTasks.observeAsState(emptyList())
        Column {
            TaskInput(taskViewModel)
            TaskList(tasks, taskViewModel)
        }
    }
}
