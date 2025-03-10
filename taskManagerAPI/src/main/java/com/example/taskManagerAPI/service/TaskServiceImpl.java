package com.example.taskManagerAPI.service;

import com.example.taskManagerAPI.dto.Mapper;
import com.example.taskManagerAPI.dto.TaskDto;
import com.example.taskManagerAPI.entity.Task;
import com.example.taskManagerAPI.entity.User;
import com.example.taskManagerAPI.repository.TaskRepository;
import com.example.taskManagerAPI.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final Mapper mapper;
    private final UserRepository userRepository;


    public TaskServiceImpl(TaskRepository taskRepository, Mapper mapper, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }


    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Task task = mapper.convertDtoToTask(taskDto);

        if (taskDto.getUser().getId() != null) {
            User user = userRepository.findById(taskDto.getUser().getId())
                    .orElseThrow(() -> new NoSuchElementException("User not found"));
            task.setUser(user);
        } else {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        taskRepository.save(task);
        return mapper.convertTaskToDto(task);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(NoSuchElementException::new);
        return mapper.convertTaskToDto(task);
    }

    @Override
    public Set<TaskDto> getAllTasks() {
//        Set<TaskDto> taskDtoSet = new HashSet<>();
//        Set<Task> taskSet = taskRepository.findAllTask();
//        for (Task task : taskSet) {
//            taskDtoSet.add(mapper.convertTaskToDto(task));
//        }

        return Set.of();
    }

    @Override
    public TaskDto updateTask(Long taskId, TaskDto taskDto) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(NoSuchElementException::new);

        task.setTitle(taskDto.getTitle());
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());
        task.setDueDate(taskDto.getDueDate());

        taskRepository.save(task);
        return mapper.convertTaskToDto(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
