package com.appliation.rmis.services.userServices;

import com.appliation.rmis.data.models.Roles;
import com.appliation.rmis.data.models.User;
import com.appliation.rmis.data.repository.UserRepository;
import com.appliation.rmis.dtos.request.userRequest.UsersLoginRequest;
import com.appliation.rmis.dtos.request.userRequest.staffRequest.StaffSignUpRequest;
import com.appliation.rmis.dtos.response.userResponse.UserLoginResponse;
import com.appliation.rmis.dtos.response.userResponse.staffResponse.StaffSignUpResponse;
import com.appliation.rmis.exception.DuplicateEmailAddress;
import com.appliation.rmis.exception.MissingFieldException;
import com.appliation.rmis.mapper.userMapper.StaffSignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    public StaffSignUpResponse createAccount(StaffSignUpRequest staffSignUpRequest) {
       validations(staffSignUpRequest);

        User user = StaffSignUpMapper.mapToUser(staffSignUpRequest);
        user.setPassword(passwordEncoder.encode(staffSignUpRequest.getPassword()));
        user.setRoles(Roles.STAFF);
        User savedStaff = userRepository.save(user);
        return StaffSignUpMapper.mapToSignUpResponse(savedStaff);
    }

    public UserLoginResponse loginAccount(UsersLoginRequest usersLoginRequest) {
//        User user = new User();
//        Optional<User> adminOptional = userRepository.findUserByEmailAddress(usersLoginRequest.getEmailAddress());
//        if(!passwordEncoder.matches(usersLoginRequest.getPassword(), user.getPassword())){
//        }
//        return new UserLoginResponse();

        Optional<User> userOptional = userRepository.findUserByEmailAddress();
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        User user = userOptional.get();
        if (!passwordEncoder.matches(usersLoginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        UserLoginResponse response = new UserLoginResponse();
//        response.setEmailAddress(user.getEmailAddress());
        response.setRole(Roles.valueOf(user.getRoles().name()));
        return response;
    }






    public  void validations(StaffSignUpRequest staffSignUpRequest){
        if (staffSignUpRequest.getEmailAddress() == null || staffSignUpRequest.getEmailAddress().isEmpty()) {
            throw new MissingFieldException("Email is required");
        }
        if (staffSignUpRequest.getFirstName()== null || staffSignUpRequest.getFirstName().isEmpty()) {
            throw new MissingFieldException("FirstName is required");
        }
        if (staffSignUpRequest.getLastName()== null || staffSignUpRequest.getLastName().isEmpty()) {
            throw new MissingFieldException("LastName is required");
        }
//        if (userRepository.findUserByEmailAddress().isPresent()) {
//            throw new DuplicateEmailAddress("User with this email already exists.");
//        }
    }

}
