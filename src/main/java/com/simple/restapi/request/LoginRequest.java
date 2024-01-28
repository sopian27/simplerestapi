package com.simple.restapi.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Email cannot be blank")
    @Length(min = 5, max = 512, message = "Email must be between 5-50 characters")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Length(min = 5, max = 512, message = "Password must be between 5-100 characters")
    private String password;

}
