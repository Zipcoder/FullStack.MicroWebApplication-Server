package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Model.User;
import com.beansbeans.moneyapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.nio.cs.US_ASCII;

import javax.transaction.Transactional;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Iterable<User>> create(){
        return new ResponseEntity<Iterable<User>>(userService.findAll(), HttpStatus.OK);
    }

}
