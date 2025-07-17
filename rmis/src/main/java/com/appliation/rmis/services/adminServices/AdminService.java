package com.appliation.rmis.services.adminServices;

import com.appliation.rmis.data.models.User;
import com.appliation.rmis.dtos.request.userRequest.staffRequest.StaffSignUpRequest;
import com.appliation.rmis.dtos.response.userResponse.staffResponse.StaffSignUpResponse;
import com.appliation.rmis.exception.UserNotFoundException;

import java.util.List;

public interface AdminService {
    List<StaffSignUpResponse> getAllUsers();
    User removeUser(String emailAddress) throws UserNotFoundException;
    StaffSignUpResponse addStaff(StaffSignUpRequest staffSignUpRequest);
}
