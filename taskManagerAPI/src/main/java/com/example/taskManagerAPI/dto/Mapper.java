package com.example.taskManagerAPI.dto;


import com.example.taskManagerAPI.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper modelMapper;

    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public TaskDto convertTaskToDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }
    public Task convertDtoToTask(TaskDto dto) {
        return modelMapper.map(dto, Task.class);
    }
}
