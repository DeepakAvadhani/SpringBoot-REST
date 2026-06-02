package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.CreateUserRequest;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        return userService.createUser(createUserRequest);
    }

    @GetMapping
    public User getUser(){
        return (User) userService.getallUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
