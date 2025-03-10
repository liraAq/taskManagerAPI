package com.example.taskManagerAPI.controller;

import com.example.taskManagerAPI.dto.TaskDto;
import com.example.taskManagerAPI.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }



    @PostMapping("/add")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto) {
        TaskDto task = taskService.addTask(taskDto);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

}
