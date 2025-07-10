package com.appliation.rmis.services.adminServices;

import com.appliation.rmis.data.models.User;
import com.appliation.rmis.data.repository.UserRepository;
import com.appliation.rmis.dtos.request.userRequest.UsersLoginRequest;
import com.appliation.rmis.exception.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void testThatLogInISSuccessful(){
        UsersLoginRequest usersLoginRequest = new UsersLoginRequest("rmisindustries@company.com", "admin123");

    }

    @Test
    void testThatAdminCanGetAllUsers(){
        //given that admin is loggedIn successfully
        //when
        List<User> allUsers = adminService.getAllUsers();
        //check that
        Assertions.assertNotNull(allUsers);
        Assertions.assertFalse(allUsers.isEmpty());
    }

//    @Test
//    void testThatUsersCanBeDeleted()  {
//        //given
//        User user = new User();
////        user.setFirstName("ola");
////        user.setLastName("mide");
//        user.setEmailAddress("mide@conglomerate.com");
////        user.setPhoneNumber(Long.parseLong("09116061754"));
//        //when
//        User removedUser = adminService.removeUser("mide@conglomerate.com");
//        //check that
//        Assertions.assertEquals("testuser@example.com", removedUser.getEmailAddress());
//        Assertions.assertFalse(userRepository.findUserByEmailAddress().isPresent());
//    }
}
