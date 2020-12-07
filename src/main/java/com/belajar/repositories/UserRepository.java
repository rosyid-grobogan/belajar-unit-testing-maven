package com.belajar.repositories;

import com.belajar.entities.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Persistence Layer
 */
public class UserRepository {

    private Map<String, User> users = new HashMap<String, User>();

    public UserRepository() {
//        users.put("rosyid", new User("rosyid", "rahasia", User.UserType.ADMIN_USER));
//        users.put("panji", new User("panji", "rahasia", User.UserType.REGULAR_USER));

        // regular user
        users.put("panji", User.createReqularUser("panji", "rahasia"));

        // admin user
        users.put("rosyid", User.createAdminUser("rosyid", "rahasia"));
    }

    public User findByUsername(String username){
        return  users.get(username);
    }

    public List<User> findAll(){
        return new LinkedList<>(users.values());
    }
}
