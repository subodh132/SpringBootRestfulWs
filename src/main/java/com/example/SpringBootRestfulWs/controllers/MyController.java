package com.example.SpringBootRestfulWs.controllers;



import com.example.SpringBootRestfulWs.entities.User;
import com.example.SpringBootRestfulWs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user)
    {
        return userService.createUser(user);

    }

}
