package com.appliation.rmis.mapper.userMapper;

import com.appliation.rmis.data.models.User;
import com.appliation.rmis.dtos.request.userRequest.staffRequest.StaffSignUpRequest;
import com.appliation.rmis.dtos.response.userResponse.staffResponse.StaffSignUpResponse;
import org.springframework.security.crypto.password.PasswordEncoder;

public class StaffSignUpMapper {
   public static User mapToUser(StaffSignUpRequest staffSignUpRequest){
       User user = new User();
       user.setFirstName(staffSignUpRequest.getFirstName());
       user.setLastName(staffSignUpRequest.getLastName());
       user.setEmailAddress(staffSignUpRequest.getEmailAddress());
       user.setPhoneNumber(Long.parseLong(staffSignUpRequest.getPhoneNumber()));
       return user;

   }

   public static StaffSignUpResponse mapToSignUpResponse(User user){
       StaffSignUpResponse staffSignUpResponse = new StaffSignUpResponse();
       staffSignUpResponse.setId(user.getUserId());
       staffSignUpResponse.setMessage("Successfully Registered !!!");
       return staffSignUpResponse;
   }
}
