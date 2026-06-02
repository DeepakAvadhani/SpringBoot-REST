package com.example.demo.service;

import com.example.demo.dto.CreateUserRequest;
import com.example.demo.dto.UpdateUserRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
 private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(@Valid CreateUserRequest createUserRequest){
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setName(createUserRequest.getName());
        user.setSalary(createUserRequest.getSalary());
        return userRepository.save(user);
    }

    public List<User> getallUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found with id: "+id));
    }

    public User updateUser(Long id, UpdateUserRequest updateUserRequest){
        User existingUser  = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found with id"+id));

        existingUser.setName(updateUserRequest.getName());
        existingUser.setEmail(updateUserRequest.getEmail());
        existingUser.setSalary(updateUserRequest.getSalary());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
