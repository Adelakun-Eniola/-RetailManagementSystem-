package com.appliation.rmis.services.adminServices;

import com.appliation.rmis.data.models.Roles;
import com.appliation.rmis.data.models.User;
import com.appliation.rmis.data.repository.UserRepository;
import com.appliation.rmis.dtos.request.userRequest.UsersLoginRequest;
import com.appliation.rmis.dtos.request.userRequest.staffRequest.StaffSignUpRequest;
import com.appliation.rmis.dtos.response.userResponse.staffResponse.StaffSignUpResponse;
import com.appliation.rmis.exception.UserNotFoundException;
import com.appliation.rmis.mapper.userMapper.StaffSignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<StaffSignUpResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(StaffSignUpMapper::mapToSignUpResponse)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public User removeUser(String emailAddress) throws UserNotFoundException {
        User user = userRepository.findUserByEmailAddress(emailAddress)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + emailAddress));
        userRepository.delete(user);
        return user;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public StaffSignUpResponse addStaff(StaffSignUpRequest staffSignUpRequest) {
        User user = StaffSignUpMapper.mapToUser(staffSignUpRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Roles.STAFF);
        User savedUser = userRepository.save(user);
        return StaffSignUpMapper.mapToSignUpResponse(savedUser);
    }


//    public User removeUser(String emailAddress) {
//        Optional<User> findUserByEmailAddress = userRepository.findUserByEmailAddress(emailAddress);
//        if(findUserByEmailAddress.isPresent()){
//            userRepository.delete();
//        }
//    }

//    @Override
//    public User removeUser(String emailAddress) {
//        Optional<User> findUserByEmailAddress = userRepository.findUserByEmailAddress(emailAddress);
//        if (findUserByEmailAddress.isEmpty()){
//            throw new RuntimeException("User Not found");
//
//        }
//        User userToDelete =findUserByEmailAddress.get();
//        userRepository.findUserByEmailAddress(String.valueOf(userToDelete));
//        return userToDelete;
//    }

}
