package com.example.taskManagerAPI.repository;

import com.example.taskManagerAPI.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
//    Set<Task> findAllTask();
}
