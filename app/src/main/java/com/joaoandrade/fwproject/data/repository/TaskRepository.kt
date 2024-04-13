package com.joaoandrade.fwproject.data.repository

import androidx.lifecycle.LiveData
import com.joaoandrade.fwproject.data.dao.TaskDao
import com.joaoandrade.fwproject.domain.model.Task

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) {
        taskDao.insertTask(task)
    }

    suspend fun delete(task: Task) {
        taskDao.deleteTask(task)
    }

    suspend fun update(task: Task) {
        taskDao.insertTask(task)
    }
}
