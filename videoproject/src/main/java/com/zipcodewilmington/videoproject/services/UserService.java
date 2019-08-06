package com.zipcodewilmington.videoproject.services;

import com.zipcodewilmington.videoproject.models.Comment;
import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.UserJson;
import com.zipcodewilmington.videoproject.repositories.CommentRepository;
import com.zipcodewilmington.videoproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

  private UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }


    public UserJson getUserJson(String userId){

        User user = repository.findById(userId).get();
        UserJson userJson = new UserJson();
        userJson.setUserId(user.getUserId());
        userJson.setFirstName(user.getFirstName());
        userJson.setLastName(user.getLastName());
        return userJson;
    }
    public void postUserJson(UserJson userJson) {
        User user = new User();
        user.setUserId(userJson.getUserId());
        user.setFirstName(userJson.getFirstName());
        user.setLastName(userJson.getLastName());
        user.setPassword(userJson.getPassword());
        repository.save(user);
    }

    public User login(String userId, String password){
    User user = repository.findById(userId).get();
      System.out.println(user);
    String userPassword = user.getPassword();
    if (userPassword.equals(password)){
      user.setLoggedIn(true);
      return user;
    }
      return null;
    //repository.save(user);
    }

    public Iterable<User> index(){
    return repository.findAll();
  }

    public Optional<User> getUserById(String id){
    return repository.findById(id);
  }



}
