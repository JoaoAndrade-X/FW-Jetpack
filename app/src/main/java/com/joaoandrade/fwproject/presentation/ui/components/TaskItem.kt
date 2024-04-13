package com.joaoandrade.fwproject.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.joaoandrade.fwproject.domain.model.Task
import com.joaoandrade.fwproject.presentation.ui.viewmodel.TaskViewModel

@Composable
fun TaskItem(task: Task, taskViewModel: TaskViewModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            Text(
                text = task.title,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = task.description,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Checkbox(
            checked = task.completed,
            onCheckedChange = { isChecked ->
                taskViewModel.updateTaskCompletion(task, isChecked)
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { taskViewModel.delete(task) }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete Task")
        }
    }
}
