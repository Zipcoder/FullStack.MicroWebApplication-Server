package com.phoenixvideos.phoenixapp.service;

import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.repository.UserRepository;
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

    public User create(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> index() {
        return userRepository.findAll();
    }

    public User show(Long id) {
        return userRepository.findById(id).get();
    }

    public User update(Long id, User newUser) {
        User user = userRepository.findById(id).get();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setUserName(newUser.getUserName());
        return userRepository.save(user);
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
    public Optional<User> findById(Long id){
        Optional<User> user=  userRepository.findById(id);
        return user;
    }
}
