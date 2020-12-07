package com.belajar.services;

import com.belajar.entities.User;
import com.belajar.repositories.UserRepository;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.hamcrest.collection.IsIterableContainingInAnyOrder.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserLookupServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserLookupService userLookupService;


//    @Before
//    public void setUp() throws Exception {
//        this.userRepository = mock();
//    }

    // TODO tanpa Hamcrest Assertion
    @Test
    public void getRegularUsers() {
        List<User> userList = new LinkedList<>();

        userList.add(User.createReqularUser("tegar", "rahasia"));
        userList.add(User.createReqularUser("hono", "rahasia"));

        userList.add(User.createAdminUser("dimas", "rahasia"));

        // TODO: arrange
        when(userRepository.findAll()).thenReturn(userList);


        // TODO: act
        Set<User> actualUsers = userLookupService.getRegularUsers();

        // TODO: assert
        assertNotNull(actualUsers);
        assertEquals(actualUsers.size(), 2);

        // cara 1
//        for (User actualUser : actualUsers) {
//            assertNotNull(actualUsers);
//            assertEquals(actualUser.getUserType(), User.UserType.REGULAR_USER);
//        }

        // cara 2
        // check user 1
        User actualUser1 = userList.get(0);
        assertNotNull(actualUser1);
        assertEquals(actualUser1.getUserType(), User.UserType.REGULAR_USER);
        assertEquals(actualUser1.getUsername(), "tegar");
        assertEquals(actualUser1.getPassword(), "rahasia");

        // check user 2
        User actualUser2 = userList.get(1);
        assertNotNull(actualUser2);
        assertEquals(actualUser2.getUserType(), User.UserType.REGULAR_USER);
        assertEquals(actualUser2.getUsername(), "hono");
        assertEquals(actualUser2.getPassword(), "rahasia");

    }

    @Test
    public void getAdminUsers() {
    }

    // TODO menggunakan Hamcrest Assertion
    @Test
    public void getRegularUsersHamcRest() {
        List<User> userList = new LinkedList<>();
        userList.add(User.createReqularUser("tegar", "rahasia"));
        userList.add(User.createReqularUser("hono", "rahasia"));
        userList.add(User.createAdminUser("dimas", "rahasia"));

        // TODO: arrange
        when(userRepository.findAll()).thenReturn(userList);


        // TODO: act
        Set<User> actualUsers = userLookupService.getRegularUsers();

        // TODO: assert
        assertNotNull(actualUsers);
        assertEquals(actualUsers.size(), 2);
        
        assertThat(actualUsers, IsIterableContainingInAnyOrder.containsInAnyOrder(

                /**
                 * TODO: Uji Coba
                 * true: 2 object, 2 user tegar dan hono
                 * error: 1 object user 1 aja
                 * error: 2 object tapi password salah
                 */
                Matchers.equalTo(User.createReqularUser("tegar", "rahasia")),
                Matchers.equalTo(User.createReqularUser("hono", "rahasia"))

        ));

        // cara 1
//        for (User actualUser : actualUsers) {
//            assertNotNull(actualUsers);
//            assertEquals(actualUser.getUserType(), User.UserType.REGULAR_USER);
//        }

        // cara 2
        // check user 1
//        User actualUser1 = actualUsers.get(0);
//        assertNotNull(actualUser1);
//        assertEquals(actualUser1.getUserType(), User.UserType.REGULAR_USER);
//        assertEquals(actualUser1.getUsername(), "tegar");
//        assertEquals(actualUser1.getPassword(), "rahasia");
//
//        // check user 2
//        User actualUser2 = actualUsers.get(1);
//        assertNotNull(actualUser2);
//        assertEquals(actualUser2.getUserType(), User.UserType.REGULAR_USER);
//        assertEquals(actualUser2.getUsername(), "hono");
//        assertEquals(actualUser2.getPassword(), "rahasia");

    }

    // TODO menggunakan Hamcrest Assertion - Complex
    @Test
    public void getRegularUsersHamcRestComplex() {
        List<User> userList = new LinkedList<>();
        userList.add(User.createReqularUser("tegar", "rahasia"));
        userList.add(User.createReqularUser("hono", "rahasia"));
        userList.add(User.createAdminUser("dimas", "rahasia"));

        // TODO: arrange
        when(userRepository.findAll()).thenReturn(userList);


        // TODO: act
        Set<User> actualUsers = userLookupService.getRegularUsers();

        // TODO: assert
        assertNotNull(actualUsers);
        assertEquals(actualUsers.size(), 2);

        /**
         * TODO: Hamcrest Complex
         */
        assertThat(actualUsers, IsIterableContainingInAnyOrder.containsInAnyOrder(
                // TODO Complex
                Matchers.allOf(
                        Matchers.hasProperty("username", Matchers.equalTo("tegar")),
                        Matchers.hasProperty("password", Matchers.equalTo("rahasia"))
                ),
                Matchers.equalTo(User.createReqularUser("hono", "rahasia"))

        ));
    }
}