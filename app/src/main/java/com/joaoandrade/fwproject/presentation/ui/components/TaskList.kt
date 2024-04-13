package com.joaoandrade.fwproject.presentation.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.joaoandrade.fwproject.domain.model.Task
import com.joaoandrade.fwproject.presentation.ui.viewmodel.TaskViewModel

@Composable
fun TaskList(tasks: List<Task>, taskViewModel: TaskViewModel) {
    LazyColumn {
        items(tasks) { task ->
            TaskItem(task, taskViewModel)
        }
    }
}
