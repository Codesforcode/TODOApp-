package com.todoapp.todoapp.repository;

import com.todoapp.todoapp.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
