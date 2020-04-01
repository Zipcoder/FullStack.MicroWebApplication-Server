package com.videolibrary.zipcode.fullstackapp.services;

import com.videolibrary.zipcode.fullstackapp.models.User;
import com.videolibrary.zipcode.fullstackapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User u) {
        return userRepository.save(u);
    }

    /*public Optional<User> show(Long id) {
        return userRepository.findById(id);
    }*/

    public User show(Long id) {
        return userRepository.getUserById(id);
    }

    public Iterable<User> index() {
        return userRepository.findAll();
    }

    public boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public void update(Long id, User newUser) {
        User user = userRepository.getUserById(id);
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
    }

}
