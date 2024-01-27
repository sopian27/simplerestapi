package com.simple.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class ApiResponse{

    private HttpStatus status;
    private Object data;

}
