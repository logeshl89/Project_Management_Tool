package com.example.taskonebyfullstack.Controller;

import com.example.taskonebyfullstack.Entity.User;
import com.example.taskonebyfullstack.Service.DashBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class DashBoardController {
    private final DashBoardService dashBoardService;

    public DashBoardController(DashBoardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }

    @GetMapping("/dashboard")
    String GetAllTheEmployees(Model model)
    {

        System.out.println(LoginController.Username);
        List<User> allTheUser = dashBoardService.getAllTheUser()
                .stream().filter(userid-> !Objects.equals(userid.getUsername(), LoginController.Username)
        ).toList();
        model.addAttribute("users",allTheUser);
        return "dashboard";
    }
}
