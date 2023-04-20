package com.example.taskonebyfullstack.Controller;

import com.example.taskonebyfullstack.Entity.User;
import com.example.taskonebyfullstack.Service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String showRegisterForm() {
        return "register";
    }
    @PostMapping
    public String PostRegister(User user, Model model)
    {
        System.out.println(user);
        boolean b = registrationService.RegisterDataToTheDataBaase(user);
        if(b)
        {
            model.addAttribute("error", "You have successfully registered");
        }
        else {
            model.addAttribute("error", "Something went wrong");
        }
        return "Login";
    }

}
