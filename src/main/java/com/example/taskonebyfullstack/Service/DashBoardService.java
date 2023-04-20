package com.example.taskonebyfullstack.Service;

import com.example.taskonebyfullstack.Entity.EntityModelInterfaces.UserRepository;
import com.example.taskonebyfullstack.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashBoardService {
    private final UserRepository userRepository;

    public DashBoardService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllTheUser()
    {
        return  userRepository.findAll();
    }
}
