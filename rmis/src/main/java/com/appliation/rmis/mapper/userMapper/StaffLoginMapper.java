package com.appliation.rmis.mapper.userMapper;

import com.appliation.rmis.data.models.User;
import com.appliation.rmis.dtos.request.userRequest.UsersLoginRequest;
import com.appliation.rmis.dtos.response.userResponse.UserLoginResponse;

public class StaffLoginMapper {
    public static User mapToUser(UsersLoginRequest usersLoginRequest){
        User user = new User();
        user.setEmailAddress(usersLoginRequest.getEmailAddress());
        user.setPassword(usersLoginRequest.getPassword());
        return user;
    }

    public static UserLoginResponse mapToUserResponse(User user, String token){
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setRole(user.getRoles());
        userLoginResponse.setToken(token);
        return userLoginResponse;
    }
}
