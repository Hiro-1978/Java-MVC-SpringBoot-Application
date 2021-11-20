package com.hiro11.fleeapp.services;

import com.hiro11.fleeapp.models.User;
import com.hiro11.fleeapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Get All Users
    public List<User> getUser(){
        return userRepository.findAll();
    }

    //Get User By Id
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    //Delete User
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    //Update User
    public void save(User user) {
        userRepository.save(user);
    }
}
