package com.todoapp.todoapp.services;

import com.todoapp.todoapp.Models.Task;
import com.todoapp.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private final TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }
    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
