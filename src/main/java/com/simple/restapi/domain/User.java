package com.simple.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class User {

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;
    private String firstName;
    private String lastName;


}
