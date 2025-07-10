package com.appliation.rmis.services.adminServices;

import com.appliation.rmis.data.models.User;
import com.appliation.rmis.data.repository.UserRepository;
import com.appliation.rmis.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> findAllUsers = userRepository.findAll();
        return new ArrayList<>(findAllUsers);
    }

    @Override
    public User removeUser(String mail) {
        Optional<User> findUserByEmailAddress = userRepository.findUserByEmailAddress();
        if (findUserByEmailAddress.isPresent()){
            userRepository.delete(findUserByEmailAddress.get());
            return findUserByEmailAddress.get();
        }

        return new User();
    }
}
