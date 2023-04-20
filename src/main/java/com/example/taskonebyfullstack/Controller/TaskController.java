package com.example.taskonebyfullstack.Controller;

import com.example.taskonebyfullstack.Entity.EntityModelInterfaces.TaskRepository;
import com.example.taskonebyfullstack.Entity.EntityModelInterfaces.UserRepository;
import com.example.taskonebyfullstack.Entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public TaskController(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/tasks")
    public String showTaskDetails(Model model) {
        long byUsername = userRepository.findByUsername(LoginController.Username);
        List<Task> by = taskRepository.getByReceiverUserId(byUsername);
        model.addAttribute("tasks", by);
        return "TaskHtml";
    }

    @GetMapping("/tasks/Completed")
    public String makeComplete(@RequestParam("userId") long userid) throws SQLException {
        long byUsername = userRepository.findByUsername(LoginController.Username);
        long i = userRepository.GetTheNumberOfTaskCompletedById(byUsername);
        i++;
        updateTasksCompleted(i, byUsername);
        taskRepository.UpdateTheStatusByUserIdAndTaskId(byUsername, userid);
        return "redirect:/dashboard";
    }

    public void updateTasksCompleted(long tasksCompleted, long userId) throws SQLException {
        String query = "UPDATE users SET tasks_completed = ? WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/First_Full_Stack", "root", "root");
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setLong(1, tasksCompleted);
            ps.setLong(2, userId);
            ps.executeUpdate();
        }
    }

}
