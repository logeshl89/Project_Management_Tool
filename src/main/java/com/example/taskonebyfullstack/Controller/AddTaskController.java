package com.example.taskonebyfullstack.Controller;

import com.example.taskonebyfullstack.Entity.Task;
import com.example.taskonebyfullstack.Service.AddTaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/AddTask")
public class AddTaskController {
    private final AddTaskService addTaskService;

    public AddTaskController(AddTaskService addTaskService) {
        this.addTaskService = addTaskService;
    }

    private long id;

    @GetMapping
    public String AddTask(@RequestParam("userId") long id) {
        this.id = id;
        return "AddTask";

    }

    @PostMapping
    public String addTask(@RequestParam("title") String title, @RequestParam("taskdesception") String taskDescription) {
        Task task=Task.builder().taskDescription(taskDescription).receiverUserId(id)
                .tasktitle(title).status(false).build();
        addTaskService.AddTheTask(task);
        return "redirect:/dashboard";
    }


}
