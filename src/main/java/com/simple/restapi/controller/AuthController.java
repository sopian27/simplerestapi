package com.simple.restapi.controller;

import com.simple.restapi.domain.User;
import com.simple.restapi.exception.UserNotFoundException;
import com.simple.restapi.request.LoginRequest;
import com.simple.restapi.response.ErrorResponse;
import com.simple.restapi.response.LoginResponse;
import com.simple.restapi.util.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentications", description = "Auth management APIs")
@Controller
@RequestMapping("/auth/v1")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@Validated @RequestBody LoginRequest loginReq)   {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            String email = authentication.getName();
            User user = new User(email,"");
            String token = jwtUtil.createToken(user);
            LoginResponse loginRes = new LoginResponse(email,token);

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            throw new UserNotFoundException("invalid username or password");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}