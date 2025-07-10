package com.appliation.rmis.data.repository;

import com.appliation.rmis.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
//    Optional<Object> findAdByEmailAddress(String emailAddress);

    Optional<User> findUserByEmailAddress();
}
