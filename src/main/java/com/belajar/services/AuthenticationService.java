package com.belajar.services;

import com.belajar.entities.User;
import com.belajar.repositories.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Business Layer
 */
public class AuthenticationService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        return user.getPassword().equals(password);
    }

//    public boolean authenticate(String username, String password) {
//        return "rahasia".equals(password);
//    }

    public Set<User> getRegularUsers(){
        // cara 1
//        return userRepository.findAll()
//                .stream()
//                .filter(user -> user.isLive() && user.getUserType() == User.UserType.REGULAR_USER)
//                .collect(Collectors.toSet());

        // cara 2 di refactor
        return getUsersByUserType(User.UserType.REGULAR_USER);
    }

    public Set<User> getAdminUsers(){
        // cara 1
//        return userRepository.findAll()
//                .stream()
//                .filter(user -> user.isLive() && user.getUserType() == User.UserType.ADMIN_USER)
//                .collect(Collectors.toSet());

        // cara 2 refactor (Chapter 6.8)
        return getUsersByUserType(User.UserType.ADMIN_USER);
    }

    public Set<User> getUsersByUserType(User.UserType userType){
        return userRepository.findAll()
                .stream()
                .filter(user -> user.isLive() && user.getUserType() == userType)
                .collect(Collectors.toSet());
    }
}
