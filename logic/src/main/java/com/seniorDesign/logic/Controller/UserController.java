package com.seniorDesign.logic.Controller;

import java.util.List;

import com.seniorDesign.logic.Pojo.USERS;
import com.seniorDesign.logic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

@RequestMapping({"/rest/users"})
public class UserController{
    @Autowired
    UserRepository userRepository;


    @GetMapping({"/all"})
    public List<USERS> getAll() {
        return this.userRepository.findAll();
    }

    @PostMapping({"/load"})
    public List<USERS> persist(@RequestBody final USERS users) {
        this.userRepository.save(users);
        return this.userRepository.findAll();
    }
}