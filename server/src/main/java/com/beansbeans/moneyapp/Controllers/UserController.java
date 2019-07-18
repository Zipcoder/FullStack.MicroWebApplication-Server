package com.beansbeans.moneyapp.Controllers;

import com.beansbeans.moneyapp.Model.User;
import com.beansbeans.moneyapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.nio.cs.US_ASCII;

import javax.transaction.Transactional;
import javax.xml.ws.RequestWrapper;

@RestController
@CrossOrigin
@RequestMapping(path= "/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Iterable<User>> findAll(){
        return new ResponseEntity<Iterable<User>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.show(id), HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUserInfo(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
