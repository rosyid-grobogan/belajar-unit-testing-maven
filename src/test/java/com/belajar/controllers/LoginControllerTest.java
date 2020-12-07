package com.belajar.controllers;

import com.belajar.services.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class LoginControllerTest {

    private LoginController controller; // SUT

    private AuthenticationService service; // mock

    @Before
    public void setUp() throws Exception {
        this.service = mock(AuthenticationService.class);
        this.controller = new LoginController(this.service);
        // cara 2
        //this.controller = new LoginController(Mockito.mock(AuthenticationService.class));

    }

    @Test
    public void testServiceValidateUsernameAndPasswordLoginUser() {
        // arrange
        when(this.service.authenticate(anyString(), anyString()))
                .thenReturn(true);

        // act
        String viewPath = controller.service("rosyid", "rahasia");

        // assert
        assertNotNull(viewPath);
        assertEquals("/home", viewPath);
    }
}