package com.todoapp.todoapp.Controller;

import com.todoapp.todoapp.Models.Task;
import com.todoapp.todoapp.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks= taskServices.getAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(@RequestParam String title){
        taskServices.createTask(title);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskServices.toggleTask(id); // Implement this method in service
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskServices.deleteTask(id); // Implement this method in service
        return "redirect:/tasks";
    }

}