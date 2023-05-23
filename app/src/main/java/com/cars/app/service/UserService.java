package com.cars.app.service;

import com.cars.app.exception.UserNotFoundException;
import com.cars.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.cars.app.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService{

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User newUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }
    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }

    public User fetchUserById(Long id){
        return userRepository.findUserById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found") );
    }

    public User fetchUserByUsername(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(()-> new UserNotFoundException("User by username " + username + " was not found") );
    }

    public User fetchUserByEmail(String email){
        return userRepository.findUserByEmail(email)
                .orElseThrow(()-> new UserNotFoundException("User by email " + email + " was not found") );
    }

    public void  deleteUser(Long id){
        userRepository.deleteUserById(id);
    }
    public User fetchUserByEmailAndPassword(String email, String password){
        return userRepository.findUserByEmailAndPassword(email,password).orElseThrow(()->new UserNotFoundException("Bad credentials"));
    }

}