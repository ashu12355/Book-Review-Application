package com.ashu.BookReviewApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.BookReviewApplication.model.User;
import com.ashu.BookReviewApplication.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public void saveUser(User user){
        userRepository.save(user);
    }


}
