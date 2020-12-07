package com.belajar.services;

import com.belajar.entities.User;
import com.belajar.repositories.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class UserLookupService {

    private UserRepository userRepository;

    public Set<User> getRegularUsers(){
        return getUsersByUserType(User.UserType.REGULAR_USER);
    }

    public Set<User> getAdminUsers(){
        return getUsersByUserType(User.UserType.ADMIN_USER);
    }

    private Set<User> getUsersByUserType(User.UserType userType) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.isLive() && user.getUserType() == userType)
                .collect(Collectors.toSet());
    }

}
