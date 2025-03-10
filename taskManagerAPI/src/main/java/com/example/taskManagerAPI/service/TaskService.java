package com.example.taskManagerAPI.service;

import com.example.taskManagerAPI.dto.TaskDto;

import java.util.Set;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);
    TaskDto getTaskById(Long taskId);
    Set<TaskDto> getAllTasks();
    TaskDto updateTask(Long id,TaskDto taskDto);
    void deleteTask(Long taskId);
}
