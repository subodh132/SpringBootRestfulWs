package com.example.SpringBootRestfulWs.services;

import com.example.SpringBootRestfulWs.entities.User;
import com.example.SpringBootRestfulWs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user)
    {

        return userRepository.save(user);
    }
}
