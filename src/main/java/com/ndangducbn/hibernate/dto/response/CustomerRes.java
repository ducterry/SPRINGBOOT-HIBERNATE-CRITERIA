package com.ndangducbn.hibernate.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public  class CustomerRes {
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long salary;
}

