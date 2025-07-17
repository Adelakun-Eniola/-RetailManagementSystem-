package com.appliation.rmis.services.adminServices;

import com.appliation.rmis.data.models.Roles;
import com.appliation.rmis.data.models.User;
import com.appliation.rmis.data.repository.UserRepository;
import com.appliation.rmis.dtos.request.userRequest.UsersLoginRequest;
import com.appliation.rmis.dtos.request.userRequest.staffRequest.StaffSignUpRequest;
import com.appliation.rmis.dtos.response.userResponse.staffResponse.StaffSignUpResponse;
import com.appliation.rmis.exception.UserNotFoundException;
import com.appliation.rmis.services.userServices.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void testThatLogInISSuccessful(){
        UsersLoginRequest usersLoginRequest = new UsersLoginRequest("rmisindustries@company.com", "admin123");

    }
    @BeforeEach
    void deleteDb(){
        userRepository.deleteAll();
    }

    @Test
    @Order(1)
    void testThatUserIsCreated(){
        //given
        StaffSignUpRequest staffSignUpRequest = new StaffSignUpRequest(
                "adeola", "lamide","solape@conglomerate.com","09116061754", "unknown");
        //when
        StaffSignUpResponse staffSignUpResponse = userService.createAccount(staffSignUpRequest);

        //check that
        Assertions.assertNotNull(staffSignUpResponse);
        Assertions.assertEquals("Successfully Registered !!!", staffSignUpResponse.getMessage());
    }



//    @Test
//    void testThatAdminCanDeleteUser(){
//        //given that admin logs in successfully
//        //find by email
//        User user = new User();
//        StaffSignUpRequest staffSignUpRequest = new StaffSignUpRequest();
//        //delete
//       user.setEmailAddress("eniola@conglomerate.com");
////        Optional<User> toBeRemoved =userRepository.findUserByEmailAddress(staffSignUpRequest.getEmailAddress());
//        User removedUser = adminService.removeUser("eniola@conglomerate.com");
//        //check that the user has been deleted
//        Assertions.assertEquals(removedUser, "eniola@conglomerate.com");
//
//    }

//    @Test
//    void testThatAdminCanDeleteUser() {
//        // Given - Create and save user first
//        User user = new User();
//        user.setEmailAddress("solape@conglomerate.com");
//        user.setPassword("unknown");
//        user.setRoles(Roles.STAFF);
////        userRepository.save(user); // MUST save to DB first!
//
//        // When - Delete the user
//        User deletedUser = adminService.removeUser("solape@conglomerate.com");
//
//        // Then - Verify
//        assertNotNull(deletedUser);
//        assertEquals("solape@conglomerate.com", deletedUser.getEmailAddress());
//        assertFalse(userRepository.findUserByEmailAddress("solape@conglomerate.com").isPresent());
//    }

//    @Test
//    void testThatAdminCanGetAllUsers(){
//        //given that admin is loggedIn successfully
//        //when
//        List<User> allUsers = adminService.getAllUsers();
//        //check that
//        Assertions.assertNotNull(allUsers);
//        Assertions.assertFalse(allUsers.isEmpty());
//    }

//    @Test
//    void testThatAdminCanAddStaff(){
//        //given that the admin logs in successfully, navigates to add staff
//        //when (collects the details, add to repo, save and check)
//
//
//    }

//    @Test
//    void testThatUsersCanBeDeleted()  {
//        //given
//        User user = new User();
//        user.setEmailAddress("mide@conglomerate.com");
//        //when\
//        User removedUser = adminService.removeUser("mide@conglomerate.com");
//        //check that
//        Assertions.assertEquals("mide@conglomerate.com", removedUser.getEmailAddress());
//        Assertions.assertFalse(userRepository.findUserByEmailAddress(user.getEmailAddress()).isPresent());
//    }

}