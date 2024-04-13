package com.joaoandrade.fwproject.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joaoandrade.fwproject.domain.model.Task
import com.joaoandrade.fwproject.presentation.ui.viewmodel.TaskViewModel

@Composable
fun TaskInput(taskViewModel: TaskViewModel) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.padding(14.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(6.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Button(
            onClick = {
                if (title.isNotBlank() && description.isNotBlank()) {
                    taskViewModel.insert(Task(title = title, description = description))
                    title = ""
                    description = ""
                }
            }
        ) {
            Text("Add Task")
        }
    }
}
