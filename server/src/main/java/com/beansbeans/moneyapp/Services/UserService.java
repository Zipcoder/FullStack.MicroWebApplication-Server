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

    public User show(Long id){
        return userRepository.findById(id).get();
    }

    public User updateUser(Long id, User newUserData){
        User originalUser = userRepository.findById(id).get();
        originalUser.setFirstName(newUserData.getFirstName());
        originalUser.setLastName(newUserData.getLastName());
        return userRepository.save(originalUser);
    }

    public Boolean deleteUser(Long id){
       userRepository.deleteById(id);
       return true;
    }


}
