package com.example.taskonebyfullstack.Service;

import com.example.taskonebyfullstack.Entity.EntityModelInterfaces.UserRepository;
import com.example.taskonebyfullstack.Entity.User;
import com.example.taskonebyfullstack.Service.Interfaces.RegistrationServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService implements RegistrationServiceInterface {
    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean RegisterDataToTheDataBaase(User user) {
        List<User> users = userRepository.FindEmailIdExistOrNot(user.getEmail());
        List<User> users1 = userRepository.PhoneNumberExistOrNot(user.getPhoneNumber());
        if (users.isEmpty() && users1.isEmpty()) {
            userRepository.save(user);
            return Boolean.FALSE;
        } else {

            System.out.println("The email id is already registered");
            return Boolean.TRUE;
        }
    }
}
