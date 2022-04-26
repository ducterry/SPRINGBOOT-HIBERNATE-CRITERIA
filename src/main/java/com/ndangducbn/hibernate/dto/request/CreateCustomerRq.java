package com.ndangducbn.hibernate.dto.request;

import lombok.Data;

@Data
public class CreateCustomerRq {
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long salary;
}
