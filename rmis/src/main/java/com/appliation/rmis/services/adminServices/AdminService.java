package com.appliation.rmis.services.adminServices;

import com.appliation.rmis.data.models.User;
import com.appliation.rmis.exception.UserNotFoundException;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers();

    User removeUser(String mail) throws UserNotFoundException;
}
