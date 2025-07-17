package com.appliation.rmis.services.userServices;

import com.appliation.rmis.data.models.Roles;
import com.appliation.rmis.data.models.User;
import com.appliation.rmis.data.repository.UserRepository;
import com.appliation.rmis.dtos.request.userRequest.UsersLoginRequest;
import com.appliation.rmis.dtos.request.userRequest.staffRequest.StaffSignUpRequest;
import com.appliation.rmis.dtos.response.userResponse.UserLoginResponse;
import com.appliation.rmis.dtos.response.userResponse.staffResponse.StaffSignUpResponse;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ActiveProfiles("Test")
public class UserTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;
//
//    @BeforeEach
//    void testThatDbIsCleared(){
//        userRepository.deleteAll();
//    }
//


//    @Test
//    void testThatUserCanLogin(){
//        //given
//        UsersLoginRequest usersLoginRequest = new UsersLoginRequest("eniola@conglomerate.com", "unknown");
//        //when
//        UserLoginResponse userLoginResponse = userService.loginAccount(usersLoginRequest);
//        //check that
//        Assertions.assertNotNull(userLoginResponse);
//        Assertions.assertEquals(Roles.STAFF, userLoginResponse.getRole());
//    }

    @Test
    void testThatStaffCanAddNewStocks(){

    }

}
