package com.example.taskonebyfullstack.Service;

import com.example.taskonebyfullstack.Entity.EntityModelInterfaces.UserRepository;
import com.example.taskonebyfullstack.Entity.User;
import com.example.taskonebyfullstack.Service.Interfaces.LoginInterrface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements LoginInterrface {

    private final UserRepository  userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean UserAuthantication(String username, String password) {
        List<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(username, password);
        return !byUsernameAndPassword.isEmpty();
    }

    @Override
    public int GetTheIdByUserName(String Username) {
        userRepository.findByUsername(Username);
        return 0;
    }
}
