package com.phoenixvideos.phoenixapp.service;

import com.phoenixvideos.phoenixapp.model.User;
import com.phoenixvideos.phoenixapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userRepository.save(user);
    }






    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
