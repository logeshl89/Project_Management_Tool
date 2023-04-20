package com.example.taskonebyfullstack.Service;

import com.example.taskonebyfullstack.Entity.EntityModelInterfaces.TaskRepository;
import com.example.taskonebyfullstack.Entity.Task;
import com.example.taskonebyfullstack.Service.Interfaces.AddTaskInterface;
import org.springframework.stereotype.Service;

@Service
public class AddTaskService  implements AddTaskInterface {
    private final TaskRepository task;

    public AddTaskService(TaskRepository task) {
        this.task = task;
    }

    @Override
    public void AddTheTask(Task task) {
        this.task.save(task);
    }
}
