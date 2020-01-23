package com.game.bullscows.service;

import com.game.bullscows.model.User;
import com.game.bullscows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.save(user);
    }
    public void editUser(User user){
        userRepository.save(user);
    }

}
