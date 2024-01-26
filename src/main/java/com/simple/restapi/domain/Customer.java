package com.simple.restapi.domain;

import lombok.Data;

@Data
public class Customer {

    private String name;
    private Long id;
    private String address;
    private String phone;
}
