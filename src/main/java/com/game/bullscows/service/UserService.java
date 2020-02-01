package com.game.bullscows.service;

import com.game.bullscows.model.Rating;
import com.game.bullscows.model.Role;
import com.game.bullscows.model.User;
import com.game.bullscows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private RatingService ratingService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RatingService ratingService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.ratingService = ratingService;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Rating rating = new Rating();
        userRepository.save(user);
        User userDb = userRepository.findByUsername(user.getUsername());
        rating.setUser(userDb);
        ratingService.addRating(rating);

        return true;
    }

    public void editUser(User user) {
        userRepository.save(user);
    }

    public User findByUsername(User user) {
        return userRepository.findByUsername(user.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
