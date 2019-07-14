package com.beansbeans.moneyapp.Services;

import com.beansbeans.moneyapp.Model.User;
import com.beansbeans.moneyapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
