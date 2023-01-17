package com.example.moviebooking.service;

import com.example.moviebooking.entity.User;
import com.example.moviebooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(int id) {
        return Optional.ofNullable(userRepository.findById(id).orElse(null));
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean deleteUser(int id) {
        userRepository.deleteById(id);
        return true;
    }

    public Optional<User> updateUser(User user) {
        User userTemp = userRepository.findById(user.getId()).orElse(null);
        if(userTemp == null)
            return null;
        userTemp.setRoles(user.getRoles());
        return Optional.of(userRepository.save(user));
    }
}
