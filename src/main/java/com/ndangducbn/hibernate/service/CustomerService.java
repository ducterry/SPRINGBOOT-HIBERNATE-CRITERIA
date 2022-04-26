package com.ndangducbn.hibernate.service;

import com.ndangducbn.hibernate.dto.request.CreateCustomerRq;
import com.ndangducbn.hibernate.dto.response.CustomerRes;
import com.ndangducbn.hibernate.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer detailCustomer(String customerId);
    List<Customer> getListCustomer();

    CustomerRes createCustomer(CreateCustomerRq request);
}
