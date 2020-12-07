package com.belajar.services;

import com.belajar.repositories.UserRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class AuthenticationServiceTest {

    private AuthenticationService service; // SUT

    private UserRepository userRepository; // mock

    @Before
    public void setUp() throws Exception {
        this.userRepository = mock(UserRepository.class);
        this.service = new AuthenticationService(this.userRepository);
    }

    @Ignore
    @Test
    public void authenticate() {
        // arrange
        when(this.userRepository.findByUsername(anyString()))
                .thenThrow(new IllegalArgumentException());

        // act
        this.service.authenticate("rosyid", "rahasia");

        // assert
    }
}