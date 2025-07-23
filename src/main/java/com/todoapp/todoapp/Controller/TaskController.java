package com.todoapp.todoapp.Controller;

import com.todoapp.todoapp.Models.Task;
import com.todoapp.todoapp.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class TaskController {

    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }
    @GetMapping("/")
    public String getTask(Model model){
        List<Task> tasks= taskServices.getAllTask();
        model.addAttribute("tasks",tasks);
        return "task";}
}