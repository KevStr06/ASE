package org.application.services;

import org.domain.entities.User;
import org.domain.repositories.UserRepository;
import org.domain.valueObjects.UserId;

import java.util.ArrayList;
import java.util.List;

public class UserManagementService {
    private final UserRepository userRepository;

    public UserManagementService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserId createUser(String name, String surname) {
        User user = new User(name, surname);
        userRepository.add(user);
        return user.getId();
    }

    public void loadUsers() {
        userRepository.load();
    }

    public void clearAllUsers(){
        for (User user: userRepository.listAll()) {
            userRepository.remove(user);
        }
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userRepository.listAll());
    }

}
