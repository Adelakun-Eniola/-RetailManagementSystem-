package com.appliation.rmis.services.userServices;

import com.appliation.rmis.dtos.request.userRequest.UsersLoginRequest;
import com.appliation.rmis.dtos.request.userRequest.staffRequest.StaffSignUpRequest;
import com.appliation.rmis.dtos.response.userResponse.UserLoginResponse;
import com.appliation.rmis.dtos.response.userResponse.staffResponse.StaffSignUpResponse;

public interface UserService {
    StaffSignUpResponse createAccount(StaffSignUpRequest staffSignUpRequest);
//    UserLoginResponse loginAccount(UsersLoginRequest usersLoginRequest);
}
