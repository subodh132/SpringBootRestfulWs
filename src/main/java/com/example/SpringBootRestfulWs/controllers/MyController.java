package com.example.SpringBootRestfulWs.controllers;



import com.example.SpringBootRestfulWs.entities.User;
import com.example.SpringBootRestfulWs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user)
    {
        return userService.createUser(user);

    }
    @GetMapping("/user")
    public List<User> getAllUserDetails()
    {
        return userService.getAllUsers();

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable int id)
    {
       User user = userService.getUserDetails(id).orElse(null);
       if (user != null)
       {
           return ResponseEntity.ok().body(user);
       }
       else  {
           return ResponseEntity.notFound().build();

       }
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?>updateUserDetails(@PathVariable int id, @RequestBody User user)
    {
        User updatedUser = userService.updateUserDetails(id, user);
        if (updatedUser != null){
        return ResponseEntity.ok("User With ID" +id+ " updated successfully. ");

        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update Faield :User With id" +id+ " Not Found. ");
        }
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body("User With ID" + id + " has been deleted Successfully. ");
    }

}
