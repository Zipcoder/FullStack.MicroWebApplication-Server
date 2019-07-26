package com.zipcodewilmington.videoproject.controllers;

import com.zipcodewilmington.videoproject.models.User;
import com.zipcodewilmington.videoproject.models.UserJson;
import com.zipcodewilmington.videoproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping(value = "/users/{userId}")
    public UserJson getVideoComments(@PathVariable("userId") String userId) {
        return service.getUserJson(userId);
    }

    @PostMapping(value = "/users")
    public void postUserJson(@RequestBody UserJson userJson) {
        service.postUserJson(userJson);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Iterable<User>> getUsers() {
      return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable String id) {
      return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

}
