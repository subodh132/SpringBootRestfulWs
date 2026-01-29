package com.example.SpringBootRestfulWs.repositories;

import com.example.SpringBootRestfulWs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>

{

}
