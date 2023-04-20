package com.example.taskonebyfullstack.Controller;


import com.example.taskonebyfullstack.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/")
    public String Default()
    {
        return "Login";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "Login";
    }
    static String Username;
    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if(loginService.UserAuthantication(username,password))
        {
            Username=username;
            return "redirect:/dashboard";
        }
        else {
            model.addAttribute("error","Oh! Bad credentials Can you please register");
        }
        return null;

    }
    @GetMapping("/logout")
    public String BackToLogin()
    {
        return "redirect:/login";
    }

}

