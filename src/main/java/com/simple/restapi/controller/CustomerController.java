package com.simple.restapi.controller;

import com.simple.restapi.dto.CustomerDto;
import com.simple.restapi.response.ApiResponse;
import com.simple.restapi.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Customer", description = "Customer management APIs")
@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCustomer(@PathVariable("id") Long id){
        log.debug("payload {}",id);
        CustomerDto customer = customerService.getCustomer(id);
        log.debug("customer {}",customer);

        return ResponseEntity.ok().
                body(new ApiResponse(HttpStatus.OK,customer));
    }
}
