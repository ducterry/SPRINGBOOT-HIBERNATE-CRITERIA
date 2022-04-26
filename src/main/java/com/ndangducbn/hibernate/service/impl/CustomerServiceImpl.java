package com.ndangducbn.hibernate.service.impl;

import com.ndangducbn.hibernate.dao.CustomerDAO;
import com.ndangducbn.hibernate.dto.request.CreateCustomerRq;
import com.ndangducbn.hibernate.dto.response.CustomerRes;
import com.ndangducbn.hibernate.entity.Customer;
import com.ndangducbn.hibernate.mapper.CustomerMapper;
import com.ndangducbn.hibernate.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer detailCustomer(String customerId) {
        try {
            return this.customerDAO.detailCustomer(customerId);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Customer> getListCustomer() {
        try {
            List<Customer> listCustomer = this.customerDAO.getListCustomer();
            return listCustomer;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public CustomerRes createCustomer(CreateCustomerRq request) {
        try {
            Customer entity = CustomerMapper.toEntity(request);
            this.customerDAO.saveCustomer(entity);

            return null;

        } catch (Exception ex) {
            return null;
        }
    }
}
