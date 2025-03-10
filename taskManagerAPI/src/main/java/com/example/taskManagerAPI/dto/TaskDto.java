package com.example.taskManagerAPI.dto;


import com.example.taskManagerAPI.entity.Priority;
import com.example.taskManagerAPI.entity.Status;
import com.example.taskManagerAPI.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long taskId;
    private String title;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    private User user;
}
