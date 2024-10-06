package com.ashu.BookReviewApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ashu.BookReviewApplication.model.User;
import com.ashu.BookReviewApplication.repository.UserRepository;
import java.util.Optional;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optionalUser = userRepository.findByUsername(username);
    
    // Check if the user is present in the Optional
    User user = optionalUser.orElseThrow(() -> 
        new UsernameNotFoundException("User not found with username: " + username)
    );

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
}


    public void saveUser(User user) {
        userRepository.save(user);
    }
}
