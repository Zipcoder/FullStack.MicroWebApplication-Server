package zipcode.group3.showboat.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zipcode.group3.showboat.model.Comment;
import zipcode.group3.showboat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/admin/all")
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }




}
