package com.belajar.controllers;

import com.belajar.services.AuthenticationService;

/**
 * Presentation Layer
 */
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    public String service(String username, String password){
        // send to /home
        // send to /login

        // cara 1
//        if (authenticationService.authenticate(username, password)){
//            return "/home";
//        } else {
//            return "/login";
//        }

        // cara 2
        return authenticationService.authenticate(username, password) ? "/home" : "/login";
    }
}
