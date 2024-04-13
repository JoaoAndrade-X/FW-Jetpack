package com.joaoandrade.fwproject.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaoandrade.fwproject.data.repository.TaskRepository
import com.joaoandrade.fwproject.domain.model.Task
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
    val allTasks: LiveData<List<Task>> = repository.allTasks

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }

    fun delete(task: Task) = viewModelScope.launch {
        repository.delete(task)
    }

    fun updateTaskCompletion(task: Task, completed: Boolean) = viewModelScope.launch {
        val updatedTask = task.copy(completed = completed)
        repository.update(updatedTask)
    }

}
