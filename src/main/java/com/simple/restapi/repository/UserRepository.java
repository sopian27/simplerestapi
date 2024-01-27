package com.simple.restapi.repository;

import com.simple.restapi.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UserRepository {

    public User findUserByEmail(String email){
        User user = new User();
        user.setEmail(email);
        user.setPassword("123456");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }
}
